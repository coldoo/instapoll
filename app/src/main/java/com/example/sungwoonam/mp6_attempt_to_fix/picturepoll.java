package com.example.sungwoonam.mp6_attempt_to_fix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class picturepoll extends AppCompatActivity {

    Button penBtn;
    Button pencilBtn;
    TextView penText;
    TextView pencilText;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_poll);

        final TextView penText = findViewById(R.id.textview_pen_count);
        final TextView pencilText = findViewById(R.id.textview_pencil_count);
        final Button penBtn = findViewById(R.id.button_pen);
        final Button pencilBtn = findViewById(R.id.button_pencil);

        penBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String penCount = penText.getText().toString();
                int count = Integer.parseInt(penCount);
                count++;
                penText.setText(String.valueOf(count));
                penBtn.setEnabled(false);
                pencilBtn.setEnabled(false);
                Intent intent = new Intent(picturepoll.this, MainActivity.class);
                startActivity(intent);
                Toast finishedToast = Toast.makeText(getApplicationContext(), "Thanks! Your vote has been recorded" , Toast.LENGTH_LONG);
                finishedToast.show();
            }
        });

        pencilBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String pencilCount = pencilText.getText().toString();
                int count = Integer.parseInt(pencilCount);
                count++;
                pencilText.setText(String.valueOf(count));
                penBtn.setEnabled(false);
                pencilBtn.setEnabled(false);
                Intent intent = new Intent(picturepoll.this, MainActivity.class);
                startActivity(intent);
                Toast finishedToast = Toast.makeText(getApplicationContext(), "Thanks! Your vote has been recorded" , Toast.LENGTH_LONG);
                finishedToast.show();
            }
        });

    }


}