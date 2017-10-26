package com.example.android.quakereport;

/**
 * Created by rin on 24/10/17.
 */

public class Earthquake {

    private double magnitude;
    private String place;
    private String url;
    private long time;


    public Earthquake(double magnitude, String place, long time, String url) {
        this.magnitude = magnitude;
        this.place = place;
        this.time = time;
        this.url = url;
    }

    public String getPlace() {
        return place;
    }

    public String getUrl() {
        return url;
    }

    public long getTime() {
        return time;
    }

    public double getMagnitude() {
        return magnitude;
    }

    @Override
    public String toString() {
        return "Magnitude: " + magnitude + "\nPlace: " + place + "\nTime: " + time + "\nUrl: " + url + "\n\n";
    }
}

