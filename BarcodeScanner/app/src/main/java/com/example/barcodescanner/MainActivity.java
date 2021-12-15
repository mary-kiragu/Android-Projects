package com.example.barcodescanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    TextView message;
    Button scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message=findViewById(R.id.message);
        scan=findViewById(R.id.scan);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intergrator= new IntentIntegrator(MainActivity.this);
                intergrator.setPrompt("Scan barcode or QR code");
                intergrator.setOrientationLocked(true);
                intergrator.initiateScan();
            }
        });

    }

    public void onActivityResult(int requestCode, int responseCode, Intent data){
        super.onActivityResult(requestCode, responseCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, responseCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(getBaseContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            } else {
                // if the intentResult is not null we'll set
                // the content and format of scan message
             message.setText(intentResult.getContents());
//                Toast.makeText(this,intentResult.getContents(), Toast.LENGTH_LONG).show();
//                System.out.println(intentResult.getFormatName());

            }
        } else {
            super.onActivityResult(requestCode, responseCode, data);
        }


    }
}