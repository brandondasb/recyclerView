package com.example.dondon.recyclerview.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.dondon.recyclerview.WeatherDetailsRecycleViewAdapter;
import com.example.dondon.recyclerview.model.WeatherResponse;
import com.example.dondon.recyclerview.view.WeatherDetailsViewHolder;


public class WeatherDetailsPresenter {
    private WeatherDetailsViewHolder viewHolder;
    private Context context;


    public WeatherDetailsPresenter(View view) {
        this.viewHolder = new WeatherDetailsViewHolder(view);
        this.context = view.getContext();
    }

    public void load (WeatherResponse weatherResponse){
        WeatherDetailsRecycleViewAdapter adapter = new WeatherDetailsRecycleViewAdapter(context, weatherResponse.getList() );
        //call the adapter
        viewHolder.recyclerView.setAdapter(adapter);
        viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
}
