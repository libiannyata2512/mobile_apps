package com.libian.lacakaku;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;

public class CoordinateHelper {
    private static double latitude = 0;
    private static double longitude = 0;
    private static Location location;

    public static double getLatitude() {
        return latitude;
    }

    public static void setLatitude(double langitude) {
        CoordinateHelper.latitude = langitude;
    }

    public static double getLongitude() {
        return longitude;
    }

    public static void setLongitude(double longitude) {
        CoordinateHelper.longitude = longitude;
    }

    public static void getCoordinate(Context context) {
        String gps = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
        if (!gps.contains("gps")) {
            latitude = 0.0f;
        } else {
            String contextLocation = Context.LOCATION_SERVICE;
            LocationManager locationManager = (LocationManager) context.getSystemService(contextLocation);
            String provider = locationManager.getBestProvider(onSetCriteria(), true);

            location = new Location(provider);
            try{
                location = locationManager.getLastKnownLocation(provider);
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            }catch (SecurityException e){
                latitude = 0.0f;
                longitude = 0.0f;
            }catch (Exception e){
                latitude = 0.0f;
                longitude = 0.0f;
            }
        }
    }

    private static Criteria onSetCriteria() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_MEDIUM);
        criteria.setSpeedRequired(true);
        return criteria;
    }
}
