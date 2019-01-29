package com.example.dondon.recyclerview;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dondon.recyclerview.model.WeatherResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FragmentPopup extends Fragment {
    private RecyclerView recyclerView;

    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragmentpopup, container, false);        //inflate the layout fo this fragment
        Bundle args = getArguments();
        if (args != null) {
            WeatherResponse data = (WeatherResponse) args.getSerializable("weather");

            recyclerView = layout.findViewById(R.id.popup_recycler_view);        //assigning RView to XML element        //wos
            adapter = new MyAdapter(getActivity(), data.getList() );
            //call the adapter
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }


        return layout;
    }


}



