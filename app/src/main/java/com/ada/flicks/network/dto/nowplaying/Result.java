package com.ada.flicks.network.dto.nowplaying;

import android.util.Log;

import com.ada.flicks.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ada on 10/15/16.
 */
@Parcel
public class Result {

    public enum BackDropSize {
        w300,
        w780,
        w1280,
        original
    }

    public enum PosterSize {
        w92,
        w154,
        w185,
        w342,
        w500,
        w780,
        original
    }

        @SerializedName("poster_path")
        @Expose
        String posterPath;
        @SerializedName("adult")
        @Expose
        Boolean adult;
        @SerializedName("overview")
        @Expose
        String overview;
        @SerializedName("release_date")
        @Expose
        String releaseDate;
        @SerializedName("genre_ids")
        @Expose
        List<Integer> genreIds = new ArrayList<Integer>();
        @SerializedName("id")
        @Expose
        Integer id;
        @SerializedName("original_title")
        @Expose
        String originalTitle;
        @SerializedName("original_language")
        @Expose
        String originalLanguage;
        @SerializedName("title")
        @Expose
        String title;
        @SerializedName("backdrop_path")
        @Expose
        String backdropPath;
        @SerializedName("popularity")
        @Expose
        Double popularity;
        @SerializedName("vote_count")
        @Expose
        Integer voteCount;
        @SerializedName("video")
        @Expose
        Boolean video;
        @SerializedName("vote_average")
        @Expose
        Double voteAverage;

        String youTubeTrailerKey;


    /**
         * No args constructor for use in serialization
         */
        public Result() {
        }

        /**
         * @param id
         * @param genreIds
         * @param title
         * @param releaseDate
         * @param overview
         * @param posterPath
         * @param originalTitle
         * @param voteAverage
         * @param originalLanguage
         * @param adult
         * @param backdropPath
         * @param voteCount
         * @param video
         * @param popularity
         */
        public Result(String posterPath, Boolean adult, String overview, String releaseDate, List<Integer> genreIds, Integer id, String originalTitle, String originalLanguage, String title, String backdropPath, Double popularity, Integer voteCount, Boolean video, Double voteAverage) {
            this.posterPath = posterPath;
            this.adult = adult;
            this.overview = overview;
            this.releaseDate = releaseDate;
            this.genreIds = genreIds;
            this.id = id;
            this.originalTitle = originalTitle;
            this.originalLanguage = originalLanguage;
            this.title = title;
            this.backdropPath = backdropPath;
            this.popularity = popularity;
            this.voteCount = voteCount;
            this.video = video;
            this.voteAverage = voteAverage;
        }

        /**
         * @return The posterPath
         */
        public String getPosterPath() {
            return posterPath;
        }

        public String getFullPosterPath(PosterSize size) {
            if (size == null) {
                size = PosterSize.w185;
            }
            String url = new StringBuilder(Constants.FULL_URL_PREFIX).append(size).append(this.getPosterPath()).toString();
            Log.d("Result", url);
            return url;
        }

        /**
         * @param posterPath The poster_path
         */
        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        /**
         * @return The adult
         */
        public Boolean getAdult() {
            return adult;
        }

        /**
         * @param adult The adult
         */
        public void setAdult(Boolean adult) {
            this.adult = adult;
        }

        /**
         * @return The overview
         */
        public String getOverview() {
            return overview;
        }

        /**
         * @param overview The overview
         */
        public void setOverview(String overview) {
            this.overview = overview;
        }

        /**
         * @return The releaseDate
         */
        public String getReleaseDate() {
            return releaseDate;
        }

        /**
         * @param releaseDate The release_date
         */
        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        /**
         * @return The genreIds
         */
        public List<Integer> getGenreIds() {
            return genreIds;
        }

        /**
         * @param genreIds The genre_ids
         */
        public void setGenreIds(List<Integer> genreIds) {
            this.genreIds = genreIds;
        }

        /**
         * @return The id
         */
        public Integer getId() {
            return id;
        }

        /**
         * @param id The id
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         * @return The originalTitle
         */
        public String getOriginalTitle() {
            return originalTitle;
        }

        /**
         * @param originalTitle The original_title
         */
        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        /**
         * @return The originalLanguage
         */
        public String getOriginalLanguage() {
            return originalLanguage;
        }

        /**
         * @param originalLanguage The original_language
         */
        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        /**
         * @return The title
         */
        public String getTitle() {
            return title;
        }

        /**
         * @param title The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * @return The backdropPath
         */
        public String getBackdropPath() {
            return backdropPath;
        }

        /**
         * @param backdropPath The backdrop_path
         */
        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        public String getFullBackdropPath(BackDropSize size) {
            if (size == null) {
                size = BackDropSize.w300;
            }
            String url = new StringBuilder(Constants.FULL_URL_PREFIX).append(size).append(this.getBackdropPath()).toString();
            Log.d("Result", url);
            return url;
        }

        /**
         * @return The popularity
         */
        public Double getPopularity() {
            return popularity;
        }

        /**
         * @param popularity The popularity
         */
        public void setPopularity(Double popularity) {
            this.popularity = popularity;
        }

        /**
         * @return The voteCount
         */
        public Integer getVoteCount() {
            return voteCount;
        }

        /**
         * @param voteCount The vote_count
         */
        public void setVoteCount(Integer voteCount) {
            this.voteCount = voteCount;
        }

        /**
         * @return The video
         */
        public Boolean getVideo() {
            return video;
        }

        /**
         * @param video The video
         */
        public void setVideo(Boolean video) {
            this.video = video;
        }

        /**
         * @return The voteAverage
         */
        public Double getVoteAverage() {
            return voteAverage;
        }

        /**
         * @param voteAverage The vote_average
         */
        public void setVoteAverage(Double voteAverage) {
            this.voteAverage = voteAverage;
        }


        public String getYouTubeTrailerKey() {
            return youTubeTrailerKey;
        }

        public void setYouTubeTrailerKey(String youTubeTrailerKey) {
            this.youTubeTrailerKey = youTubeTrailerKey;
        }
    }