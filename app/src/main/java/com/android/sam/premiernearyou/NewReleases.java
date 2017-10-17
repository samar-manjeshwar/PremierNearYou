package com.android.sam.premiernearyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.sam.premiernearyou.services.tmdbServices;

import java.util.ArrayList;

public class NewReleases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_releases);

        String APIKey = "c0aca2e06d7bc4b75e6c23e03828eb26";
        String link = "https://api.themoviedb.org/3/movie/upcoming?api_key=" + APIKey + "&language=en-US&page=1";
        new tmdbServices().execute(link);

    }
}
