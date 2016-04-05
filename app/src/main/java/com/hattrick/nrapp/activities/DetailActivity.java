package com.hattrick.nrapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.hattrick.nrapp.R;

public class DetailActivity extends AppCompatActivity {

    private String mName;
    private String mMass;
    private String mHeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        String mName = getIntent().getStringExtra("name");
        String mMass = getIntent().getStringExtra("mass");
        String mHeight = getIntent().getStringExtra("height");

        setTitle(mName);


        TextView textViewName = (TextView)findViewById(R.id.textview_name);
        TextView textViewMass = (TextView)findViewById(R.id.textview_mass);
        TextView textViewHeight = (TextView)findViewById(R.id.textview_height);

        textViewName.setText(mName);
        textViewMass.setText(mMass);
        textViewHeight.setText(mHeight);


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
