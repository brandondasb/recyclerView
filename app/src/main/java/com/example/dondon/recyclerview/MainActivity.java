package com.example.dondon.recyclerview;

import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
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

public class MainActivity extends AppCompatActivity {


    /*weather api set up*/
    private static final String APP_ID = "20c0e8ec89f405053f39615cd1c590aa";
    double lat = 40.712774, lon = -74.006091;
    String units = "metric";
    String url = String.format("http://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&units=%s&appid=%s",
            lat, lon, units, APP_ID);

    /*rest*/
    private String string = "string";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*weather*/
        TextView textView =  findViewById(R.id.tv_weather);
        new GetWeatherTask1(textView).execute(url);
        // new GetWeatherTask(textView).execute(url);// in diff file


        //Button StartButton = new Button(this); //try to add new button view Java epic fail
        Button StartButton = findViewById(R.id.start_button);
        StartButton.setOnClickListener(fragmentClickListener);


    }



    private View.OnClickListener fragmentClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
            //get an instance of fragment transaction



            FragmentPopup fragmentPopup = new FragmentPopup();
            // create an instance of the fragment first
            fragmentTransaction.add(R.id.fragment_container,fragmentPopup);
            //you can then add a fragment  by specifying the fragment and the view in which to insert it to.
            // first argument is the viewGroup in which the fragment will be placed , specified by the resource
            //second argument is the fragment to add.
            fragmentTransaction.commit();
            //must call commit for the fragment changes to take place


            // step 1: launch new activity with Intent
            // step 2: that activity has new xml layout containing fragment
            // step 3: FragmentPopup works as it does now
            //


        }
    };

}
/*weather*/
  class GetWeatherTask1 extends AsyncTask<String,Void,String> {
      TextView textView;

    public GetWeatherTask1(TextView textView){
         this.textView = textView;
     }

    @Override
    protected String doInBackground(String... strings) {
        String weather = "UNDEFINED";
        try {
            URL url = new URL(strings[0]); //create url connection
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //open the connection

            InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
            //  get the stream of data from URLS
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));//buffered helps read stream of data line by line

            StringBuilder builder = new StringBuilder();


            String inputString;
            while ((inputString = bufferedReader.readLine()) != null) {
                builder.append(inputString);// add each line to string builder
            }
            JSONObject topLevel = new JSONObject(builder.toString()); // create new object instance
            JSONObject main = topLevel.getJSONObject("main");// get Json object  named main from from api
            weather = String.valueOf(main.getDouble("temp"));// return temp from main object
            urlConnection.disconnect();


        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return weather;
    }

    @Override
    protected void onPostExecute(String temp) {
        textView.setText("ok so the current weather is:  " + temp);
        //   super.onPostExecute(temp);
    }
}


