package com.smarthomeclient;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
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
        setIPAddressListener();
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

    Button ipAddressButton;

    private void setIPAddressListener() {
        ipAddressButton = (Button) findViewById(R.id.ip_address);
        ipAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ipEditText = (EditText) findViewById(R.id.editText);
                String ipAddress = ipEditText.getText().toString();
                logger.info("Entered IP address: " + ipAddress);
                boolean isValidIPAddress = ipAddressValidator.validate(ipAddress);
                if (isValidIPAddress) {
                    //TODO: assign the ip address to global variable for all activities
                    logger.info("IP address is valid");
                } else {
                    logger.log(Level.INFO, "IP address is in valid");
                }
                Toast ipToast = Toast.makeText(getApplicationContext(), "Entered IP Address: ".concat(ipAddress+" " + String.valueOf(isValidIPAddress)), Toast.LENGTH_SHORT);
                ipToast.setDuration(Toast.LENGTH_SHORT);
                ipToast.show();
            }
        });


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
