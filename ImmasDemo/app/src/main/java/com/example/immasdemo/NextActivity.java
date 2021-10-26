package com.example.immasdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        TextView name = findViewById(R.id.name);
        TextView regNumber = findViewById(R.id.regNumber);
        TextView age = findViewById(R.id.age);
        TextView email = findViewById(R.id.email);
        TextView phoneNumber = findViewById(R.id.phoneNumber);


        Intent intent=getIntent();
        name.setText( intent.getStringExtra("name"));
        age.setText(Integer.toString(intent.getIntExtra("age",0)));
        regNumber.setText(intent.getStringExtra("regNumber"));
        email.setText(intent.getStringExtra("email"));
        phoneNumber.setText(intent.getStringExtra("phoneNumber"));



        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);


            }
        });



    //recieving data from an activity.
       // Intent intent=getIntent();
       //textView.setText( intent.getStringExtra("key1"));
        //textView.setText(Integer.toStringintent.getIntExtra("key2",0));
        //display on text view
        //

//        Bundle bundle=new Bundle();
//        bundle.getString("key3");


    }
}