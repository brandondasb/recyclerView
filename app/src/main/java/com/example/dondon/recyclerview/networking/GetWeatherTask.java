package com.example.dondon.recyclerview.networking;

import android.os.AsyncTask;
import android.widget.TextView;

import com.example.dondon.recyclerview.networking.callbacks.GetWeatherTaskCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetWeatherTask extends AsyncTask<String,Void,String>{
private GetWeatherTaskCallBack callBack ;
    public GetWeatherTask(GetWeatherTaskCallBack callBack) {
        this.callBack = callBack;
    }
    @Override
    protected String doInBackground(String... strings) {
        String weather = "UNDEFINED";
        try{
            URL url = new URL(strings[0]); //create url connection
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //open the connection

            InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
          //  get the stream of data from URLS
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));//buffered helps read stream of data line by line

            StringBuilder builder = new StringBuilder();



            String inputString;
            while((inputString = bufferedReader.readLine())!= null ){
            builder.append(inputString);// add each line to string builder
            }
            JSONObject topLevel = new JSONObject(builder.toString()); // create new object instance
            JSONObject main = topLevel.getJSONObject("main");// get Json object  named main from from api
            weather = String.valueOf(main.getDouble("temp"));// return temp from main object
            urlConnection.disconnect();


        }catch (IOException | JSONException e)
        {e.printStackTrace();}

        return weather;
    }

    @Override
    protected void onPostExecute(String temp) {
        callBack.updateTemp("ok so the current weather is:   " + temp);
    }


}
