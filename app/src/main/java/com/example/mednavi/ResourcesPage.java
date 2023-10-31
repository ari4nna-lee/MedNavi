package com.example.mednavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResourcesPage extends AppCompatActivity {

    private TextView insuranceText, insuranceDetails;
    private LinearLayout layout;
    private ImageView settingsIcon, mapsIcon, homeIcon, newsIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_page);
        layout = findViewById(R.id.lin_layout);

        settingsIcon = findViewById(R.id.settings_button);
        mapsIcon = findViewById(R.id.maps_button);
        homeIcon = findViewById(R.id.home_button);
        newsIcon = findViewById(R.id.news_button);

        insuranceText = findViewById(R.id.insurance_tv);
        insuranceDetails = findViewById(R.id.insurance_details);

        mapsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GoogleResourceMap.class);
                startActivity(intent);
                finish();
            }
        });

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        settingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingsPage.class);
                startActivity(intent);
                finish();
            }
        });
        newsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void expand(View view) {
        int v = (insuranceDetails.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        insuranceDetails.setVisibility(v);
    }
}