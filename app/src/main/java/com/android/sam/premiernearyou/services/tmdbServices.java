package com.android.sam.premiernearyou.services;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.sam.premiernearyou.Data.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Lenovo on 09-10-2017.
 */

public class tmdbServices extends AsyncTask<String,Void,String> {


    public results results;
    public ArrayList<results> resultsArrayList;

    @Override
    protected String doInBackground(String... params) {


        try {

            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();


            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String str = reader.readLine();
            while(str != null){
                sb.append(str);
                str = reader.readLine();
            }
            return sb.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {

        try {

            JSONObject parent = new JSONObject(s);
            JSONArray res = parent.optJSONArray("results");

            for(int i=0;i<res.length();i++){
                JSONObject sub = res.getJSONObject(i);
                results = new results();
                results.setTitle(sub.getString("title"));
                results.setOverview(sub.getString("overview"));
                results.setReleaseDate(sub.getString("release_date"));

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
