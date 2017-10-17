package com.android.sam.premiernearyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView releases =  (TextView)findViewById(R.id.newrelease_text_view);
        releases.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent release = new Intent(MainActivity.this,NewReleases.class);
                startActivity(release);
            }
        });

        TextView top = (TextView)findViewById(R.id.toppicks_text_view);
        top.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent pick = new Intent(MainActivity.this,TopPicks.class);
                startActivity(pick);
            }
        });

    }

}
