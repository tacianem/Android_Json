package com.example.android.quakereport;

/**
 * Created by rin on 24/10/17.
 */

public class Earthquake {

    private String magnitude;
    private String location;
    private String date;


    public Earthquake(String magnitude, String location, String date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getMagnitude() {
        return magnitude;
    }

}

