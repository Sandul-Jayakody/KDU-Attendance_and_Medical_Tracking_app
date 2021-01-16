package com.example.test2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class subjectattendance extends AppCompatActivity {
TextView a,b,c,d,e,f;
FirebaseAuth fauth;
FirebaseFirestore fstore;
String subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjectattendance);
        a=findViewById(R.id.sub1);
        b=findViewById(R.id.sub2);
        c=findViewById(R.id.sub3);
        d=findViewById(R.id.sub4);
        e=findViewById(R.id.sub5);
        f=findViewById(R.id.sub6);

fauth=FirebaseAuth.getInstance();
fstore=FirebaseFirestore.getInstance();
subject=fauth.getCurrentUser().getUid();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String  currentuid= user.getUid();
        DocumentReference documentReference=fstore.collection("subid").document(currentuid);
documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
    @Override
    public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
        a.setText(value.getString("sub1"));
        b.setText(value.getString("sub2"));
        c.setText(value.getString("sub3"));
        d.setText(value.getString("sub4"));
        e.setText(value.getString("sub5"));
        f.setText(value.getString("sub6"));

    }
});
    }
}
