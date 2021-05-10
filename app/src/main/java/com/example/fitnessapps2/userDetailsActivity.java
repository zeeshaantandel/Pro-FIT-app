package com.example.fitnessapps2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class userDetailsActivity extends AppCompatActivity {
    private TextView currentHeight;
    private SeekBar seekBarHeight;
    private TextView currentWeight;
    private SeekBar seekBarWeight;
    private TextView currentAge;
    private SeekBar seekBarAge;
    private Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        currentHeight=findViewById(R.id.currentHeight);
        seekBarHeight=findViewById(R.id.seekBarHeight);
        seekBarHeight.setMax(230);
        seekBarHeight.setProgress(100);
        seekBarHeight.incrementProgressBy(1);
        seekBarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                currentHeight.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        currentWeight=findViewById(R.id.currentWeight);
        seekBarWeight=findViewById(R.id.seekBarWeight);
        seekBarWeight.setMax(150);
        seekBarWeight.setMin(30);
        seekBarWeight.setProgress(60);
        seekBarWeight.incrementProgressBy(1);
        seekBarWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                currentWeight.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        currentAge=findViewById(R.id.currentAge);
        seekBarAge=findViewById(R.id.seekBarAge);
        seekBarAge.setMin(10);
        seekBarAge.setMax(80);
        seekBarAge.setProgress(20);
        seekBarAge.incrementProgressBy(1);
        seekBarAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                currentAge.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        proceed=findViewById(R.id.proceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainPage();
            }
        });
    }

    public void openMainPage(){
        Intent intent=new Intent(this, Mainpage.class);
        startActivity(intent);
    }
}