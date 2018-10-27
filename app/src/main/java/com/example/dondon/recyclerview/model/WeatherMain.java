package com.example.dondon.recyclerview.model;

import com.google.gson.annotations.SerializedName;

public class WeatherMain {
    //create private rep of available
    private float humidity;
    private  float temp;
    private Integer pressure;

    @SerializedName("temp_min")
    private float tempMin ;
    @SerializedName("temp_max")
    private  float tempMax;



    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }
}
