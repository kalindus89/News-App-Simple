package com.newsapp.simple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class WebViewForNews extends AppCompatActivity {

    Toolbar toolbar;
    WebView webViewNews;
    ImageView go_back_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_activity);

        toolbar=findViewById(R.id.toolBar);
        webViewNews=findViewById(R.id.webViewNews);
        webViewNews.getSettings().setJavaScriptEnabled(true);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String url= intent.getStringExtra("url");
        webViewNews.setWebViewClient(new WebViewClient());
        webViewNews.loadUrl(url);


        go_back_home=findViewById(R.id.go_back_home);
        go_back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}