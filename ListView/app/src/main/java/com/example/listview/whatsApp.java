package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class whatsApp extends AppCompatActivity {
    ImageView whatsApp;
    Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_app);
        whatsApp= findViewById(R.id.whatsApp);
        whatsApp.setImageResource(R.drawable.images);



    }
}