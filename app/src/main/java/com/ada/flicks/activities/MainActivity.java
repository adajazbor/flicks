package com.ada.flicks.activities;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ada.flicks.R;
import com.ada.flicks.adapters.ItemAdapter;
import com.ada.flicks.fragments.ItemDetailFragment;
import com.ada.flicks.fragments.ItemEditFragment;
import com.ada.flicks.models.Item;
import com.ada.flicks.network.TheMovieDB;
import com.ada.flicks.network.dto.nowplaying.Response;
import com.ada.flicks.network.dto.nowplaying.Result;
import com.ada.flicks.utils.Constants;
import com.ada.flicks.utils.Utils;
import com.loopj.android.http.TextHttpResponseHandler;

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

        // Lookup the swipe container view
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
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
                        Result item = todoItems.get(position);
                        showDetailDialog(item);
                    }
                });
        readItems();
    }

    public void onAddItemButtonClicked(View view) {
        ItemEditFragment fragment = ItemEditFragment.newInstance(
                new ItemEditFragment.EditItemDialogListener() {
                    @Override
                    public void onItemSaved(Parcelable parcel) {
                        onDataChanged(true);
                    }
                },
                getString(R.string.title_item_add),
                new Item());

        fragment.showFragment(getSupportFragmentManager(), null);
    }

    private void showDetailDialog(Result item) {
        ItemDetailFragment detailDialogFragment = ItemDetailFragment.newInstance(
                new ItemDetailFragment.DetailItemDialogListener() {
                    @Override
                    public void onDataChanged() {
                        MainActivity.this.onDataChanged(false);
                    }
                },
                item);
        detailDialogFragment.show(getSupportFragmentManager(), Constants.FRAGMENT_EDIT_ITEM);
    }

    private void onDataChanged(boolean scrollToLastItem) {
        readItems();
        if (scrollToLastItem) {
            llmLayoutManager.smoothScrollToPosition(rvItems, null, todoItems.size() - 1);
        }
    }

//==== database opperations

    private boolean readItems() {
        TheMovieDB.getMovieList(getMovieListResponseHandler());
        return true;
    }

    private TextHttpResponseHandler getMovieListResponseHandler() {
        return new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable throwable) {
                //Toast.makeText(this, R.string.error_read_item, Toast.LENGTH_LONG).show();
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
