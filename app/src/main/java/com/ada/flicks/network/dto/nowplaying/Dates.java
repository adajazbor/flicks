package com.ada.flicks.network.dto.nowplaying;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ada on 10/15/16.
 */
public class Dates {

    @SerializedName("maximum")
    @Expose
    private String maximum;
    @SerializedName("minimum")
    @Expose
    private String minimum;

    /**
     * No args constructor for use in serialization
     */
    public Dates() {
    }

    /**
     * @param minimum
     * @param maximum
     */
    public Dates(String maximum, String minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

    /**
     * @return The maximum
     */
    public String getMaximum() {
        return maximum;
    }

    /**
     * @param maximum The maximum
     */
    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    /**
     * @return The minimum
     */
    public String getMinimum() {
        return minimum;
    }

    /**
     * @param minimum The minimum
     */
    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

}
