package com.example.minorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class thursday extends AppCompatActivity {

    Button addbtn, refresh;
    DBhelper db;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thursday);

        addbtn = findViewById(R.id.addbtn);
        refresh = findViewById(R.id.refresh);
        txt = findViewById(R.id.txt);
        db = new DBhelper(this);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = db.TuesdayView();
                StringBuilder sb = new StringBuilder();
                while(cursor.moveToNext()){
                    sb.append("\n Lecture : " + cursor.getString(0) + "\n Class   : " + cursor.getString(1) + "\n Subject : " + cursor.getString(2)
                            + "\n Time    : " + cursor.getString(3) + "\n Room    : " + cursor.getString(4) + "\n\n");
                }
                txt.setText(sb);
            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), thurs_add.class);
                startActivity(intent);
            }
        });
    }
}