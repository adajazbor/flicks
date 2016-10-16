package com.ada.flicks.network.dto.nowplaying;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ada on 10/15/16.
 */
public class Response {
    private long page;
    private List<Result> results;
    private Dates dates;
    private long total_pages;
    private long total_results;

    public Response() {
        results = new ArrayList<Result>();
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public long getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(long total_pages) {
        this.total_pages = total_pages;
    }

    public long getTotal_results() {
        return total_results;
    }

    public void setTotal_results(long total_results) {
        this.total_results = total_results;
    }

}
