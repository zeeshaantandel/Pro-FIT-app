package com.example.fitnessapps2;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registeractivity extends AppCompatActivity {
    public TextView alreadyHaveAccount;
    private EditText inputEmail;
    private EditText password;
    private EditText confirmPassword;
    private Button loginbutton;
    private FirebaseFirestore fstore;
    DatabaseReference def;
    private FirebaseAuth auth;
    private Button buttonRegister;
    private EditText username;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);
       // alreadyHaveAccount=findViewById(R.id.alreadyHaveAccount);

       /* alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });*/
        username=findViewById(R.id.inputUsername);
        confirmPassword=findViewById(R.id.confirmPassword);
        inputEmail=findViewById(R.id.inputEmail);
        password=findViewById(R.id.password);
        buttonRegister=findViewById(R.id.buttonRegister);
        loginbutton=findViewById(R.id.loginbutton);
        auth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogin();
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt_Email=inputEmail.getText().toString().trim();
                String txt_Password=password.getText().toString().trim();
                String txt_Username=username.getText().toString().trim();
                String txt_confirmPassword=confirmPassword.getText().toString().trim();
                if(txt_Password.equals(txt_confirmPassword)) {
                    if (TextUtils.isEmpty(txt_Email) || TextUtils.isEmpty(txt_Password)) {
                        Toast.makeText(Registeractivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                    } else if (!isValidPassword(txt_Password)) {
                        Toast.makeText(Registeractivity.this, "Password must contain mix of upper and lower case letters as well as digits and one special character(4-20)", Toast.LENGTH_LONG).show();
                    } else {
                        RegisterUser(txt_Email, txt_Password,txt_Username);
                    }
                }
                else{
                    Toast.makeText(Registeractivity.this, "Confirm password is not correct", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    private void RegisterUser(String email, String password, String uname) {


        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Registeractivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Registeractivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                    uid=auth.getUid();
                    Map<String, Object> user = new HashMap<>();
                    user.put("email", email);
                    user.put("username",uname);

                    fstore.collection("users").document(uid).set(user);

                    Calendar calendar = Calendar.getInstance();
                    Date today = calendar.getTime();


                    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
                    String formattedDate = df.format(today);

                    def = FirebaseDatabase.getInstance().getReference().child(uid);
                    def.child("UsersInfos").child("stepCount").setValue("0");
                    def.child("UsersInfos").child("calorie").setValue("0");
                    def.child("UsersInfos").child("distance").setValue("0");
                    def.child("UsersInfos").child("datetime").setValue(formattedDate);


//                    def.child("days").child("1").child("stepCount").setValue("0");
//                    def.child("days").child("1").child("stepCount").setValue("0");
//
//                    def.child("days").child("2").child("stepCount").setValue("0");
//                    def.child("days").child("2").child("stepCount").setValue("0");
//
//                    def.child("days").child("3").child("stepCount").setValue("0");
//                    def.child("days").child("3").child("stepCount").setValue("0");
//
//                    def.child("days").child("4").child("stepCount").setValue("0");
//                    def.child("days").child("4").child("stepCount").setValue("0");
//
//                    def.child("days").child("5").child("stepCount").setValue("0");
//                    def.child("days").child("5").child("stepCount").setValue("0");
//
//                    def.child("days").child("6").child("stepCount").setValue("0");
//                    def.child("days").child("6").child("stepCount").setValue("0");
//
//                    def.child("days").child("7").child("stepCount").setValue("0");
//                    def.child("days").child("7").child("stepCount").setValue("0");

                    openbmi();
                    finish();
                }else{
                    Toast.makeText(Registeractivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void openbmi() {
        Intent intent = new Intent(this, userDetailsActivity.class);
        startActivity(intent);
        finish();
    }

    public void openlogin() {
        Intent intent = new Intent(this, Loginactivity.class);
        startActivity(intent);
        finish();
    }

    public static boolean isValidPassword(String password) {
        Matcher matcher = Pattern.compile("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{4,20})").matcher(password);
        return matcher.matches();
    }
}