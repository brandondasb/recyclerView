package com.example.dondon.recyclerview.model;

public class WeatherResponse {
    private WeatherMain main ;
    private WeatherSys sys;

    public WeatherMain getMain() {
        return main;
    }

    public void setMain(WeatherMain main) {
        this.main = main;
    }

    public WeatherSys getSys() {
        return sys;
    }

    public void setSys(WeatherSys sys) {
        this.sys = sys;
    }
}
