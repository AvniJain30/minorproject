package com.example.minorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText email,password;
    Button loginBtn;
    TextView createBtn;
    ProgressBar progressBar;
    DBhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.Email);
        password=findViewById(R.id.password);
        progressBar=findViewById(R.id.progressBar);
        loginBtn=findViewById(R.id.loginBtn);
        createBtn=findViewById(R.id.createtext);
        db = new DBhelper(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();

                if(Email.equals("") || Password.equals("")){
                    Toast.makeText(login.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean checkuser = db.checkemailPassword(Email, Password);
                    if(checkuser == true){
                        Toast.makeText(login.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}