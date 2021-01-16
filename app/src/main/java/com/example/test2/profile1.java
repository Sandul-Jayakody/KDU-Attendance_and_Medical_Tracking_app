package com.example.test2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class profile1 extends AppCompatActivity {

    FirebaseFirestore db;

    EditText serviceNum;
    Button serviceBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);
        ServiceButton();
    }
    public void ServiceButton(){
        serviceBtn = (Button) findViewById(R.id.serviceButton);
        serviceNum = (EditText) findViewById(R.id.serviceNumber);


        serviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String snum= serviceNum.getText().toString();
                Intent intent=new Intent(profile1.this,subattendance2.class);
                intent.putExtra("email",snum);
                startActivity(intent);
            }
        });
    }
}