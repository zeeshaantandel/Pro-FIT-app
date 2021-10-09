package com.example.fitnessapps2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class trackActivity extends AppCompatActivity {
    public BottomNavigationView bottomNavigationView;
    CardView walkModule,runModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        walkModule=findViewById(R.id.walkModule);
        walkModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openstepcounter();
            }
        });

        runModule=findViewById(R.id.runModule);
        runModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmaptracking();
            }
        });

        bottomNavigationView=findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.record);
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
    }

    private void openstepcounter(){
        Intent intent=new Intent(this, stepCounter.class);
        startActivity(intent);
    }

    private void openmaptracking(){
        Intent intent=new Intent(trackActivity.this, MapsActivity.class);
        startActivity(intent);
    }
}