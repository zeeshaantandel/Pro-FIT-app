package com.example.fitnessapps2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startingpage extends AppCompatActivity {
    Button loginbutton,signupbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startingpage);

        loginbutton=findViewById(R.id.loginbutton);
        signupbutton=findViewById(R.id.signupbutton);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogin();
            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensignup();
            }
        });
    }

    private void openlogin(){
        Intent intent=new Intent(this, Loginactivity.class);
        startActivity(intent);
        finish();
    }

    private void opensignup(){
        Intent intent=new Intent(this, Registeractivity.class);
        startActivity(intent);
        finish();
    }
}