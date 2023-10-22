package com.example.mednavi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class CalendarWebView extends AppCompatActivity {

    WebView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_web_view);
        calendar = findViewById(R.id.calendar_webview);
        WebSettings webSettings = calendar.getSettings();
        webSettings.setJavaScriptEnabled(true);
        calendar.loadUrl("https://calendar.google.com/calendar/embed?src=mednavihelp%40gmail.com&ctz=America%2FNew_York");
    }
}