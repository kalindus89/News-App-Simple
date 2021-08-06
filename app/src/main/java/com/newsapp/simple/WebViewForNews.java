package com.newsapp.simple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class WebViewForNews extends AppCompatActivity {

    Toolbar toolbar;
    WebView webViewNews;
    ImageView go_back_home;
    LinearLayout topBar;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_activity);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
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

        topBar=findViewById(R.id.topBar);
        topBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        progressBar=findViewById(R.id.progressBar_circular);
        progressBar.setMax(100);

        webViewNews.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
                webViewNews.setVisibility(View.GONE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                webViewNews.setVisibility(View.VISIBLE);
                super.onPageFinished(view, url);

            }
        });

        webViewNews.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }
        });


    }
}