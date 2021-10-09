package com.example.fitnessapps2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity {
    ImageView zeeshaan_call,omkar_call,aditya_call,pratham_call;
    Button sendEmail;
    String emailid="profit_community@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        zeeshaan_call=findViewById(R.id.zeeshaan_call);
        omkar_call=findViewById(R.id.omkar_call);
        aditya_call=findViewById(R.id.aditya_call);
        pratham_call=findViewById(R.id.pratham_call);
        sendEmail=findViewById(R.id.sendEmail);

        zeeshaan_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callzeeshaan(view);
            }
        });

        omkar_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callomkar(view);
            }
        });

        aditya_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calladitya(view);
            }
        });

        pratham_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callpratham(view);
            }
        });

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendemail(view);
            }
        });
    }

    private void callzeeshaan(View v){
        Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Uri.encode("9359176287")));
        startActivity(intent);
    }

    private void callomkar(View v){
        Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Uri.encode("8446180437")));
        startActivity(intent);
    }

    private void calladitya(View v){
        Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Uri.encode("7620236554")));
        startActivity(intent);
    }

    private void callpratham(View v){
        Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Uri.encode("7066756101")));
        startActivity(intent);
    }

    private void sendemail(View v){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailid});
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"choose mail app"));
    }
}