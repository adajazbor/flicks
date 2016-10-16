package com.ada.flicks.network.dto.trailer;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ada on 10/16/16.
 */
public class Response {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("results")
    @Expose
    private List<Trailer> trailers = new ArrayList<Trailer>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailer> results) {
        this.trailers = results;
    }

    public Trailer getFirstTrailer() {
        for (Trailer trailer : getTrailers()) {
            if (Trailer.trailerType.Trailer.name().equals(trailer.getType())) {
                return trailer;
            }
        }
        return null;
    }

}
