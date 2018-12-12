package com.example.sungwoonam.mp6_attempt_to_fix;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class CreatedPoll extends AppCompatActivity {
    private ZXingScannerView scanner;
    private static int camFB = Camera.CameraInfo.CAMERA_FACING_BACK;
    private boolean accepted = true;


    protected void onClick(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scanner = new ZXingScannerView(this);
        setContentView(scanner);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    Button cbutton1;
    Button cbutton2;
    Button cbutton3;
    TextView class1;
    TextView class2;
    TextView class3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.created_poll);

        cbutton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String penCount = class1.getText().toString();
                int count = Integer.parseInt(penCount);
                count++;
                class1.setText(String.valueOf(count));
                cbutton1.setEnabled(false);
                cbutton2.setEnabled(false);
                cbutton3.setEnabled(false);
                Intent intent = new Intent(CreatedPoll.this, MainActivity.class);
                startActivity(intent);
                Toast finishedToast = Toast.makeText(getApplicationContext(), "Thanks! Your vote has been recorded" , Toast.LENGTH_LONG);
                finishedToast.show();
            }
        });

        cbutton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String penCount = class2.getText().toString();
                int count = Integer.parseInt(penCount);
                count++;
                class2.setText(String.valueOf(count));
                cbutton1.setEnabled(false);
                cbutton2.setEnabled(false);
                cbutton3.setEnabled(false);
                Intent intent = new Intent(CreatedPoll.this, MainActivity.class);
                startActivity(intent);
                Toast finishedToast = Toast.makeText(getApplicationContext(), "Thanks! Your vote has been recorded" , Toast.LENGTH_LONG);
                finishedToast.show();
            }
        });

        cbutton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String penCount = class3.getText().toString();
                int count = Integer.parseInt(penCount);
                count++;
                class3.setText(String.valueOf(count));
                cbutton1.setEnabled(false);
                cbutton2.setEnabled(false);
                cbutton3.setEnabled(false);
                Intent intent = new Intent(CreatedPoll.this, MainActivity.class);
                startActivity(intent);
                Toast finishedToast = Toast.makeText(getApplicationContext(), "Thanks! Your vote has been recorded" , Toast.LENGTH_LONG);
                finishedToast.show();
            }
        });

    }

}