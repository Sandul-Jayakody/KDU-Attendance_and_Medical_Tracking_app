package com.example.test2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class subattendance2 extends AppCompatActivity {
    Button performanceBtn;
    FirebaseFirestore db;
    TextView textDisplay1,textDisplay2,textDisplay3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subattendance2);

        db = FirebaseFirestore.getInstance();
        textDisplay1 = findViewById(R.id.cadetname);
        textDisplay2 = findViewById(R.id.servicenumber);
        textDisplay3 =(TextView) findViewById(R.id.troop);


        ReadSingleContact();
    }
    private void ReadSingleContact() {
        String s = getIntent().getStringExtra("profile");
        textDisplay2.setText(getIntent().getStringExtra("profile"));
        DocumentReference user = db.collection("profile").document(s);
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder field1 = new StringBuilder("");
                    StringBuilder field2 = new StringBuilder("");
                    StringBuilder field3 = new StringBuilder("");
                    field1.append(doc.get("name"));
                    field2.append(doc.get("email"));

                    textDisplay1.setText(field1.toString());
                    textDisplay3.setText(field2.toString());

                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    Intent intent=new Intent(subattendance2.this,subattendance2.class);
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }

}