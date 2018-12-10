package com.example.sungwoonam.mp6_attempt_to_fix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class CreatedPoll extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.created_poll);

        Button returnToStart = (Button) findViewById(R.id.button_return);
        returnToStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreatedPoll.this, NewScreen.class);
                startActivity(intent);
            }
        });
    }
}

