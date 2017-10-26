package com.example.android.quakereport;

/**
 * Created by rin on 24/10/17.
 */

public class Earthquake {

    private double magnitude;
    private String place;
    private long time;


    public Earthquake(double magnitude, String place, long time) {
        this.magnitude = magnitude;
        this.place = place;
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public long getTime() {
        return time;
    }

    public double getMagnitude() {
        return magnitude;
    }

    @Override
    public String toString() {
        return "Magnitude: "+ magnitude + ", Place: " + place + ", Time: " + time + "\n";
    }
}

