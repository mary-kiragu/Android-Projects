package com.example.immasdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
   EditText nameEditText, regNumber, age, phoneNumber,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);//waiting for what you want to do with the activity

        nameEditText =findViewById(R.id.name);//binding -helps  the set content view to find Edittext
        regNumber=findViewById(R.id.regNumber);
        age=findViewById(R.id.age);
        email=findViewById(R.id.email);
        phoneNumber=findViewById(R.id.phoneNumber);

        Button next = findViewById(R.id.next);



    //convert to int if getting from text view
      // obj.age= Integer.parseInt(editText.gettext();



        next.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                First student=new First();//object of class first.
                student.name=nameEditText.getText().toString();
                student.regNumber=regNumber.getText().toString();
                student.age= Integer.parseInt(age.getText().toString());
                student.phoneNumber=phoneNumber.getText().toString();
                student.email=email.getText().toString();

                Intent intent=new Intent(getApplicationContext(),NextActivity.class);//written on the oncreate method of activity you are jumping from.
                intent.putExtra("name",student.name);
                intent.putExtra("age",student.age);
                intent.putExtra("regNumber",student.regNumber);
                intent.putExtra("phoneNumber",student.phoneNumber);
                intent.putExtra("email",student.email);

                startActivity(intent);


            }
        });

        /*intent-means of starting a service,eg starting an activity,app. Are of two types,
 explicit-starts other apps in the OS.eg app that uses  camera service,audio service,video,maps etc.
 implicit-
 */

        //pass the reference of class you are jumping from and name of class you are jumping to.class
        //To pass data from one activity to the other,do it before startActivity().
        /*one can pass single data values.
        intent.putExtra(Key->which is astring,data value)
         */
//        intent.putExtra("Key1","mary");
//        intent.putExtra("key2",30);




        //Usage of collection of values through bundles.
//        Bundle bundle=new Bundle();
//        bundle.putStringExtra("key3","joan");
//        bundle.putIntExtra("Key4",30);
//        intent.getStringExtra(bundle);
        // An adapter class is used to and one can use as many data instances as possible.An intent is needed in all of them



    }
}