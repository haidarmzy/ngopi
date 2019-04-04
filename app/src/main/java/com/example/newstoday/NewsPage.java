package com.example.newstoday;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class NewsPage extends AppCompatActivity {

    private String pageUrl;
    private WebSettings webSettings;

    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_news_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView = (WebView)findViewById(R.id.newsDetail);
        progressBar = (ProgressBar)findViewById(R.id.loading);

        pageUrl = getIntent().getStringExtra("URL");

        webSettings = webView.getSettings();
        webView.loadUrl(pageUrl);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webView.setWebViewClient(new NewsPage.WebViewClient());
    }

    private class WebViewClient extends android.webkit.WebViewClient {

        @Override

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //progressBar.setVisibility(View.VISIBLE);
            super.onPageStarted(view, url, favicon);

        }


        @Override

        public void onPageFinished(WebView view, String url) {
            progressBar.setVisibility(View.GONE);
            webView.setVisibility(View.VISIBLE);
            super.onPageFinished(view, url);
        }
    }


    @Override
    public void onBackPressed(){
        finish();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
