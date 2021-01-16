package com.example.test2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

public class profile2 extends AppCompatActivity {
    TextView a,b,c,d,e,f;
    FirebaseAuth fauth;
    FirebaseFirestore fstore;
    CollectionReference abc;
    String subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        //a=findViewById(R.id.name);
        b = findViewById(R.id.textDisplay);
      //  c = findViewById(R.id.password);


        fauth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        subject = fauth.getCurrentUser().getUid();
       abc=fstore.collection("subid");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String currentuid = user.getUid();
  Query notesQuery = abc.whereEqualTo("sub7", 90);
  notesQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
      @Override
      public void onComplete(@NonNull Task<QuerySnapshot> task) {

      }
  });

        //final Query capitalCities = .collection("subid").whereEqualTo("sub7", 90);
       // documentReference.addc
}}