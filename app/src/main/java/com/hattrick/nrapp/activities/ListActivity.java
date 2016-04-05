package com.hattrick.nrapp.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.hattrick.nrapp.R;
import com.hattrick.nrapp.adapters.ItemsAdapter;
import com.hattrick.nrapp.model.CollectionPeople;
import com.hattrick.nrapp.model.People;
import com.hattrick.nrapp.network.APIError;
import com.hattrick.nrapp.network.ApiClient;
import com.hattrick.nrapp.network.ErrorUtils;
import com.hattrick.nrapp.network.ServiceGenerator;
import com.hattrick.nrapp.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    private List<People> mPeople;
    private RecyclerView mRvPeople;
    private ItemsAdapter mAdapter;
    private ProgressDialog mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle(R.string.title_activity_list);

        mProgressBar = Utils.createProgressDialog(this);
        mPeople = new ArrayList<>();


        // Lookup the recyclerview in activity layout
        mRvPeople = (RecyclerView) findViewById(R.id.rvItems);

        // Create adapter passing in the sample user data
        mAdapter = new ItemsAdapter(mPeople);
        // Attach the adapter to the recyclerview to populate items
        mRvPeople.setAdapter(mAdapter);
        // Set layout manager to position the items
        mRvPeople.setLayoutManager(new LinearLayoutManager(ListActivity.this));

    }

    @Override
    protected void onResume() {
        super.onResume();

        mPeople.clear();
        mProgressBar.show();
        getPeople();
    }

    private void getPeople() {
        ApiClient service = ServiceGenerator.createService(ApiClient.class);
        Call<CollectionPeople> call = service.getPeople();
        call.enqueue(new Callback<CollectionPeople>() {
            @Override
            public void onResponse(Call<CollectionPeople> call, Response<CollectionPeople> response) {
                if (response.isSuccessful()) {
                    // request successful (status code 200, 201)
                    CollectionPeople result = response.body();
                    Log.d("body", String.valueOf(result.getCount()));

                    mPeople.addAll(result.getResults());

                    mAdapter.notifyDataSetChanged();

                    mProgressBar.dismiss();


                } else {
                    //request not successful (like 400,401,403 etc)
                    //Handle errors
                    // parse the response body …
                    APIError error = ErrorUtils.parseError(response);
                    // … and use it to show error information

                    // … or just log the issue like we’re doing :)
                    Log.d("error message", error.message());
                }
            }

            @Override
            public void onFailure(Call<CollectionPeople> call, Throwable t) {
                Log.d("Error", "Something happened: " + t.getMessage());
            }

        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return false;
        }


        return super.onOptionsItemSelected(item);
    }





}
