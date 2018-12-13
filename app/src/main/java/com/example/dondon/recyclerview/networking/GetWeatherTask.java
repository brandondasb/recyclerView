package com.example.dondon.recyclerview.networking;

import android.os.AsyncTask;
import android.util.Log;

import com.example.dondon.recyclerview.model.WeatherMain;
import com.example.dondon.recyclerview.model.Weather;
import com.example.dondon.recyclerview.model.WeatherResponse;
import com.example.dondon.recyclerview.model.WeatherSys;
import com.example.dondon.recyclerview.networking.callbacks.GetWeatherTaskCallBack;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetWeatherTask extends AsyncTask<String,Void,WeatherResponse>{
private GetWeatherTaskCallBack callBack ;
private String urlString;
    public GetWeatherTask(GetWeatherTaskCallBack callBack, String urlString) {
        this.callBack = callBack;
        this.urlString = urlString;
    }
    @Override
    protected WeatherResponse doInBackground(String... strings) {
        String weather = "UNDEFINED";
        String  currentTemp = "not serialised";
        try{
            URL url = new URL(urlString); //create url connection
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(); //open the connection

            InputStream stream = new BufferedInputStream(urlConnection.getInputStream()); //  get the stream of dataMain from URLS
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));//buffered helps read stream of dataMain line by line
            StringBuilder builder = new StringBuilder();

            String inputString;
            while((inputString = bufferedReader.readLine())!= null ){
            builder.append(inputString);// add each line to string builder
            }

           JSONObject topLevel = new JSONObject(builder.toString()); // create new object instance of JSON
            // call get json objects needed from
          //  JSONObject main = topLevel.getJSONObject("main");// get Json object  named main from from api
           // JSONObject sys = topLevel.getJSONObject("sys");// get Json object  named sys from from api


            urlConnection.disconnect();

            // GSON Deserialization Convert JSON  to java Object
            Gson gson = new Gson();
            //Json to Java Object , reads it from Json nd pass it to the data model we created earlier
          //  WeatherMain dataMain = gson.fromJson(main.toString(), WeatherMain.class);
            WeatherResponse toplevelList = gson.fromJson(topLevel.toString(),WeatherResponse.class);
           // WeatherSys dataSys = gson.fromJson(sys.toString(),WeatherSys.class);
           // Log.e("@@@", dataMain.getPressure().toString());

            return toplevelList;

        }catch (IOException | JSONException e)
        {e.printStackTrace();}

      //return weather;
        return null;
    }

    @Override
    protected void onPostExecute(WeatherResponse temp) {
        callBack.updateTemp("ok so the current weather is:   " + temp.getList());
    }


}
