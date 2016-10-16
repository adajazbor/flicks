package com.ada.flicks.activities;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ada.flicks.R;
import com.ada.flicks.network.dto.nowplaying.Result;
import com.ada.flicks.utils.Constants;
import com.ada.flicks.utils.Utils;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    private Result mItem;
    private String[] mPriorities;

    private TextView tvTitle;
    private TextView tvOverview;
    private TextView tvPopularity;
    private RatingBar rbRating;
    private TextView tvRelease;
    private ImageView ivMovieImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mItem = Parcels.unwrap(getIntent().getParcelableExtra(Constants.PARAM_ITEM));
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvOverview = (TextView) findViewById(R.id.tvOverview);
        tvPopularity = (TextView) findViewById(R.id.tvPopularity);
        rbRating = (RatingBar) findViewById(R.id.rbRating);
        tvRelease = (TextView) findViewById(R.id.tvRelease);
        ivMovieImage = (ImageView) findViewById(R.id.ivMovieImage);
        LayerDrawable stars = (LayerDrawable) rbRating.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(1).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(0).setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);

        refreshUiFromItem();

        Button btnBack = (Button) findViewById(R.id.btnBack);
        View.OnClickListener onBack = getOnBackListener();
        btnBack.setOnClickListener(onBack);
    }

    private void refreshUiFromItem() {
        Picasso.with(this).load(mItem.getFullBackdropPath(Result.BackDropSize.w1280))
                .resize(Utils.getDisplayWidth(this), 0)
                .placeholder(R.drawable.ic_rotate_left_white_24dp)
                .error(R.drawable.ic_block_white_24dp)
                .into(ivMovieImage);
        tvTitle.setText(mItem.getTitle());
        tvRelease.setText(mItem.getReleaseDate());
        tvOverview.setText(mItem.getOverview());
        tvPopularity.setText(mItem.getPopularity().toString());
        rbRating.setRating(mItem.getVoteAverage().floatValue()/2);
    }

    private View.OnClickListener getOnBackListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
    }
}
