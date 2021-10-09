package com.example.fitnessapps2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class totaldaycount extends AppCompatActivity {
    String stepCountStr;
    String calorieStr;
    String distanceStr;
    String datetimeStr;

    FirebaseAuth auth;
    String userId;

    float x1, y1, x2, y2;


    private static final String TAG="swipe position";
    private static int MIN_DISTANCE=150;
    private GestureDetector gestureDetector;

    DatabaseReference databaseReference;

    private TextView stepcount, caloriescount, distancecount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totaldaycount);

        auth = FirebaseAuth.getInstance();
        userId = auth.getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference().child(userId).child("UsersInfos");


        stepcount= (TextView) findViewById(R.id.stepcount);
        caloriescount = (TextView) findViewById(R.id.caloriescount);
        distancecount = (TextView) findViewById(R.id.distancecount);

        getdata();

    }


    /*@Override
    protected void onResume() {
        super.onResume();
        stepcount.setText(stepCountStr);
        caloriescount.setText(calorieStr);
        distancecount.setText(distanceStr);

        System.out.println("4 ----- "+stepCountStr + " " + distanceStr + " " + calorieStr + " : "+ datetimeStr);

    }*/

    private void getdata() {


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                stepCountStr = snapshot.child("stepCount").getValue(String.class);
                calorieStr = snapshot.child("calorie").getValue(String.class);
                distanceStr = snapshot.child("distance").getValue(String.class);
                datetimeStr = snapshot.child("datetime").getValue(String.class);
                // Toast.makeText(StepCounter.this,"Get Data from Database :  "+stepCountStr + " : " + calorieStr + " : "+ distanceStr + " : " + datetimeStr,Toast.LENGTH_LONG).show();
                System.out.println("5 ----- "+stepCountStr + " " + distanceStr + " " + calorieStr + " : "+ datetimeStr);
                setdata();



//                Toast.makeText(MainActivity.this, stepCount + " "+ calorie + " " + distance ,Toast.LENGTH_LONG).show();


//                I have commented the above statement.
//                Which toasts the value of stepcount and calorie and distance.
//
                // after getting the value we are setting
                // our value to our text view in below line.
//                retriveTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                //  Toast.makeText(StepCounter.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setdata(){
        stepcount.setText(stepCountStr);
        caloriescount.setText(calorieStr);
        distancecount.setText(distanceStr);

        distancecount.setText(String.format("%.3f", Double.parseDouble(distanceStr)));
        caloriescount.setText(String.format("%.2f",Double.parseDouble(calorieStr)));
    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                if(x2 > x1) {
                    Intent i = new Intent(totaldaycount.this, stepCounter.class);
                    //          i.putExtra("stepcount",stepCountStr);
                    //        i.putExtra("caloriescount",calorieStr);
                    //      i.putExtra("distancecount",distanceStr);
                    startActivity(i);
                }
//            }else if(x1 > x2){
//                Intent i = new Intent(MainActivity.this, SwipeRight.class);
//                startActivity(i);
//            }
                break;
        }

        return super.onTouchEvent(event);
    }*/

}