package com.example.dondon.recyclerview;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dondon.recyclerview.model.WeatherResponse;
import com.example.dondon.recyclerview.networking.GetWeatherTask;
import com.example.dondon.recyclerview.networking.callbacks.GetWeatherTaskCallBack;



public class MainActivity extends AppCompatActivity {


    /*weather api set up*/
    private static final String APP_ID = "20c0e8ec89f405053f39615cd1c590aa";
    String units = "metric";
    String url = String.format("http://api.openweathermap.org/data/2.5/group?id=2642743,2800865,2964630,3664980,3458494&appid=%s",
             APP_ID);

    /*rest*/
    private String string = "string";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;
    private TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*weather*/
        textView =  findViewById(R.id.tv_weather);
        //Button StartButton = new Button(this); //try to add new button view Java epic fail
        Button StartButton = findViewById(R.id.start_button);
        StartButton.setOnClickListener(fragmentClickListener);
    }
    private View.OnClickListener fragmentClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new GetWeatherTask(weatherTaskCallBack, url).execute(url);// call call back class
        }
    };
    private GetWeatherTaskCallBack  weatherTaskCallBack = new GetWeatherTaskCallBack() {
        @Override
        public void updateTemp(WeatherResponse weatherResponse) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();   //get an instance of fragment transaction
            FragmentPopup fragmentPopup = new FragmentPopup();  // create an instance of the fragment first
            Bundle args = new Bundle();
            args.putSerializable("weather", weatherResponse);
            fragmentPopup.setArguments(args);

            fragmentTransaction.add(android.R.id.content,fragmentPopup);// content adds it to the root   //you can then add a fragment  by specifying the fragment and the view in which to insert it to.
            // first argument is the viewGroup in which the fragment will be placed , specified by the resource,  //second argument is the fragment to add.
            fragmentTransaction.addToBackStack(FragmentPopup.class.getSimpleName());
            fragmentTransaction.commit();        //must call commit for the fragment changes to take place
        }
    };
}


