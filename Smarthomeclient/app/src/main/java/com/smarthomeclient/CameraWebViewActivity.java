package com.smarthomeclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import java.util.logging.Logger;

public class CameraWebViewActivity extends AppCompatActivity {

    private static final Logger logger = Logger.getLogger(CameraWebViewActivity.class.getName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_web_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String ipAddress = intent.getStringExtra(MainActivity.IP_ADDRESS);
        logger.info("Sent ip address from MainActivity: " + ipAddress);

        WebView webView = (WebView) findViewById(R.id.camera_view);
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title></title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<img src=\"http://"+ipAddress+":8081/\">\n" +
                "</body>\n" +
                "</html>";
        String mime = "text/html";
        String encoding = "utf-8";

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL(null, html, mime, encoding, null);

    }

}
