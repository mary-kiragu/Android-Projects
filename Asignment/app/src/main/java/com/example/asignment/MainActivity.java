package com.example.asignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText, passwordEditText;
    Button signup, login;
    String username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText=findViewById(R.id.username);
        passwordEditText=findViewById(R.id.password);
        signup=findViewById(R.id.signup);
        login= findViewById(R.id.login);

        DatabaseHelper helper=new DatabaseHelper(this);
//
//
//
        signup.setOnClickListener(view -> {
            username= usernameEditText.getText().toString();
            password= passwordEditText.getText().toString();
            System.out.println(username);
            System.out.println(password);
               Boolean checkinsertdata=helper.insertuserdata(username,password);
                if(checkinsertdata==true) {
                    Toast.makeText(MainActivity.this, "you can now login", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, " Signup error", Toast.LENGTH_SHORT).show();
                }
        });
//
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username= usernameEditText.getText().toString();
                password= passwordEditText.getText().toString();

                Cursor res = helper.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                while (res.moveToNext()) {
                    String dbUsername = res.getString(0);
                    String dbPassword  = res.getString(1);

                    if(dbUsername==username && dbPassword==password){
                        Toast.makeText(MainActivity.this, "Yeeeeiiii proceed", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(getApplicationContext(),Tabs.class);

                        break;
                    }

                }
//                if(credentialsFound==false){
//                    Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
//                }


            }


        });









}

//    Boolean credentialsFound (){
//
//
//    }



}