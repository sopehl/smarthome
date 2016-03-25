package com.smarthomeclient;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import java.util.logging.Logger;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

public class MainActivity extends AppCompatActivity {

    Button openButton;
    Button closeButton;
    EditText ip;

    private static final Logger logger = Logger.getLogger(MainActivity.class.getName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ip = (EditText) findViewById(R.id.editText);
        //openButtonListener();
        //closeButtonListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    private void openButtonListener() {
        openButton = (Button) findViewById(R.id.open);
        // TODO: 31/12/15 using the ip address that is typed to text field
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpRequest postRequest = HttpRequest
                        .post("http://192.168.1.4:8000/temp")
                        .form("on", true);
                logger.info("sending the post");
                HttpResponse postResponse = postRequest.send();
                System.out.println(postResponse);
            }
        });
    }

    private void closeButtonListener() {
        closeButton = (Button) findViewById(R.id.close);
        final String ipAddress = ip.getText().toString();
        // TODO: 31/12/15 using the ip address that is typed to text field
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpRequest postRequest = HttpRequest
                        .post("http://192.168.1.4:8000/temp")
                        .form("on", false);
                logger.info("sending the post");
                HttpResponse postResponse = postRequest.send();
                System.out.println(postResponse);
            }
        });
    }
    */
}
