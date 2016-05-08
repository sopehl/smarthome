package com.smarthomeclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Logger;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

public class Humidity extends AppCompatActivity {

    private String ip;

    private final Logger logger = Logger.getLogger(Humidity.class.getName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humidity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        ip = intent.getStringExtra(MainActivity.IP_ADDRESS);

    }

    public void refreshHumidity(View view) {
        final TextView textView = (TextView)findViewById(R.id.hum_text);
        final HttpRequest request = HttpRequest.get("http://" + ip + ":8089/sh/hum/");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                HttpResponse response = request.send();
                logger.info("Response: \n "+response.body().toString());
                String jsonString = response.body().toString();
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    final String hum = jsonObject.getString("hum");
                    logger.info("HUM: " + hum);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(hum + " %");
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(r).start();
    }

}
