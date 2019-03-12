package com.example.dondon.recyclerview.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dondon.recyclerview.WeatherDetailsRecycleViewAdapter;
import com.example.dondon.recyclerview.R;
import com.example.dondon.recyclerview.model.WeatherResponse;
import com.example.dondon.recyclerview.presenter.WeatherDetailsPresenter;


public class WeatherDetailsFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_weather_details, container, false);        //inflate the layout fo this fragment
        Bundle args = getArguments();
        if (args != null) {
            WeatherResponse data = (WeatherResponse) args.getSerializable("weather");
            WeatherDetailsPresenter presenter = new WeatherDetailsPresenter(layout);
            presenter.load(data);
         }
        return layout;
    }


}



