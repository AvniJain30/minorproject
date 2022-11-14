package com.example.minorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class mon_add extends AppCompatActivity {

    DBhelper db;
    EditText Lecture, Class, Subject, Time, Room;
    Button add, clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        db = new DBhelper(this);
        Lecture = findViewById(R.id.lecture);
        Class = findViewById(R.id.Class);
        Subject = findViewById(R.id.subject);
        Time = findViewById(R.id.time);
        Room = findViewById(R.id.room);
        add = findViewById(R.id.add);
        clear = findViewById(R.id.clear);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_lecture = Lecture.getText().toString();
                String add_class = Class.getText().toString();
                String add_subject = Subject.getText().toString();
                String add_time = Time.getText().toString();
                String add_room = Room.getText().toString();

                if(add_lecture.equals("") || add_class.equals("") || add_subject.equals("") || add_time.equals("") || add_room.equals("")){
                    Toast.makeText(mon_add.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean check = db.insertDataInMonday(add_lecture, add_class, add_subject, add_time, add_room);
                    if(check == true){
                        Toast.makeText(mon_add.this, "added Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(mon_add.this, "failure!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lecture.setText("");
                Class.setText("");
                Subject.setText("");
                Time.setText("");
                Room.setText("");
            }
        });
    }
}