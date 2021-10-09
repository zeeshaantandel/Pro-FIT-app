package com.example.fitnessapps2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if(user != null){
                    startActivity(new Intent(MainActivity.this,Mainpage.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                    finish();
                }

                else {
                Intent intent=new Intent(MainActivity.this, startingpage.class);
                startActivity(intent);}
                finish();
            }
        }, 2000);
    }
    public void openstartingpage(){
        Intent intent= new Intent(this, startingpage.class);
        startActivity(intent);
        finish();
    }
}