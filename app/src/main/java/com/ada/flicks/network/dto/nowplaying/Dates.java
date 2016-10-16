package com.ada.flicks.network.dto.nowplaying;

import java.util.Date;

/**
 * Created by ada on 10/15/16.
 */
public class Dates {
    private Date maximum;
    private Date minimum;

    public Date getMaximum() {
        return maximum;
    }

    public void setMaximum(Date maximum) {
        this.maximum = maximum;
    }

    public Date getMinimum() {
        return minimum;
    }

    public void setMinimum(Date minimum) {
        this.minimum = minimum;
    }
}
