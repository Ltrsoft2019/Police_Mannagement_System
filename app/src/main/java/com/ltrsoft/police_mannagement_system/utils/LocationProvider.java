package com.ltrsoft.police_mannagement_system.utils;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import com.ltrsoft.police_mannagement_system.Interfaces.LocationCallBack;

public class LocationProvider {

    private static final String TAG = "LocationProvider";
    private static final int LOCATION_PERMISSION_REQUEST_CODE =1000001 ;

    // Method to get the current latitude and longitude
    public static void getCurrentLocation(Context context, LocationCallBack callBack) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        // Check if location permissions are granted
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
            Log.e(TAG, "Location permissions not granted");
            return;
        }

        // Define a location listener
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                callBack.onLocationGet(location);
                Log.d(TAG, "Latitude: " + latitude + ", Longitude: " + longitude);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                callBack.onError(provider);
            }

            @Override
            public void onProviderEnabled(String provider) {
                callBack.onError(provider);
            }

            @Override
            public void onProviderDisabled(String provider) {
                callBack.onError(provider);
            }
        };

        // Request location updates
        locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, locationListener, null);
    }
}
