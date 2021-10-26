package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class FaceBook extends AppCompatActivity {
    ImageView faceBook;
    Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_book);

        faceBook= findViewById(R.id.faceBook);
        faceBook.setImageResource(R.drawable.images);

    }
}