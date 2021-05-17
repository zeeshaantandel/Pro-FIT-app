package com.example.fitnessapps2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class workouts extends AppCompatActivity {
    public BottomNavigationView bottomNavigationView;

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
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.record:
                        startActivity(new Intent(getApplicationContext(),trackActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.articles:
                        startActivity(new Intent(getApplicationContext(),articles.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.workouts:
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), profile_and_settings.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
    }
}