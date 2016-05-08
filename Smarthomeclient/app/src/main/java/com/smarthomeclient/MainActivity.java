package com.smarthomeclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author semihokan.
 */
public class MainActivity extends AppCompatActivity {


    EditText ipEditText;

    private IPAddressValidator ipAddressValidator = new IPAddressValidator();

    private String ipAddress;

    public static final String IP_ADDRESS = "com.smarthomeclient.ip_address";

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

    String validIpAddress = null;

    public void setIPAddressListener(View view) {
        ipEditText = (EditText) findViewById(R.id.editText);
        ipAddress = ipEditText.getText().toString();
        logger.info("Entered IP address: " + ipAddress);
        boolean isValidIPAddress = ipAddressValidator.validate(ipAddress);
        if (isValidIPAddress) {
            //TODO: assign the ip address to global variable for all activities
            validIpAddress = ipAddress;
            logger.info("IP address is valid: " + validIpAddress);
        } else if (ipAddress.equals("")) {
            validIpAddress = "172.16.20.233";
            logger.info("Default valid ip address: " + validIpAddress);
        } else {
            validIpAddress = null;
            logger.log(Level.INFO, "IP address is invalid");
        }

    }

    public void openCameraWebViewActivity(View view) {
        Intent intent = new Intent(this, CameraWebViewActivity.class);
        logger.info("ip_address: " + validIpAddress);
        if (validIpAddress != null) {
            intent.putExtra(IP_ADDRESS, validIpAddress);
            logger.info("Wanted to put ip address: " + validIpAddress);
            startActivity(intent);
        } else {
            Toast ipToast = Toast.makeText(getApplicationContext(), "Set ip address firstly", Toast.LENGTH_SHORT);
            ipToast.setDuration(Toast.LENGTH_SHORT);
            ipToast.show();
        }
    }

    public void openTemperatureActivity(View view) {
        Intent intent = new Intent(this, TempActivity.class);
        logger.info("intent to open TempActivity");
        if (validIpAddress != null) {
            intent.putExtra(IP_ADDRESS, validIpAddress);
            logger.info("valid ip address for tempActivity" + validIpAddress);
            startActivity(intent);
        } else {
            Toast ipToast = Toast.makeText(getApplicationContext(), "Set ip address firstly", Toast.LENGTH_SHORT);
            ipToast.setDuration(Toast.LENGTH_SHORT);
            ipToast.show();
        }

    }
}
