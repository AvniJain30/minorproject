package com.example.minorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fullName,email,password,phone;
    Button registerBtn;
    TextView loginBtn;
    ProgressBar progressBar;
    DBhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullName=findViewById(R.id.fullname);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        phone=findViewById(R.id.phone);
        registerBtn=findViewById(R.id.registerBtn);
        loginBtn=findViewById(R.id.createtext);
        progressBar=findViewById(R.id.progressBar);
        db = new DBhelper(this);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FullName = fullName.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String Phone = phone.getText().toString();

                if(FullName.equals("") || Email.equals("") || Password.equals("") || Phone.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(!Email.endsWith("lnct.ac.in")){
                        Toast.makeText(MainActivity.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    boolean checkuser = db.checkemail(Email);
                    if(checkuser == false){
                        try {
                            boolean insert = db.insertDataInUser(FullName, Email, Password, Phone);
                            if(insert == true){
                                Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Registration failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        catch (Exception e){
                            Toast.makeText(MainActivity.this, "Error occurred"+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(MainActivity.this, "user already exists! please sign in", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        });
    }
}