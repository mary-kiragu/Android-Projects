package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView socialMedia= findViewById(R.id.socialmedia);

        String [] values=new String[] {"Facebook","Whatsapp","Telegram","YouTube"};
        //create adapter

        ArrayAdapter<String> adapter= new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
        socialMedia.setAdapter(adapter);



        socialMedia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),adapter.getItem(i),Toast.LENGTH_SHORT).show();
                if (i==0){

                    Intent intent=new Intent(getApplicationContext(),FaceBook.class);
                    startActivity(intent);

                }
                else if (i==1){

                    Intent intent = new Intent(getApplicationContext(),whatsApp.class);
                    startActivity(intent);

                }
            }
        });
    }
}