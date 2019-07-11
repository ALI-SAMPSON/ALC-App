package com.google.alc.app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.alc.app.ui.ActivityB;
import com.google.alc.app.ui.ActivityC;

public class ActivityA extends AppCompatActivity implements View.OnClickListener{

    // Class Instance Variables
    Button aboutButton, profileButton;

    Toolbar toolbar;

    TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        // getting reference to ids
        toolbar = findViewById(R.id.toolbar);
        toolbar_title = findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        // getting reference to ids
        aboutButton = findViewById(R.id.button_about);
        profileButton = findViewById(R.id.button_profile);

        // attaching on click listener to buttons
        aboutButton.setOnClickListener(this);
        profileButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_about:{

                navigateToAboutALCPage();

                break;
            }
            case R.id.button_profile:{

                navigateToProfilePage();

                break;
            }
            default:{
                break;
            }
        }
    }

    // navigate user to about page
    private void navigateToAboutALCPage() {
        startActivity(new Intent(ActivityA.this, ActivityB.class));
    }

    // navigate user to profile page
    private void navigateToProfilePage() {
        startActivity(new Intent(ActivityA.this, ActivityC.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
