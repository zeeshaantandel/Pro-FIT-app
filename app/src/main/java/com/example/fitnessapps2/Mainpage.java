package com.example.fitnessapps2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Mainpage extends AppCompatActivity {
    private RelativeLayout workoutRelativeLayout;
    private RelativeLayout dietRelativeLayout;
    private RelativeLayout recordRelativeLayout;
    private RelativeLayout articlesRelativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        workoutRelativeLayout=findViewById(R.id.workoutRelativeLayout);
        workoutRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWorkouts();
            }
        });
        dietRelativeLayout=findViewById(R.id.dietRelativeLayout);
        dietRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiet();
            }
        });
        recordRelativeLayout=findViewById(R.id.recordRelativeLayout);
        recordRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTracking();
            }
        });
        articlesRelativeLayout=findViewById(R.id.articlesRelativeLayout);
        articlesRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArticles();
            }
        });
    }
    public void openWorkouts(){
        Intent intent=new Intent(this, workouts.class);
        startActivity(intent);
    }
    public void openDiet(){
        Intent intent=new Intent(this, dietPlans.class);
        startActivity(intent);
    }
    public void openTracking(){
        Intent intent=new Intent(this, trackActivity.class);
        startActivity(intent);
    }
    public void openArticles(){
        Intent intent=new Intent(this, articles.class);
        startActivity(intent);
    }
}