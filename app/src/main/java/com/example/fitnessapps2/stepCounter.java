package com.example.fitnessapps2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class stepCounter extends AppCompatActivity implements SensorEventListener, StepListener, GestureDetector.OnGestureListener {
    ImageView playpausebutton;
    RelativeLayout playpause;
    boolean status=false;

    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private static final String TEXT_NUM_STEPS = "Number of Steps: ";
    private int numSteps;
    double distance1, calorie1;
    private TextView stepCount, calorie, distance;
    private Button BtnStart, BtnStop;

    String stepCountStr= "0";
    String calorieStr="0";
    String distanceStr="0";
    String datetimeStr;

    //    private Button sendDatabtn;
    float MainStepCount = 0 , MainCalorie = 0, MainDistance = 0;
    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    UsersInfos userInfo;
    String formattedDate;
    Date date ;
    //    Date date1 ;
//    Date newDate;
    DatabaseReference ref;
    FirebaseAuth auth;
    float x1, y1, x2, y2;


    private static final String TAG="swipe position";
    private static int MIN_DISTANCE=150;
    private GestureDetector gestureDetector;

    String userId;
    boolean firstime = false;
    boolean datachange=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);

        auth = FirebaseAuth.getInstance();
        userId = auth.getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference().child(userId).child("UsersInfos");


        this.gestureDetector=new GestureDetector(stepCounter.this,this);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();



        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        formattedDate = df.format(today);


//        FirebaseDatabase.getInstance().getReference().child(userId).child("UsersInfos").child("stepCount").setValue("0");
//        FirebaseDatabase.getInstance().getReference().child(userId).child("UsersInfos").child("calorie").setValue("0");
//        FirebaseDatabase.getInstance().getReference().child(userId).child("UsersInfos").child("distance").setValue("0");
//        FirebaseDatabase.getInstance().getReference().child(userId).child("UsersInfos").child("datetime").setValue(formattedDate);
//        Toast.makeText(this,formattedDate,Toast.LENGTH_SHORT).show();

        datetimeStr = formattedDate;

        date = new Date();


        userInfo = new UsersInfos();
        stepCount = findViewById(R.id.stepcount);
        calorie = findViewById(R.id.caloriescount);
        distance = findViewById(R.id.distancecount);
        playpausebutton=findViewById(R.id.playpausebutton);
        playpause=findViewById(R.id.playpause);
        playpausebutton.setImageResource(R.drawable.ic_baseline_play_arrow_24);
        playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!status){
                    playpausebutton.setImageResource(R.drawable.ic_baseline_stop_24);
                    status=true;
                    //getdata();
                    firstime = true;
                    datachange=false;
                    numSteps = 0;
                    sensorManager.registerListener(stepCounter.this, accel, SensorManager.SENSOR_DELAY_FASTEST);
                }
                else {
                    playpausebutton.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                    status=false;
                    sensorManager.unregisterListener(stepCounter.this);


                    Date newDate = new Date(date.getTime() + (604800000L * 2) + (24 * 60 * 60));
//                FirebaseDatabase.getInstance().getReference().child("UserInformation").child("datetime").getValue(String.class)


                    if (!datachange){
                        datachange=true;
                        FirebaseDatabase.getInstance().getReference().child(userId).child("UsersInfos").child("datetime").
                                addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        String date = snapshot.getValue(String.class);
                                        System.out.println(date);

                                        if (formattedDate.compareTo(date) == 0) {
                                            // Toast.makeText(stepCounter.this,"Same Date!!",Toast.LENGTH_SHORT).show();
//                                            setData();
                                            getdata();
                                        } else {
                                            FirebaseDatabase.getInstance().getReference().child(userId).child("UsersInfos").child("stepCount").setValue("0");
                                            FirebaseDatabase.getInstance().getReference().child(userId).child("UsersInfos").child("calorie").setValue("0");
                                            FirebaseDatabase.getInstance().getReference().child(userId).child("UsersInfos").child("distance").setValue("0");

                                            SimpleDateFormat dt1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
                                            String stringdate1 = dt1.format(newDate);

                                            System.out.println("Submission Date: " + stringdate1);
                                            FirebaseDatabase.getInstance().getReference().child(userId).child("UsersInfos").child("datetime").setValue(formattedDate);
//                                            getdata();
                                            getdata();
                                        }


                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                        System.out.println("The read failed: " + databaseError.getCode());
                                    }
                                });
                    }

                }
            }
        });
    }

    private void getdata() {

//        FirebaseDatabase.getInstance().getReference().child("UsersInfo").child("stepCount").getValue(String.class);
        // calling add value event listener method
        // for getting the values from database.
        FirebaseDatabase.getInstance().getReference().child(userId).child("UsersInfos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
//                String val = firebaseDatabase.getInstance().getReference().child("UserInfo").child("userStepCount").getValue(String.class);

                stepCountStr = snapshot.child("stepCount").getValue(String.class);
                calorieStr = snapshot.child("calorie").getValue(String.class);
                distanceStr = snapshot.child("distance").getValue(String.class);
                datetimeStr = snapshot.child("datetime").getValue(String.class);
                //Toast.makeText(stepCounter.this,"Get Data from Database :  "+stepCountStr + " : " + calorieStr + " : "+ distanceStr + " : " + datetimeStr,Toast.LENGTH_LONG).show();
                System.out.println("5 ----- "+stepCountStr + " " + distanceStr + " " + calorieStr + " : "+ datetimeStr);
                if(firstime){
                    setData();
                    firstime = false;
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(stepCounter.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }






    private void setData() {

        MainStepCount = Float.parseFloat(stepCountStr);
        MainDistance = Float.parseFloat(distanceStr);
        MainCalorie = Float.parseFloat(calorieStr);
        System.out.println(" 1 : "+stepCount.getText().toString() + " : " + calorie.getText().toString() + " : " + distance.getText().toString());


        String stepCount1 = stepCount.getText().toString();
        String distance1 = distance.getText().toString();
        String calorie1 = calorie.getText().toString();

        float stepCountVal = Float.valueOf(stepCount1) + Float.valueOf(MainStepCount);
        float calorieVal = Float.valueOf(calorie1) + Float.valueOf(MainCalorie);
        float distanceVal = Float.valueOf(distance1) + Float.valueOf(MainDistance);

        String stepCount3 = String.valueOf(stepCountVal);
        String calorie3 = String.valueOf(calorieVal);
        String distance3 = String.valueOf(distanceVal);


        // Toast.makeText(this, datetimeStr, Toast.LENGTH_SHORT).show();
        addDatatoFirebase(stepCount3, calorie3, distance3,datetimeStr);


    }


    private void addDatatoFirebase(String stepCount2, String calorie2, String distance2, String datetime2) {

        userInfo.setStepCount(stepCount2);
        userInfo.setCalorie(calorie2);
        userInfo.setDistance(distance2);
        userInfo.setDatetime(datetime2);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                databaseReference.setValue(userInfo);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(stepCounter.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void step(long timeNs) {
        numSteps=numSteps+2;

        distance1 = (double) (numSteps * 4) / 10000;

        //calculating calories
        int weight = Integer.parseInt("70");
        calorie1 = numSteps * 0.037;
        //set steps, distance and calories to TextView's

        stepCount.setText(String.valueOf(numSteps));
        distance.setText(String.format("%.3f", distance1));
        calorie.setText(String.format("%.2f", calorie1));
    }

    @Override
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
                if(x1 > x2) {
                    Intent i = new Intent(stepCounter.this, totaldaycount.class);
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
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}