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

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by ada on 9/13/16.
 */
public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int POSTER = 0, VIDEO = 1;
    private List<Result> mItems;
    private ItemArrayAdapterDelegate mDelegate;
    private Context mContext;

    public interface ItemArrayAdapterDelegate {
        boolean onLongClick(int position);
        void onClick(int position);
    }

    public class ViewHolderPoster extends RecyclerView.ViewHolder {
        @BindView(R.id.tvOverview) TextView tvOverview;
        @BindView(R.id.tvTitle) TextView tvTitle;
        @BindView(R.id.ivMovieImage) ImageView ivMovieImage;

        public ViewHolderPoster(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDelegate.onClick(getAdapterPosition());
                }
            });
        }
    }

    public class ViewHolderVideo extends RecyclerView.ViewHolder {
        @BindView(R.id.ivMovieImage) ImageView ivMovieImage;

        public ViewHolderVideo(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        switch (viewType) {
            case VIDEO:
                viewHolder = new ViewHolderVideo(inflater.inflate(R.layout.video_item, parent, false));
                break;
            default:
                viewHolder = new ViewHolderPoster(inflater.inflate(R.layout.item_item, parent, false));
                break;
        }
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case VIDEO:
                ViewHolderVideo vh1 = (ViewHolderVideo) viewHolder;
                configureViewHolderVideo(vh1, position);
                break;
            default:
                ViewHolderPoster vh2 = (ViewHolderPoster) viewHolder;
                configureViewHolderPoster(vh2, position);
                break;
        }
    }

    private void configureViewHolderPoster(ViewHolderPoster viewHolder, int position) {
        Result item = mItems.get(position);
        viewHolder.tvOverview.setText(item.getOverview());
        viewHolder.tvTitle.setText(item.getTitle());
        String photoURL = item.getFullPosterPath(Result.PosterSize.w342);
        int oryWidth = Utils.getDisplayWidth(getContext());
        int width = oryWidth / 2;
        if (Configuration.ORIENTATION_LANDSCAPE == getContext().getResources().getConfiguration().orientation) {
            photoURL = item.getFullBackdropPath(Result.BackDropSize.original);
            int with = oryWidth * 2 / 3;
        }
        Picasso.with(getContext()).load(photoURL)
                .resize(width, 0)
                .transform(new RoundedCornersTransformation(10, 10))
                .placeholder(R.drawable.ic_rotate_left_white_24dp)
                .error(R.drawable.ic_block_white_24dp)
                .into(viewHolder.ivMovieImage);
    }

    private void configureViewHolderVideo(ViewHolderVideo viewHolder, int position) {
        Result item = mItems.get(position);
        //viewHolder.tvOverview.setText(item.getOverview());
        //viewHolder.tvTitle.setText(item.getTitle());
        String photoURL = item.getFullBackdropPath(Result.BackDropSize.original);
        int oryWidth = Utils.getDisplayWidth(getContext());
        int width = oryWidth;
        if (Configuration.ORIENTATION_LANDSCAPE == getContext().getResources().getConfiguration().orientation) {
            int with = oryWidth;
        }
        Picasso.with(getContext()).load(photoURL)
                .resize(width, 0)
                .transform(new RoundedCornersTransformation(10, 10))
                .placeholder(R.drawable.ic_rotate_left_white_24dp)
                .error(R.drawable.ic_block_white_24dp)
                .into(viewHolder.ivMovieImage);
    }


    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        if(mItems == null) {
            return 0;
        }
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        Result item = mItems.get(position);
        if (item.getVoteAverage() > 5.0) {
            return VIDEO;
        }
        return POSTER;
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
