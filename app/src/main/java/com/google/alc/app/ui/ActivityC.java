package com.google.alc.app.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.alc.app.R;

public class ActivityC extends AppCompatActivity {

    // Class Instance Variables
    Toolbar toolbar;
    TextView toolbar_title;
    ImageView profile_image;
    TextView tvTrack,tvCountry,tvEmail,tvPhone,tvSlackUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        // getting reference to ids
        toolbar = findViewById(R.id.toolbar);
        toolbar_title = findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Getting reference to ids
        profile_image = findViewById(R.id.profile_image);
        tvTrack = findViewById(R.id.tv_track);
        tvCountry = findViewById(R.id.tv_country);
        tvEmail = findViewById(R.id.tv_email);
        tvPhone = findViewById(R.id.tv_phone);
        tvSlackUsername = findViewById(R.id.tv_slack_username);

    }

    @Override
    protected void onStart() {
        super.onStart();

        // method call
        settingTextValues();

    }

    // method to set values on text views
    private void settingTextValues(){
        tvTrack.setText(getString(R.string.text_my_track));
        tvCountry.setText(getString(R.string.text_my_country));
        tvEmail.setText(getString(R.string.text_my_email));
        tvPhone.setText(getString(R.string.text_my_phone));
        tvSlackUsername.setText(getString(R.string.text_my_slack_username));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
