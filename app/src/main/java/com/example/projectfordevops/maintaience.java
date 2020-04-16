package com.example.projectfordevops;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class maintaience extends AppCompatActivity {
        WebView webview1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintaience);
        webview1=(WebView)findViewById(R.id.webview1);
        webview1.setWebViewClient(new WebViewClient());
        webview1.getSettings().setJavaScriptEnabled(true);
        webview1.getSettings().setDomStorageEnabled(true);
        webview1.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webview1.loadUrl("https://www.carsdirect.com/car-maintenance/a-routine-car-maintenance-schedule-based-on-engine-mileage");
    }
}
