package com.example.fitnessapps2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

public class workout_cardio extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_cardio);

        ViewPager viewpager = findViewById(R.id.viewpager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewpager.setAdapter(adapter);

    }
}