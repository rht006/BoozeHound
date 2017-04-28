package com.boozehound.boozehound12;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.graphics.drawable.Drawable;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.support.v4.app.Fragment;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("maps", "page loading");

        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_map);
        Log.d("maps", "content view set");

        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap map) {
        //run query
        String type = "map load";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type);
        //int numBars = 5;
        //for(int i=0; i<numBars; i++) {
            //addmarkers
            AddMarker("-95.549686", "30.723162", map, "12th street bar");
            //set camera
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(30.723526, -95.550777), 14.0f));
        //}
    }

    public void AddMarker(String Long, String Lat, GoogleMap map, String Name){
        Double Longitude = Double.parseDouble(Long);
        Double Latitude = Double.parseDouble(Lat);
        map.addMarker(new MarkerOptions().position(new LatLng(Latitude, Longitude)).title(Name));
    }


    }