package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by rin on 24/10/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = "of";

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_item, parent, false);
        }

        final Earthquake currentEarthquake = getItem(position);

        double mag = currentEarthquake.getMagnitude();
        TextView magnitude = listItemView.findViewById(R.id.magnitude_text);
        DecimalFormat formatter = new DecimalFormat("0.0");
        magnitude.setText(formatter.format(mag));

        /*Set the proper background color on the magnitude circle.
        Fetch the background from the TextView, which is a GradientDrawable. */
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        int magnitudeColor = getMagnitudeColor(mag);
        magnitudeCircle.setColor(magnitudeColor);


        TextView placeOffset = listItemView.findViewById(R.id.place_offset_text);
        TextView place = listItemView.findViewById(R.id.place_text);

        String location = currentEarthquake.getPlace();
        if (location.contains(LOCATION_SEPARATOR)) {
            int indexBreak = location.indexOf(LOCATION_SEPARATOR);
            placeOffset.setText(location.substring(0, indexBreak + LOCATION_SEPARATOR.length()));
            place.setText(location.substring(indexBreak + LOCATION_SEPARATOR.length(), location.length()));
        } else {
            placeOffset.setText(R.string.near_the);
            place.setText(location);
        }


        /*Since this logic is related to how the information is displayed in the User Interface
        these changes are done here! */
        Date dateTime = new Date(currentEarthquake.getTime());
        TextView date = listItemView.findViewById(R.id.date_text);
        date.setText(formatDate(dateTime));

        TextView timeView = listItemView.findViewById(R.id.time_text);
        timeView.setText(formatTime(dateTime));

        return listItemView;

    }

    private String formatDate(Date dateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        return dateFormat.format(dateTime);
    }

    private String formatTime(Date dateTime) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateTime);
    }

    private int getMagnitudeColor(double magnitude) {
        switch ((int) Math.floor(magnitude)) {
            case 0:
            case 1:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2:
                return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3:
                return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4:
                return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5:
                return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6:
                return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7:
                return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8:
                return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9:
                return ContextCompat.getColor(getContext(), R.color.magnitude9);
        }

        return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
    }
}
