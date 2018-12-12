package com.example.sungwoonam.mp6_attempt_to_fix;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.HashMap;
import java.util.Map;

public class NewScreen extends AppCompatActivity {
    private static final String TAG = "NewScreen";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        ImageButton backtoStart = (ImageButton) findViewById(R.id.returnBack);
        Button createPoll = (Button) findViewById(R.id.createfinishedPoll);
        final EditText editText1 = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final EditText editText3 = (EditText) findViewById(R.id.editText3);
        final EditText editText4 = (EditText) findViewById(R.id.editText4);
        final ImageView qrView = (ImageView) findViewById(R.id.qrView);

        backtoStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewScreen.this, MainActivity.class);
                startActivity(intent);
            }

        });
        createPoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast finishedToast = Toast.makeText(getApplicationContext(), "Poll Created!", Toast.LENGTH_LONG);
                finishedToast.show();
                String title = editText1.getText().toString();
                String option1 = editText2.getText().toString();
                String option2 = editText3.getText().toString();
                String option3 = editText4.getText().toString();

                Gson qrGSON = new Gson();
                Map<String, Object> json = new HashMap<>();
                json.put("title", title);
                json.put("option1", option1);
                json.put("option2", option2);
                json.put("option3", option3);
                String jString = qrGSON.toJsonTree(json).toString();



                if (title != null && option1 != null) {
                    MultiFormatWriter multiFormat = new MultiFormatWriter();

                    try {
                        BitMatrix bitMatrix = multiFormat.encode(jString, BarcodeFormat.QR_CODE, 500, 500);
                        BarcodeEncoder barcode = new BarcodeEncoder();
                        Bitmap bitmap = barcode.createBitmap(bitMatrix);
                        qrView.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}