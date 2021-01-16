package com.example.test2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    private Button button4;
    private Button button2;
    private Button button3;
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button3 = (Button) findViewById(R.id.medtrack);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensecondactivity();
            }
        });
        button2 = (Button) findViewById(R.id.subattendance);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensecondactivity2();
            }
        });
        button4 = (Button) findViewById(R.id.profile);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensecondactivity3();
            }
        });
        button1 = (Button) findViewById(R.id.overallattendance);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensecondactivity4();
            }
        });


    }
    public void opensecondactivity() {

        Intent intent = new Intent(this, TrackMedical.class);
        startActivity(intent);


    }

    public void opensecondactivity2() {

        Intent intent = new Intent(this, subjectattendance.class);
        startActivity(intent);


    }
    public void opensecondactivity3() {

        Intent intent = new Intent(this, profile.class);
        startActivity(intent);


    }
    public void opensecondactivity4() {

        Intent intent = new Intent(this, overall.class);
        startActivity(intent);


    }
    }
