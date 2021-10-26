package com.example.cameraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final  int CAMERA_REQUEST = 123;
    ImageView camera;
    Button capture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       capture =findViewById(R.id.capture);
        camera=findViewById(R.id.camera);

    }
    public void buttonClick(View view){
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);


    }


    public void onActivityForResult(int requestCode, int resultCode, Intent data){
        if (requestCode ==CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {

            Bitmap photo=(Bitmap)  data.getExtras().get("data");
            camera.setImageBitmap(photo);
        }

        }
    }
