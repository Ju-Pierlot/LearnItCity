package com.example.learnitcity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.learnitcity.R;
import com.example.learnitcity.model.city2d.GameSurface;

public class CityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout) ;
        //scrollView.setBackgroundColor(Color.BLUE);

        /*
        scrollView.setMinimumHeight(1900);
        scrollView.setMinimumWidth(1070);*/

        //linearLayout.addView(new GameSurface(this));


        //scrollView.addView(new GameSurface(this));
        //scroll.addView(new GameSurface(scroll.getContext()));
        //this.setContentView(new GameSurface(this));
    }
}
