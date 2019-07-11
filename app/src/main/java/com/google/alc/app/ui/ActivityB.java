package com.google.alc.app.ui;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.alc.app.R;
import com.google.alc.app.constants.Constant;

public class ActivityB extends AppCompatActivity {

    // Class Instance Variables
    Toolbar toolbar;

    TextView toolbar_title;

    WebView mWebView;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

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

        mWebView = findViewById(R.id.myWebView);
        progressBar = findViewById(R.id.progressBar);

        // method call
        setUpWebView();

    }

    @Override
    protected void onStart() {
        super.onStart();

        // method call
        //setUpWebView();

    }

    // method to set up web view
    @SuppressLint("SetJavaScriptEnabled")
    public void setUpWebView(){

        // displays the web view
        mWebView.setVisibility(View.VISIBLE);

        // add setting to the webView
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.getSansSerifFontFamily();
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);

        mWebView.loadUrl(Constant.url);

        //mWebView.loadUrl("https://fonts.google.com");

        mWebView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                super.onPageStarted(view, url, favicon);
                // sets visibility to visible
                progressBar.setVisibility(View.VISIBLE);

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                // sets visibility of progressBar to gone when page finishes loading
                progressBar.setVisibility(View.GONE);
                // sets visibility of webView to visible when page finishes loading
                mWebView.setVisibility(View.VISIBLE);

            }

            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                view.loadUrl("about:blank");
                // display toast with error message
                Toast.makeText(getApplicationContext(), "Oops " + description,
                        Toast.LENGTH_LONG).show();
                super.onReceivedError(view, errorCode, description, failingUrl);

                mWebView.setVisibility(View.GONE);

            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
               handler.proceed(); // ignore SSL certificate errors
            }
        });


    }

    @Override
    public void onBackPressed() {
        // checks if webView can go back
        if(mWebView.canGoBack()){
            mWebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}
