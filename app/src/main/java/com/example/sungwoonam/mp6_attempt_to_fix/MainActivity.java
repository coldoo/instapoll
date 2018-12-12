package com.example.sungwoonam.mp6_attempt_to_fix;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d(TAG, "onCreate: Starting.");

        Button switchActivity = (Button) findViewById(R.id.movetoNew);

        final Button scanQRCode = (Button) findViewById(R.id.scanPoll);
        final Activity activityForQR = this;
        switchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewScreen.class);
                startActivity(intent);
            }
        });
        scanQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator scanIntegrator = new IntentIntegrator(activityForQR);
                scanIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                scanIntegrator.setCameraId(0);
                scanIntegrator.setBarcodeImageEnabled(false);
                scanIntegrator.setBeepEnabled(false);
                scanIntegrator.setOrientationLocked(true);
                scanIntegrator.setBeepEnabled(false);
                scanIntegrator.initiateScan();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Scanning Cancelled", Toast.LENGTH_LONG).show();

            }
            else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();


            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
