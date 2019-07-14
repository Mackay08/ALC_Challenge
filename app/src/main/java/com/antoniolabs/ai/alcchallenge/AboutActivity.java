package com.antoniolabs.ai.alcchallenge;

import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    WebView abtWebView;
    String alcUrl = "https://andela.com/alc/";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        init();

        abtWebView.setWebViewClient(new MyWebViewClient());
        abtWebView.getSettings().setJavaScriptEnabled(true);
        abtWebView.getSettings().setDomStorageEnabled(true);
        abtWebView.getSettings().setUseWideViewPort(true);

        abtWebView.loadUrl(alcUrl);

    }

    private void init() {
        abtWebView = findViewById(R.id.webAboutAlc);
    }

    private class MyWebViewClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

         @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
             Log.d("Failure url: ", failingUrl);
        }


        /*@Override
        public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
            String message = "SSL Certificate Error";
            switch (error.getPrimaryError()){
                case SslError.SSL_UNTRUSTED:
                    message = "The certificate authority is untrusted";
                    break;

                case SslError.SSL_EXPIRED:
                    message = "The certificate has expired";
                    break;

                case SslError.SSL_IDMISMATCH:
                    message = "The certificate Hostname mismatch";
                    break;

                case SslError.SSL_NOTYETVALID:
                    message = "The certificate is not yet valid";
                    break;
            }
            message += "Do you want to continue anyway";

            builder.setTitle("SSL Certificate Error");
            builder.setMessage(message);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    handler.proceed();
                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    handler.cancel();
                }
            });

            final AlertDialog dialog = builder.create();
            dialog.show();
        }*/
    }
}
