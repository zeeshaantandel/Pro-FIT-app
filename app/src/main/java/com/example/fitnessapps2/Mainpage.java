package com.example.fitnessapps2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import static java.lang.Double.valueOf;

public class Mainpage extends AppCompatActivity {
    private RelativeLayout workoutRelativeLayout;
    private RelativeLayout dietRelativeLayout;
    private RelativeLayout recordRelativeLayout;
    private RelativeLayout articlesRelativeLayout;
    private TextView height_display;
    private TextView weight_display;
    private TextView bmi_display;
    private RelativeLayout resultcircle;
    private CardView profileicon;
    private FirebaseAuth auth;
    private FirebaseFirestore db;
    String userID;
    String bmi_result="bmi_result";
    String bmi_height="bmi_height";
    String bmi_weight="bmi_weight";
    int height_int;
    int weight_int;
    int result_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        workoutRelativeLayout=findViewById(R.id.workoutRelativeLayout);
        workoutRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWorkouts();
            }
        });
        dietRelativeLayout=findViewById(R.id.dietRelativeLayout);
        dietRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiet();
            }
        });
        recordRelativeLayout=findViewById(R.id.recordRelativeLayout);
        recordRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTracking();
            }
        });
        articlesRelativeLayout=findViewById(R.id.articlesRelativeLayout);
        articlesRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArticles();
            }
        });

        profileicon=findViewById(R.id.profileicon);
        profileicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openprofile();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        height_display=findViewById(R.id.height_display);
        weight_display=findViewById(R.id.weight_display);
        bmi_display=findViewById(R.id.Bmi_result);
        resultcircle=findViewById(R.id.resultcircle);
        db=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();
        userID=auth.getCurrentUser().getUid();
        DocumentReference documentReference=db.collection("Bmi_values").document(userID);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()) {
                    Double height = documentSnapshot.getDouble(bmi_height);
                    Double weight = documentSnapshot.getDouble(bmi_weight);
                    Double result = documentSnapshot.getDouble(bmi_result);
                    height_int = height.intValue();
                    weight_int = weight.intValue();
                    // result_int=result.intValue();
                    String result_string = String.format("%.2f", result);
                    height_display.setText(Integer.toString(height_int) + " CM");
                    weight_display.setText(Integer.toString(weight_int) + " KG");
                    bmi_display.setText(result_string);

                    if (result<18.50){
                        resultcircle.setBackgroundResource(R.drawable.bmi_bg_underweight);
                    }
                    else if (result>=18.50 && result<=25) {
                        resultcircle.setBackgroundResource(R.drawable.bmi_bg_normal);
                    }
                    else if (result>25 && result<=30) {
                        resultcircle.setBackgroundResource(R.drawable.bmi_bg_overweight);
                    }
                    else{
                        resultcircle.setBackgroundResource(R.drawable.bmi_bg_obese);
                    }
                }
            }

        });
    }

    public void openWorkouts(){
        Intent intent=new Intent(this, workouts.class);
        startActivity(intent);
    }
    public void openDiet(){
        Intent intent=new Intent(this, dietPlans.class);
        startActivity(intent);
    }
    public void openTracking(){
        Intent intent=new Intent(this, trackActivity.class);
        startActivity(intent);
    }
    public void openArticles(){
        Intent intent=new Intent(this, articles.class);
        startActivity(intent);
    }

    public void openprofile(){
        Intent intent=new Intent(Mainpage.this, profile_and_settings.class);
        startActivity(intent);
    }
}