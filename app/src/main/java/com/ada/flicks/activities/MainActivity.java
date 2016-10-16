package com.ada.flicks.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ada.flicks.R;
import com.ada.flicks.adapters.ItemAdapter;
import com.ada.flicks.network.TheMovieDB;
import com.ada.flicks.network.dto.nowplaying.Response;
import com.ada.flicks.network.dto.nowplaying.Result;
import com.ada.flicks.utils.Constants;
import com.ada.flicks.utils.Utils;
import com.loopj.android.http.TextHttpResponseHandler;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private List<Result> todoItems = new ArrayList<>();
    private ItemAdapter aToDoAdapter;
    private RecyclerView rvItems;
    private LinearLayoutManager llmLayoutManager;
    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateArrayItems();
        rvItems = (RecyclerView) findViewById(R.id.rvItems);
        llmLayoutManager = new LinearLayoutManager(this);
        rvItems.setLayoutManager(llmLayoutManager);
        rvItems.setAdapter(aToDoAdapter);

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                readItems();
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

    }

    public void populateArrayItems() {
        aToDoAdapter = new ItemAdapter(
                this,
                todoItems,
                new ItemAdapter.ItemArrayAdapterDelegate() {
                    @Override
                    public boolean onLongClick(int position) {
                        return true;
                    }

                    @Override
                    public void onClick(int position) {
                        Intent i = new Intent(MainActivity.this, DetailActivity.class);
                        i.putExtra(Constants.PARAM_ITEM, Parcels.wrap(todoItems.get(position)));
                        startActivity(i);
                    }
                });
        readItems();
    }


//==== data opperations
    private boolean readItems() {
        TheMovieDB.getMovieList(getMovieListResponseHandler());
        return true;
    }

    private TextHttpResponseHandler getMovieListResponseHandler() {
        return new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable throwable) {
                Log.e(this.getClass().getName(), "Cannot load data");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String res) {
                Response reponse = Utils.parseJSON(res, Response.class);
                todoItems.clear();
                todoItems.addAll(reponse.getResults());
                aToDoAdapter.notifyDataSetChanged();
                swipeContainer.setRefreshing(false);
            }
        };
    }

}
