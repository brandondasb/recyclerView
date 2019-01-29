package com.example.dondon.recyclerview.networking.callbacks;

import com.example.dondon.recyclerview.model.WeatherResponse;

public interface GetWeatherTaskCallBack {
     void updateTemp(WeatherResponse weatherResponse);
}
