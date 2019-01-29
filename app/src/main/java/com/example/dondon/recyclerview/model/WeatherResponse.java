package com.example.dondon.recyclerview.model;

import java.io.Serializable;
import java.util.List;

public class WeatherResponse implements Serializable {
    private List<Weather> list;

    public List<Weather> getList() {
        return list;
    }

    public void setList(List<Weather> list) {
        this.list = list;
    }
}
