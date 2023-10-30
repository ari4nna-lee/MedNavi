package com.example.mednavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

public class CalendarWebView extends AppCompatActivity {

    WebView calendar;

    private ImageView mapsIcon;
    private ImageView newsIcon;
    private ImageView homeIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_web_view);
        calendar = findViewById(R.id.calendar_webview);

        mapsIcon = findViewById(R.id.maps_button);
        newsIcon = findViewById(R.id.news_button);
        homeIcon = findViewById(R.id.home_button);

        WebSettings webSettings = calendar.getSettings();
        webSettings.setJavaScriptEnabled(true);
        calendar.loadUrl("https://calendar.google.com/calendar/embed?src=mednavihelp%40gmail.com&ctz=America%2FNew_York");

        newsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
                finish();
            }
        });

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

    }
}