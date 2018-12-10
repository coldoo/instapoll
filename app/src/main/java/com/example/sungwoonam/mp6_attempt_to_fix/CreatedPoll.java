package com.example.sungwoonam.mp6_attempt_to_fix;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class CreatedPoll extends AppCompatActivity implements ZXingScannerView.ResultHandler {
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
}

