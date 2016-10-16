package com.ada.flicks.activities;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ada.flicks.R;
import com.ada.flicks.network.dto.nowplaying.Result;
import com.ada.flicks.utils.Constants;
import com.ada.flicks.utils.Utils;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class DetailActivity extends YouTubeBaseActivity {

    private Result mItem;

    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.tvOverview)  TextView tvOverview;
    @BindView(R.id.tvPopularity)  TextView tvPopularity;
    @BindView(R.id.rbRating)  RatingBar rbRating;
    @BindView(R.id.tvRelease)  TextView tvRelease;
    @BindView(R.id.player)  YouTubePlayerView ytpVideo;
    @BindView(R.id.ivMovieImage)  ImageView ivMovieImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mItem = Parcels.unwrap(getIntent().getParcelableExtra(Constants.PARAM_ITEM));

        ButterKnife.bind(this);
        LayerDrawable stars = (LayerDrawable) rbRating.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(1).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(0).setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);

        refreshUiFromItem();
    }

    private void refreshUiFromItem() {
        if (mItem.getYouTubeTrailerKey() != null) {
            ivMovieImage.setVisibility(View.INVISIBLE);
            ytpVideo.setVisibility(View.VISIBLE);
            ytpVideo.initialize(Constants.YOUTUBE_API_KEY,
                    new YouTubePlayer.OnInitializedListener() {
                        @Override
                        public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                            YouTubePlayer youTubePlayer, boolean b) {

                            // do any work here to cue video, play video, etc.
                            if (mItem.getVoteAverage() > 5.0) {
                                youTubePlayer.loadVideo(mItem.getYouTubeTrailerKey());
                            } else {
                                youTubePlayer.cueVideo(mItem.getYouTubeTrailerKey());
                            }
                        }
                        @Override
                        public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                            YouTubeInitializationResult youTubeInitializationResult) {
                            setMovieImage();
                        }
                    });

        } else {
            setMovieImage();
        }

        tvTitle.setText(mItem.getTitle());
        tvRelease.setText(mItem.getReleaseDate());
        tvOverview.setText(mItem.getOverview());
        tvPopularity.setText(mItem.getPopularity().toString());
        rbRating.setRating(mItem.getVoteAverage().floatValue()/2);
    }

    private void setMovieImage() {
        ytpVideo.setVisibility(View.INVISIBLE);
        ivMovieImage.setVisibility(View.VISIBLE);
        Picasso.with(this).load(mItem.getFullBackdropPath(Result.BackDropSize.original))
                .resize(Utils.getDisplayWidth(this), 0)
                .transform(new RoundedCornersTransformation(10, 10))
                //.fit().centerCrop()
                .placeholder(R.drawable.ic_rotate_left_white_24dp)
                .error(R.drawable.ic_block_white_24dp)
                .into(ivMovieImage);
    }


    @OnClick(R.id.btnBack)
    public void onClick(View view) {
        finish();
    }
}
