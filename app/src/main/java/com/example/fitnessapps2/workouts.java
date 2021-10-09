package com.example.fitnessapps2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class workouts extends AppCompatActivity {
    public BottomNavigationView bottomNavigationView;
    private CardView cardioModule;
    private CardView muscleGroupModule;
    private CardView yogaModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.workouts);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.diet:
                        startActivity(new Intent(getApplicationContext(),dietPlans.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.record:
                        startActivity(new Intent(getApplicationContext(),trackActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.articles:
                        startActivity(new Intent(getApplicationContext(),articles.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.workouts:
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), profile_and_settings.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

        cardioModule=findViewById(R.id.cardioModule);
        cardioModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencardio();
            }
        });

        muscleGroupModule=findViewById(R.id.muscleGroupModule);
        muscleGroupModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmusclegroups();
            }
        });

        yogaModule=findViewById(R.id.yogaModule);
        yogaModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openyoga();
            }
        });
    }

    private void opencardio(){
        Intent intent=new Intent(this, workout_cardio.class);
        startActivity(intent);
    }

    private void openmusclegroups(){
        Intent intent=new Intent(workouts.this, workout_muscle.class);
        startActivity(intent);
    }

    private void openyoga(){
        Intent intent=new Intent(workouts.this, workout_yoga.class);
        startActivity(intent);
    }
}