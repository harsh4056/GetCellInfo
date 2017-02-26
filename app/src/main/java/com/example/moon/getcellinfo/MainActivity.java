package com.example.moon.getcellinfo;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.Telephony.Carriers.TYPE;

public class MainActivity extends AppCompatActivity  {
  TextView tvLac,tvCid,tvPsc;
    Button getButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle data= new Bundle();

        tvCid= (TextView) findViewById(R.id.tvCid);
        tvLac= (TextView) findViewById(R.id.tvLac);
        tvPsc= (TextView) findViewById(R.id.tvPsc);
        getButton= (Button) findViewById(R.id.button);
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            setTexts();
            }
        });









        }





/*    protected View.OnClickListener cmdLocateListener = new View.OnClickListener() {
        // @Override
        public void onClick(View arg0) {
                            *//* Show a progress-bar *//*
            myProgressDialog = ProgressDialog.show(CellIDToLatLong.this,
                    "Please wait...", "Doing Extreme Calculations...", true);
            new Thread() {
                public void run() {

                    try {
                                                    *//* Pretend this is really complex <img src="http://www.anddev.org/images/smilies/wink.png" alt=";)" title="Wink" /> *//*
                        sleep(5000);

                                                    *//* Parse the values from the EditTexts
                                                     * and try to locate ourselves *//*
                        int cellid = Integer.parseInt(tvCid.getText().toString());
                        int lac = Integer.parseInt(tvLac.getText().toString());

                        tryToLoate(cellid, lac);

                    } catch (NumberFormatException nfe) {
                        // Crap was typed <img src="http://www.anddev.org/images/smilies/wink.png" alt=";)" title="Wink" />
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();

                    }

                }
            }.start();
        }
    };

    public void tryToLoate(int aCellID, int aLAC) throws Exception {
        // Create a connection to some 'hidden' Google-API
        String baseURL = "http://www.google.com/glm/mmap";
        // Setup the connection
        HttpURL httpURL = new HttpURL(baseURL);
        HostConfiguration host = new HostConfiguration();
        host.setHost(httpURL.getHost(), httpURL.getPort());
        HttpConnection connection = connectionManager.getConnection(host);
    */



public void setTexts() {
    TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
    tvCid.setText(gsmCellLocation.getCid()+"");
    tvLac.setText(gsmCellLocation.getLac()+"");
    tvPsc.setText(gsmCellLocation.getPsc()+"");

    Location locationNet, locationGPS;
    if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
            && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
        LocationManager mLocationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);


        locationNet = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        locationGPS = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    }


}
    }

