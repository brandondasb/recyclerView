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

        View layout = inflater.inflate(R.layout.fragmentpopup,container,false);
        //inflate the layout fo this fragment

        recyclerView = layout.findViewById(R.id.popup_recycler_view);
        //assigning RView to XML element
        //wos

        adapter = new MyAdapter(getActivity(),getData());
        //call the adapter
        recyclerView.setAdapter(adapter);


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
         }

         public static List<Information> getData(){
             List<Information> data = new ArrayList<>();
             int[] icons = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
             String[] titles = {"first text ","oh a second one"};

             for(int i=0;i<titles.length && i<icons.length;i++) {
                 Information current = new Information();
                 current.iconID = icons[i];
                 current.title = titles[i];
                 data.add(current);
                 // map to the array list

             }
             return data;
         }


}



