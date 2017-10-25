package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rin on 24/10/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

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

        final Earthquake earthquake = getItem(position);

        TextView magnitude = listItemView.findViewById(R.id.magnitude_text);
        magnitude.setText(earthquake.getMagnitude());

        TextView place = listItemView.findViewById(R.id.place_text);
        place.setText(earthquake.getLocation());

        TextView date = listItemView.findViewById(R.id.date_text);
        date.setText(earthquake.getDate());


        return listItemView;

    }

}


