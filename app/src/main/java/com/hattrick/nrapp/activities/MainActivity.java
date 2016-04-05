package com.hattrick.nrapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hattrick.nrapp.R;

public class MainActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Button buttonPeople = (Button)findViewById(R.id.button_people);
        Button buttonPlanets = (Button)findViewById(R.id.button_planets);
        Button buttonStarships = (Button)findViewById(R.id.button_starships);

        buttonPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent peopleIntent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(peopleIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
