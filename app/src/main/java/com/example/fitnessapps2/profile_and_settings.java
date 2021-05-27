package com.example.fitnessapps2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profile_and_settings extends AppCompatActivity {
    public BottomNavigationView bottomNavigationView;
    private TextView Termsandconditions;
    private TextView privacypolicy;
    private TextView contactUs;
    private TextView aboutUs;
    private TextView editProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_and_settings);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.profile);
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
                        startActivity(new Intent(getApplicationContext(),workouts.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profile:
                        return true;

                }
                return false;
            }
        });

        Termsandconditions=findViewById(R.id.Termsandconditions);
        Termsandconditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openterms();
            }
        });

        privacypolicy=findViewById(R.id.privacypolicy);
        privacypolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openprivacypolicy();
            }
        });

        contactUs=findViewById(R.id.contactUs);
        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openContactUs();
            }
        });

        aboutUs=findViewById(R.id.aboutUs);
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAboutUs();
            }
        });

        editProfile=findViewById(R.id.editProfile);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditProfile();
            }
        });
    }

    private void openterms(){
        Intent intent=new Intent(this,TermsandConditions.class);
        startActivity(intent);
    }

    private void openprivacypolicy(){
        Intent intent=new Intent(this,PrivacyPolicy.class);
        startActivity(intent);
    }

    private void openContactUs(){
        Intent intent=new Intent(this,ContactUs.class);
        startActivity(intent);
    }

    private void openAboutUs(){
        Intent intent=new Intent(this,AboutUs.class);
        startActivity(intent);
    }

    private void openEditProfile(){
        Intent intent=new Intent(this,EditProfile.class);
        startActivity(intent);
    }
}

