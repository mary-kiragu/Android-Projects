package com.example.smsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSION_REQUEST_SEND_SMS =0 ;
    EditText message, phoneNumber;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message= findViewById(R.id.message);
        phoneNumber= findViewById(R.id.phoneNumber);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    protected void sendSMSMessage(){
        if(ContextCompat.checkSelfPermission(this , Manifest.permission.SEND_RESPOND_VIA_MESSAGE)!=PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)){

        }
        }
            else{ ActivityCompat.requestPermissions(this, new String []{Manifest.permission.SEND_SMS}, MY_PERMISSION_REQUEST_SEND_SMS);
                 }


    }

    //@Override

    protected void onRequestPermissionResult(int requestCode, String permissions[] , int [] grantResults ){

    switch(requestCode){

        case MY_PERMISSION_REQUEST_SEND_SMS:{
            if (grantResults.length >0 &&
        grantResults[0] == PackageManager.PERMISSION_GRANTED){
            SmsManager smsManager= SmsManager.getDefault();
            Toast.makeText(getApplicationContext(), "SMS sent",Toast.LENGTH_SHORT).show();
        }
            else {
                Toast.makeText(getApplicationContext(), "Sms failed",Toast.LENGTH_LONG).show();
                return;
            }
    }

    }

    }
}


