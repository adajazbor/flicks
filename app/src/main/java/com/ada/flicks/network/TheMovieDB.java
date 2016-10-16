package com.ada.flicks.network;

import com.ada.flicks.utils.Constants;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

/**
 * Created by ada on 10/15/16.
 */
public class TheMovieDB {

    public static void getMovieList(TextHttpResponseHandler responseHandler) {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("api_key", Constants.THE_MOVIE_DB_API_KEY);
        client.get(Constants.THE_MOVIE_DB_URL, params, responseHandler);
    }
}
