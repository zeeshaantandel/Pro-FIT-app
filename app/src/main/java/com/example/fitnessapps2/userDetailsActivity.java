package com.example.fitnessapps2;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class userDetailsActivity extends AppCompatActivity {
    private TextView currentHeight;
    private SeekBar seekBarHeight;
    private TextView currentWeight;
    private SeekBar seekBarWeight;
    private TextView currentAge;
    private SeekBar seekBarAge;
    private RelativeLayout male,female;

    String typeofuser;

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

        male=findViewById(R.id.male);
        female=findViewById(R.id.female);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_focus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_not_focus));
                typeofuser="Male";
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_focus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_not_focus));
                typeofuser="Female";
            }
        });

    }
}