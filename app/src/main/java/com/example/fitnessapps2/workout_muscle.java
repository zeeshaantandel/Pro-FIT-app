package com.example.fitnessapps2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.WindowManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class workout_muscle extends AppCompatActivity
{
    ViewPager2 viewPager2;
    videoadapter1 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_muscle);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewPager2=(ViewPager2)findViewById(R.id.vpager);

        FirebaseRecyclerOptions<videomodel1> options =
                new FirebaseRecyclerOptions.Builder<videomodel1>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("muscularvideos"), videomodel1.class)
                        .build();

        adapter=new videoadapter1(options);
        viewPager2.setAdapter(adapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}