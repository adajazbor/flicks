package com.ada.flicks.models;

import com.raizlabs.android.dbflow.structure.BaseModel;

import org.parceler.Parcel;

import java.util.Arrays;
import java.util.Date;

//@Table(database = FlicksDatabase.class)
@Parcel(analyze={Item.class})
public class Item extends BaseModel {

    private String voteAverage;

    private String backdropPath;

    private Boolean adult;

    private Long id;

    private String title;

    private String overview;

    private String originalLanguage;

    private Integer[] genreIds;

    private Date releaseDate;

    private String originalTitle;

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Integer[] getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(Integer[] genreIds) {
        this.genreIds = genreIds;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Long getPopularity() {
        return popularity;
    }

    public void setPopularity(Long popularity) {
        this.popularity = popularity;
    }

    private Integer voteCount;

    private String posterPath;

    private Boolean video;

    private Long popularity;

    @Override
    public String toString() {
        return "Item{" +
                "voteAverage='" + voteAverage + '\'' +
                ", backdropPath='" + backdropPath + '\'' +
                ", adult=" + adult +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", genreIds=" + Arrays.toString(genreIds) +
                ", releaseDate=" + releaseDate +
                ", originalTitle='" + originalTitle + '\'' +
                ", voteCount=" + voteCount +
                ", posterPath='" + posterPath + '\'' +
                ", video=" + video +
                ", popularity=" + popularity +
                '}';
    }

}
