
package com.example.app1;  // Replace this with your actual package name

public class Pin {
    private double latitude;
    private double longitude;
    private String title;

    // Required empty constructor for Firebase
    public Pin() {
    }

    public Pin(double latitude, double longitude, String title) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTitle() {
        return title;
    }
}
