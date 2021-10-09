package com.example.fitnessapps2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dietPlans extends AppCompatActivity {
    public BottomNavigationView bottomNavigationView;
    CardView weightGainModule, weightLossModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plans);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.diet);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.diet:
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
                        startActivity(new Intent(getApplicationContext(),workouts.class));
                        finish();
                        overridePendingTransition(0,0);
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

        weightGainModule=findViewById(R.id.weightGainModule);
        weightGainModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openweightgain();
            }
        });

        weightLossModule=findViewById(R.id.weightLossModule);
        weightLossModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openweightloss();
            }
        });
    }

    private void openweightgain(){
        Intent intent=new Intent(dietPlans.this, weightGain.class);
        startActivity(intent);
    }

    private void openweightloss(){
        Intent intent=new Intent(dietPlans.this, weightLoss.class);
        startActivity(intent);
    }
}