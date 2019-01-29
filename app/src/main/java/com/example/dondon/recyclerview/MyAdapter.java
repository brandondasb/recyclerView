package com.example.dondon.recyclerview;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dondon.recyclerview.model.Weather;

import java.util.Collections;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private  LayoutInflater inflater;
    private List<Weather> data = Collections.emptyList();
    // list of data generation frm th list time class and initialise it

    public MyAdapter(Context context, List<Weather> data) {
        inflater= LayoutInflater.from(context);
        this.data = data;
    }
    //create constructor that contains a layout inflater to inflate the XML generated listitem component

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //every time a row is displayed the on create view holder is called
      View view =   inflater.inflate(R.layout.custom_row, parent,false);
      //represent the route of the custom _row xml file
        MyViewHolder  holder =  new MyViewHolder(view);
        //create view holder and pass the View
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //this is where we set the data correspond to the current row
        Weather weatherData = data.get(position);
       // we can pull from the list frm pulling the current position
        holder.title.setText(weatherData.getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    //expects a viewHolder , it expect you to have another that extends recyclerView.ViewHolder

class MyViewHolder extends RecyclerView.ViewHolder{
        //here is were we pass the field frm XML file
    TextView title;
    ImageView icon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.listText);
            icon = itemView.findViewById(R.id.listIcon);

        }

    }




    }


