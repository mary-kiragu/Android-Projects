package com.example.firebase334;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity {
    TextView firstname,lastname,phone2,email1;
    Button view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        email1=findViewById(R.id.email);
        phone2=findViewById(R.id.phone2);
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        view1=findViewById(R.id.view);


        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef;

                myRef= database.getInstance().getReference().child("Member").child("member1");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override

                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String firstName=snapshot.child("firstName").getValue().toString();
                        String lastName=snapshot.child("lastName").getValue().toString();
                        String email=snapshot.child("mail").getValue().toString();
                        String phone=snapshot.child("phone").getValue().toString();
                        firstname.setText(firstName);
                        lastname.setText(lastName);
                        email1.setText(email);
                        phone2.setText(phone);



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}
