package com.example.fitnessapps2;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Locale;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "MapsActivity";
    private int ACCESS_LOCATION_REQUEST_CODE = 10001;
    private GoogleMap mMap;
    private Geocoder geocoder;
    FusedLocationProviderClient fusedLocationProviderClient;
    private double lat = 0.d;
    private double lng = 0.d;
    LocationRequest locationRequest;
    double distance1 = 0d;
    RelativeLayout startpausebutton, stopbutton;
    ImageView playpauseimage;
    TextView distance, cal;
    LinearLayout lL;
    LocationManager lm;
    boolean gps_enabled = false;

    float  distanceTotal = 0f;
    float[] dist = new float[1];

    private long pauseOffset;

    private Chronometer timer;

    private boolean running = false;

    private boolean firstTime = true;
    private boolean wasRunning;
    private int seconds = 0;
    PolylineOptions polygon1;

    private boolean status=false;
    private boolean suggestionStatus = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        lm = (LocationManager) MapsActivity.this.getSystemService(Context.LOCATION_SERVICE);

        lL = (LinearLayout) findViewById(R.id.bottomSheet);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        geocoder = new Geocoder(this);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(500);
        locationRequest.setFastestInterval(500);


//        LinearLayout lL = (LinearLayout) findViewById(R.id.bottomSheet); // Use these Statement to Change Values of Component From another xml file
        timer = lL.findViewById(R.id.timer);
        timer.setText("Time");

        startpausebutton = lL.findViewById(R.id.startpausebutton);


        distance = lL.findViewById(R.id.distance);
        distance.setText("Distance (in m)");

        cal = lL.findViewById(R.id.calorie);
        cal.setText("Speed");

//        startBtn = lL.findViewById(R.id.startBtn);
        stopbutton = lL.findViewById(R.id.stopbutton);
        playpauseimage = lL.findViewById(R.id.playpauseimage);

        startpausebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!status) {



                    if (ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        try {
                            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
                        } catch (Exception ex) {
                        }

                        if (!gps_enabled) {
                            // notify user
//                            status = false;


                            new AlertDialog.Builder(MapsActivity.this)
                                    .setMessage("GPS of your device is not enabled!! We requires GPS for user location tracking.")
                                    .setPositiveButton("Open Settings to Turn on GPS", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                                            MapsActivity.this.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                                            gps_enabled = true;
                                        }
                                    }).setNegativeButton("Don't Turn On", null)
                                    .show();

                            if (gps_enabled) {
                                if (!suggestionStatus) {
                                    new AlertDialog.Builder(MapsActivity.this)
                                            .setMessage("If you are under a roof or in a building, please shift to an open area for higher accuracy.")
                                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                                                    status = true;
                                                    playpauseimage.setImageResource(R.drawable.ic_baseline_pause_24);
                                                    enableUserLocation();
                                                    startLocationUpdates();

                                                    if (!running) {
                                                        timer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                                                        timer.start();
                                                        running = true;
                                                    }
                                                }
                                            }).setNegativeButton("Don't Turn On", null)
                                            .show();
                                    suggestionStatus = true;
                                }

                            }
                        } else {
                            if (!suggestionStatus) {
                                new AlertDialog.Builder(MapsActivity.this)
                                        .setMessage("If you are under a roof or in a building, please shift to an open area for higher accuracy.")
                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                                                if (gps_enabled) {
                                                    playpauseimage.setImageResource(R.drawable.ic_baseline_pause_24);
                                                    status = true;
                                                    enableUserLocation();
                                                    startLocationUpdates();
                                                    if (!running) {
                                                        timer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                                                        timer.start();
                                                        running = true;
                                                    }

                                                }
                                            }
                                        }).show();
                                suggestionStatus = true;

                            }else{
                                playpauseimage.setImageResource(R.drawable.ic_baseline_pause_24);
                                enableUserLocation();
                                startLocationUpdates();
                                status=true;
                                if (!running) {
                                    timer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                                    timer.start();
                                    running = true;
                                }
                            }


                        }
                    }
                }else {
                    playpauseimage.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                    status = false;

                    if (running) {
                        timer.stop();
                        pauseOffset = SystemClock.elapsedRealtime() - timer.getBase();
                        running = false;
                    }
//                    running = false;
                    stopLocationUpdates();
                }

            }
        });


//        startpauseBtn.setOnClickListener(new View.OnClickListener()
//
//            {
//                @Override
//                public void onClick (View v){
//
//                if (startpausebutton.isChecked()) {
//                    if (ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                        try {
//                            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
//                        } catch (Exception ex) {
//                        }
//
//                        if (!gps_enabled) {
//                            // notify user
//                            startPauseBtn.setChecked(false);
//
//
//                            if (gps_enabled) {
//
//                                if (!suggestionStatus) {
//                                    new AlertDialog.Builder(MapsActivity.this)
//                                            .setMessage("If your are under a roof or in a building please use tracking in open area for accuracy.")
//                                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
//                                                @Override
//                                                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
//                                                    enableUserLocation();
//                                                    startLocationUpdates();
//
//                                                    if (!running) {
//                                                        timer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
//                                                        timer.start();
//                                                        running = true;
//                                                    }
//                                                }
//                                            }).setNegativeButton("Don't Turn On", null)
//                                            .show();
//                                    suggestionStatus = true;
//                                }
////                                enableUserLocation();
////                                startLocationUpdates();
////
////                                if (!running) {
////                                    timer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
////                                    timer.start();
////                                    running = true;
////                                }
////                                running = true;
////                                runTimer();
////                                Toast.makeText(MapsActivity.this,"Hi",Toast.LENGTH_LONG).show();
//                            }
//                        } else {
//                            if (!suggestionStatus) {
//                                new AlertDialog.Builder(MapsActivity.this)
//                                        .setMessage("If your are under a roof or in a building please use tracking in open area for accuracy.")
//                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
//                                            @Override
//                                            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
//                                                if (gps_enabled) {
//                                                    enableUserLocation();
//                                                    startLocationUpdates();
//
//                                                    if (!running) {
//                                                        timer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
//                                                        timer.start();
//                                                        running = true;
//                                                    }
//
//                                                }
//                                            }
//                                        }).show();
//                                suggestionStatus = true;
//                            }
//
////                            if (gps_enabled){
////                                enableUserLocation();
////                                startLocationUpdates();
////                                if (!running) {
////                                    timer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
////                                    timer.start();
////                                    running = true;
////                                }
////
////                            }
//
//                        }
//
//
//                    }
//                } else {
//
//                    if (running) {
//                        timer.stop();
//                        pauseOffset = SystemClock.elapsedRealtime() - timer.getBase();
//                        running = false;
//                    }
////                    running = false;
//                    stopLocationUpdates();
//                }
//
//
//            }
//            }
//        });


        stopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.stop();
//                pauseOffset = SystemClock.elapsedRealtime() - timer.getBase();
//                running = false;
                timer.setBase(SystemClock.elapsedRealtime());
                pauseOffset = 0;

                running = false;

                firstTime = true;

//                seconds = 0;
//                running = false;
                mMap.clear();
                timer.setText("Time");
                distance.setText("Distance (in m)");
                cal.setText("Speed");
                playpauseimage.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                status = false;
                distanceTotal = 0;
                stopLocationUpdates();
            }
        });


    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            enableUserLocation();


        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                // We can show user why this permission is necessary
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, ACCESS_LOCATION_REQUEST_CODE);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, ACCESS_LOCATION_REQUEST_CODE);
            }
        }


    }

    LocationCallback locationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(@NonNull LocationResult address) {
            super.onLocationResult(address);





            Log.d(TAG, "onLocationResult: " + address.getLastLocation());
//            LatLng newLtLg = new LatLng(address.getLastLocation().getLatitude(),address.getLastLocation().getLongitude());
//            LatLng oldLtLg;
            System.out.println(address.getLastLocation().toString());
//            LatLng NEWARK = new LatLng(address.getLastLocation().getLatitude(), address.getLastLocation().getLongitude());

            if(lat == 0.d && lng == 0.d){
                lat = address.getLastLocation().getLatitude();
                lng = address.getLastLocation().getLongitude();
            }else if( lat == address.getLastLocation().getLatitude() && lng == address.getLastLocation().getLongitude()){
                lat = address.getLastLocation().getLatitude();
                lng = address.getLastLocation().getLongitude();
            }else{

                // Add polygons to indicate areas on the map.
                polygon1 = new PolylineOptions().add(new LatLng(lat,lng),
                        new LatLng(address.getLastLocation().getLatitude(),address.getLastLocation().getLongitude()
                        )
                ).width(10).color(MapsActivity.this.getResources().getColor(R.color.orange));


                mMap.addPolyline(polygon1);

                Location mylocation = new Location("");
                Location dest_location = new Location("");
                String lat1 = String.valueOf(lat);
                String lon1 = String.valueOf(lng);
                dest_location.setLatitude(Double.parseDouble(lat1));
                dest_location.setLongitude(Double.parseDouble(lon1));
                String lat2 = String.valueOf(address.getLastLocation().getLatitude());
                String lon2 = String.valueOf(address.getLastLocation().getLongitude());
                mylocation.setLatitude(Double.parseDouble(lat2));
                mylocation.setLongitude(Double.parseDouble(lon2));
                float distance12 = mylocation.distanceTo(dest_location);//in meters
//            Toast.makeText(this, "Distance"+ Float.toString(distance),Toast.LENGTH_LONG).show();

                distanceTotal += distance12;
                System.out.println(distanceTotal);

                Double distanceInDouble =Double.valueOf( String.format("%.0f", distanceTotal));

                String rounded = String.format("%.0f", distanceTotal);

                distance.setText(rounded + " mtr");






                String time1 = String.valueOf(SystemClock.elapsedRealtime() - timer.getBase());
                int time2 = Integer.valueOf(time1)/1000;

                double speed1 =Double.valueOf( String.format("%.0f",  distanceInDouble/ time2 * (18/5)));

                cal.setText(String.valueOf(speed1) + " km/hr");
                if(firstTime) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 19));
                    cal.setText("0 km/hr");
                    distance.setText("0 mtr");
                    firstTime = false;
                }


            }





            lat = address.getLastLocation().getLatitude();
            lng = address.getLastLocation().getLongitude();

        }


    };

    void startLocationUpdates(){


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
            //            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
            return;
        }



        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());

    }

    void stopLocationUpdates(){

        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
    }



    private void enableUserLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == ACCESS_LOCATION_REQUEST_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                enableUserLocation();
            }else{
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                    // We can show user why this permission is necessary
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, ACCESS_LOCATION_REQUEST_CODE);
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, ACCESS_LOCATION_REQUEST_CODE);
                }
            }
        }
    }
}