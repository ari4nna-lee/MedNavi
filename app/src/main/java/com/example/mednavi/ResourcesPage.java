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

    private TextView educationDetails, foodDetails, moneyDetails, insuranceDetails, slidingScaleDetails, languageDetails, communityAccessDetails, housingDetails;
    private LinearLayout layout_one, layout_two, layout_three, layout_four, layout_five, layout_six, layout_seven, layout_eight;
    private ImageView settingsIcon, mapsIcon, homeIcon, newsIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_page);
        layout_one = findViewById(R.id.lin_layout_one);
        layout_two = findViewById(R.id.lin_layout_two);
        layout_three = findViewById(R.id.lin_layout_three);
        layout_four = findViewById(R.id.lin_layout_four);
        layout_five = findViewById(R.id.lin_layout_five);
        layout_six = findViewById(R.id.lin_layout_six);
        layout_seven = findViewById(R.id.lin_layout_seven);
        layout_eight = findViewById(R.id.lin_layout_eight);

        settingsIcon = findViewById(R.id.settings_button);
        mapsIcon = findViewById(R.id.maps_button);
        homeIcon = findViewById(R.id.home_button);
        newsIcon = findViewById(R.id.news_button);

        educationDetails = findViewById(R.id.education_details);
        foodDetails = findViewById(R.id.food_details);
        moneyDetails = findViewById(R.id.money_details);
        slidingScaleDetails = findViewById(R.id.slidingscale_details);
        languageDetails = findViewById(R.id.language_details);
        communityAccessDetails = findViewById(R.id.communityaccess_details);
        housingDetails = findViewById(R.id.housing_details);
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
    public void expand_one(View view) {
        int v = (educationDetails.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_one, new AutoTransition());
        educationDetails.setVisibility(v);
    }
    public void expand_two(View view) {
        int v = (foodDetails.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_two, new AutoTransition());
        foodDetails.setVisibility(v);
    }
    public void expand_three(View view) {
        int v = (moneyDetails.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_three, new AutoTransition());
        moneyDetails.setVisibility(v);
    }
    public void expand_four(View view) {
        int v = (insuranceDetails.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_four, new AutoTransition());
        insuranceDetails.setVisibility(v);
    }
    public void expand_five(View view) {
        int v = (slidingScaleDetails.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_five, new AutoTransition());
        slidingScaleDetails.setVisibility(v);
    }
    public void expand_six(View view) {
        int v = (languageDetails.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_six, new AutoTransition());
        languageDetails.setVisibility(v);
    }
    public void expand_seven(View view) {
        int v = (communityAccessDetails.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_seven, new AutoTransition());
        communityAccessDetails.setVisibility(v);
    }
    public void expand_eight(View view) {
        int v = (housingDetails.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_eight, new AutoTransition());
        housingDetails.setVisibility(v);
    }
}
