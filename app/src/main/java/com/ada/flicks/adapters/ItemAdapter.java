package com.ada.flicks.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ada.flicks.R;
import com.ada.flicks.network.dto.nowplaying.Result;
import com.ada.flicks.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ada on 9/13/16.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private final static int [] mPriorityStyles = new int [] {
            R.style.priorityFontLow,
            R.style.priorityFontMedium,
            R.style.priorityFontHigh};

    private List<Result> mItems;
    private ItemArrayAdapterDelegate mDelegate;
    private Context mContext;

    public interface ItemArrayAdapterDelegate {
        boolean onLongClick(int position);
        void onClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvOverview;
        public TextView tvTitle;
        public ImageView ivMovieImage;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            tvOverview = (TextView) itemView.findViewById(R.id.tvOverview);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            ivMovieImage = (ImageView) itemView.findViewById(R.id.ivMovieImage);

            /*
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return mDelegate.onLongClick(getAdapterPosition());
                }
            });
            */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDelegate.onClick(getAdapterPosition());
                }
            });

        }
    }

    // Pass in the contact array into the constructor
    public ItemAdapter(Context context, List<Result> items, ItemArrayAdapterDelegate delegate) {
        mItems = items;
        mContext = context;
        mDelegate = delegate;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View itemRowView = inflater.inflate(R.layout.item_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(itemRowView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Result item = mItems.get(position);
        // Set item views based on your views and data model
        viewHolder.tvOverview.setText(item.getOverview());
        viewHolder.tvTitle.setText(item.getTitle());
        String photoURL = item.getFullPosterPath(Result.PosterSize.w342);
        int oryWidth = Utils.getDisplayWidth(getContext());
        int width = oryWidth * 3 / 5;
        if (Configuration.ORIENTATION_LANDSCAPE == getContext().getResources().getConfiguration().orientation) {
            photoURL = item.getFullBackdropPath(Result.BackDropSize.w780);
        }
        Picasso.with(getContext()).load(photoURL)
                .resize(width, 0)
                .placeholder(R.drawable.ic_rotate_left_white_24dp)
                .error(R.drawable.ic_block_white_24dp)
                .into(viewHolder.ivMovieImage);
        //.fit().centerInside()
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        if(mItems == null) {
            return 0;
        }
        return mItems.size();
    }

    // Clean all elements of the recycler
    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    // Add a list of items
    public void addAll(List<Result> list) {
        mItems.addAll(list);
        notifyDataSetChanged();
    }
}
