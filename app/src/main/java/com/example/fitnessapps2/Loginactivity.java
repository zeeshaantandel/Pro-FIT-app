package com.example.fitnessapps2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import io.perfmark.Tag;

public class Loginactivity extends AppCompatActivity {
    public TextView signUp;
    private Button buttonLogin;
    private EditText inputEmail;
    private EditText password;
    private TextView forgetpassword;
    private Button signupbutton;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        buttonLogin = findViewById(R.id.buttonLogin);
        inputEmail = findViewById(R.id.inputEmail);
        password = findViewById(R.id.password);
        signupbutton=findViewById(R.id.signupbutton);
        auth = FirebaseAuth.getInstance();

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openregister();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = inputEmail.getText().toString();
                String txt_password = password.getText().toString();
                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(Loginactivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                } else {
                    loginUser(txt_email, txt_password);
                }
            }


            private void loginUser(String txt_email, String txt_password) {
                auth.signInWithEmailAndPassword(txt_email, txt_password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(Loginactivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        openBmi();
                        finish();
                    }

                });
                auth.signInWithEmailAndPassword(txt_email, txt_password).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Loginactivity.this, "Login Failed! Try again", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        forgetpassword=findViewById(R.id.fogotPassword);
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Loginactivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                }
                else {
                    auth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Loginactivity.this, "Recovery Email Send", Toast.LENGTH_LONG).show();
                                    }

                                    else {
                                        Toast.makeText(Loginactivity.this, "Failed to Send Email", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }

            }
        });
    }

    public void openBmi() {
        Intent intent = new Intent(this, Mainpage.class);
        startActivity(intent);
        finish();
    }

    public void openregister() {
        Intent intent = new Intent(this, Registeractivity.class);
        startActivity(intent);
        finish();
    }
}