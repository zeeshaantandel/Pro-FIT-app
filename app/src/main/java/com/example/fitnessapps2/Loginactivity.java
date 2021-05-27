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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Loginactivity extends AppCompatActivity {
    public TextView signUp;
    private Button buttonLogin;
    private EditText inputEmail;
    private EditText password;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        signUp = findViewById(R.id.signUp);
        buttonLogin = findViewById(R.id.buttonLogin);
        inputEmail = findViewById(R.id.inputEmail);
        password = findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBmi();
            }
        });
        /*buttonLogin.setOnClickListener(new View.OnClickListener() {
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
                        Toast.makeText(Loginactivity.this, "Loginsucessfull", Toast.LENGTH_SHORT).show();
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
        });*/
         /*FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
           if (user != null) {
            // User is signed in
            Intent i = new Intent(Loginactivity.this, );
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
           } else {
          // User is signed out
          Log.d(TAG, "onAuthStateChanged:signed_out");
          }*/
    }

    public void openRegister() {
        Intent intent = new Intent(this, Registeractivity.class);
        startActivity(intent);
    }

    public void openBmi() {
        Intent intent = new Intent(this, userDetailsActivity.class);
        startActivity(intent);
        finish();
    }
}


