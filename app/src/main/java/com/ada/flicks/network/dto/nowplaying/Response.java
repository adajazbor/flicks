package com.ada.flicks.network.dto.nowplaying;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by ada on 10/15/16.
 */
public class Response {

        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("results")
        @Expose
        private List<Result> results = new ArrayList<Result>();
        @SerializedName("dates")
        @Expose
        private Dates dates;
        @SerializedName("total_pages")
        @Expose
        private Integer totalPages;
        @SerializedName("total_results")
        @Expose
        private Integer totalResults;

        /**
         * No args constructor for use in serialization
         *
         */
        public Response() {
        }

        /**
         *
         * @param results
         * @param totalResults
         * @param dates
         * @param page
         * @param totalPages
         */
        public Response(Integer page, List<Result> results, Dates dates, Integer totalPages, Integer totalResults) {
            this.page = page;
            this.results = results;
            this.dates = dates;
            this.totalPages = totalPages;
            this.totalResults = totalResults;
        }

        /**
         *
         * @return
         * The page
         */
        public Integer getPage() {
            return page;
        }

        /**
         *
         * @param page
         * The page
         */
        public void setPage(Integer page) {
            this.page = page;
        }

        /**
         *
         * @return
         * The results
         */
        public List<Result> getResults() {
            return results;
        }

        /**
         *
         * @param results
         * The results
         */
        public void setResults(List<Result> results) {
            this.results = results;
        }

        /**
         *
         * @return
         * The dates
         */
        public Dates getDates() {
            return dates;
        }

        /**
         *
         * @param dates
         * The dates
         */
        public void setDates(Dates dates) {
            this.dates = dates;
        }

        /**
         *
         * @return
         * The totalPages
         */
        public Integer getTotalPages() {
            return totalPages;
        }

        /**
         *
         * @param totalPages
         * The total_pages
         */
        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        /**
         *
         * @return
         * The totalResults
         */
        public Integer getTotalResults() {
            return totalResults;
        }

        /**
         *
         * @param totalResults
         * The total_results
         */
        public void setTotalResults(Integer totalResults) {
            this.totalResults = totalResults;
        }
}
