package com.example.sungwoonam.mp6_attempt_to_fix;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class NewScreen extends AppCompatActivity {
    private static final String TAG = "NewScreen";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        ImageButton backtoStart = (ImageButton) findViewById(R.id.returnBack);
        Button createPoll = (Button) findViewById(R.id.createfinishedPoll);
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
                Toast finishedToast = Toast.makeText(getApplicationContext(), "THANKS BRO", Toast.LENGTH_LONG);
                finishedToast.show();
                Intent intent = new Intent(NewScreen.this, CreatedPoll.class);
                startActivity(intent);
            }
        });
    }
}
