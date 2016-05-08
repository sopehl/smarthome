package com.smarthomeclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.logging.Logger;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

public class TempActivity extends AppCompatActivity {

    private String ip;

    private Logger logger = Logger.getLogger(TempActivity.class.getName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        ip = intent.getStringExtra(MainActivity.IP_ADDRESS);


    }

    public void refreshTemperature(View v) {
        final TextView textView = (TextView)findViewById(R.id.temp_text);
        final HttpRequest request = HttpRequest.get("http://" + ip + ":8089/sh/temp/");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                HttpResponse response = request.send();
                logger.info("Response: \n "+response.body().toString());
                String jsonString = response.body().toString();
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    final String temp = jsonObject.getString("temp");
                    logger.info("TEMP: " + temp);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(temp + " \u2103");
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
