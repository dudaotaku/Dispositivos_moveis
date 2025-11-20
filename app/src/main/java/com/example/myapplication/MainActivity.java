package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.LocaleManager;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.Manifest;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_LOCATION = 1;
    private static String TAG = "MainActivity";
    LocationManager locationManager;
    TextView textView;
    MapView mapView;
    Button bntGetLocation;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().setUserAgentValue(getPackageName());
        setContentView(R.layout.activity_main);
        mapView = findViewById(R.id.mapView);
        textView = findViewById(R.id.textView);
        bntGetLocation = findViewById(R.id.button);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        bntGetLocation.setOnClickListener(V->checkAndGetLocation());



    }

    private void checkAndGetLocation(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED){

            requisitandoPermissao();
            return;
        }
        getLocation();
    }

    private void getLocation(){
        try{
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,location1 ->{
                double latitude = location1.getLatitude();
                double longitude = location1.getLongitude();
                if(textView != null){
                    textView.setText("Latitude: " +Double.toString(latitude)+"\nlongitude: "+Double.toString(longitude));
                }
                showLocationOnMap(latitude,longitude);
            });
            if(location != null){
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                if(textView != null){
                    textView.setText("Latitude: " +Double.toString(latitude)+"\nlongitude: "+Double.toString(longitude));
                }
            }
        }catch (SecurityException e){

        }
    }

    public void showLocationOnMap(double latitude, double longitude){
        GeoPoint userLocation = new GeoPoint(latitude,longitude);
        mapView.getController().setCenter(userLocation);
        mapView.getController().animateTo(userLocation);
        mapView.getController().setZoom(18.0);
    }

    public void requisitandoPermissao(){

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION},
                REQUEST_LOCATION
        );

    }
}