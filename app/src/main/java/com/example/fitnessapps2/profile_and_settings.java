package com.example.fitnessapps2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

import static com.example.fitnessapps2.App.CHANNEL;

public class profile_and_settings extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    public BottomNavigationView bottomNavigationView;
    private TextView Termsandconditions;
    private TextView privacypolicy;
    private TextView contactUs;
    private TextView aboutUs;
    private TextView editProfile;
    private TextView logout;
    private TextView profilename;
    private TextView height_display;
    private TextView weight_display;
    private TextView age_display;
    private Switch notificationswitch;

    private FirebaseAuth auth;
    private FirebaseFirestore db;
    String userID;
    String User_age="User_age";
    String bmi_height="bmi_height";
    String bmi_weight="bmi_weight";
    String username="username";
    int height_int;
    int weight_int;
    int user_int;

    private static String MY_PREFS="switch_prefs";
    private static String SWITCH_STATUS="switch_status";
    boolean switch_status;
    SharedPreferences myPreferences;
    SharedPreferences.Editor myEditor;

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
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.record:
                        startActivity(new Intent(getApplicationContext(),trackActivity.class));
                        finish();
                        overridePendingTransition(0,0);
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

        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(profile_and_settings.this,"Logged Out",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(profile_and_settings.this, startingpage.class));
                finish();
            }
        });

        notificationswitch=findViewById(R.id.notificationswitch);
        myPreferences=getSharedPreferences(MY_PREFS,MODE_PRIVATE);
        myEditor=getSharedPreferences(MY_PREFS,MODE_PRIVATE).edit();
        switch_status=myPreferences.getBoolean(SWITCH_STATUS,false);
        notificationswitch.setChecked(switch_status);




        notificationswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b==true){
                    DialogFragment timePicker=new TimePickerFragment();
                    timePicker.show(getSupportFragmentManager(),"time picker");

                    myEditor.putBoolean(SWITCH_STATUS,true);
                    myEditor.apply();
                    notificationswitch.setChecked(true);
                }else
                {
                    myEditor.putBoolean(SWITCH_STATUS,false);
                    myEditor.apply();
                    notificationswitch.setChecked(false);

                    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                        NotificationManager manager=getSystemService(NotificationManager.class);
                        manager.deleteNotificationChannel(CHANNEL);

                    }
                    Toast.makeText(profile_and_settings.this, "Notification turned off", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        height_display=findViewById(R.id.P_height);
        weight_display=findViewById(R.id.p_weight);
        age_display=findViewById(R.id.P_age);

        db= FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();
        userID=auth.getCurrentUser().getUid();
        DocumentReference documentReference=db.collection("Bmi_values").document(userID);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    Double height=documentSnapshot.getDouble(bmi_height);
                    Double weight=documentSnapshot.getDouble(bmi_weight);
                    Double age=documentSnapshot.getDouble(User_age);
                    height_int=height.intValue();
                    weight_int=weight.intValue();
                    user_int=age.intValue();
                    height_display.setText(Integer.toString(height_int)+" CM");
                    weight_display.setText(Integer.toString(weight_int)+" KG");
                    age_display.setText(Integer.toString(user_int)+" YRS");

                }
            }
        });
        profilename=findViewById(R.id.profileName);
        DocumentReference ref=db.collection("users").document(userID);
        ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    String name=documentSnapshot.getString(username);
                    profilename.setText(name);
                }
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
        finish();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        Calendar calendar=Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,5);
        createNotificationChannel();
        Intent intent=new Intent(getApplicationContext(),Notification_reciver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
    }
    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){


            int importance= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel(CHANNEL,"Channel",importance);
            channel.setDescription("Channel for default notification");

            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}