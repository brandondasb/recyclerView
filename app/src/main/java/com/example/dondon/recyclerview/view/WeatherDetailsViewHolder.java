package com.example.dondon.recyclerview.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dondon.recyclerview.R;

public class WeatherDetailsViewHolder {
    public RecyclerView recyclerView;

    public WeatherDetailsViewHolder(View view) {
        this.recyclerView = (RecyclerView) view.findViewById(R.id.fragment_weather_details_recycler_view);

    }

}
