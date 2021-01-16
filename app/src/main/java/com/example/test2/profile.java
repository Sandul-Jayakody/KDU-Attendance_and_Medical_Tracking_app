package com.example.test2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;


public class profile extends AppCompatActivity {
    TextView a, b, c, d, e, f;
    FirebaseAuth fauth;
    FirebaseFirestore fstore;
    String user1;
    FirebaseUser user;
Button logout;
Button resetpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensecondactivity();
            }
        });
        resetpassword=findViewById(R.id.resetpass);
        a = findViewById(R.id.name);
        b = findViewById(R.id.address);
        c = findViewById(R.id.profemail);
        d = findViewById(R.id.profintake);
        e = findViewById(R.id.proffaculty);
       // f = findViewById(R.id.sub6);

        fauth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        user1=fauth.getCurrentUser().getUid();
        user=fauth.getCurrentUser();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String currentuid = user.getUid();
        DocumentReference documentReference = fstore.collection("profile").document(currentuid);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                a.setText(value.getString("name"));
                b.setText(value.getString("address"));
                c.setText(value.getString("email"));
                d.setText(value.getString("intake"));
                e.setText(value.getString("faculty"));
               // f.setText(value.getString("sub6"));

            }
        });

        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetpassword=new EditText(v.getContext());
                final AlertDialog.Builder passwordResetDialog=new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset password");
                passwordResetDialog.setMessage("Enter New password >6 characters ");
               passwordResetDialog.setView(resetpassword);
                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                  // String newPassword =resetpassword.getText().toString();

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                       String newpassword = resetpassword.getText().toString();
                       user.updatePassword(newpassword).addOnSuccessListener(new OnSuccessListener<Void>() {
                           @Override
                           public void onSuccess(Void aVoid) {
                               Toast.makeText(profile.this,"Password reset Successfully",Toast.LENGTH_SHORT).show();
                           }
                       }).addOnFailureListener(new OnFailureListener() {
                           @Override
                           public void onFailure(@NonNull Exception e) {
                               Toast.makeText(profile.this,"Password Reset Failed",Toast.LENGTH_SHORT).show();
                           }
                       });


                    }
                });
                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {


                    public void onClick(DialogInterface dialog, int which) {}


                });
                passwordResetDialog.create().show();
            }
        });
    }
    public void opensecondactivity() {

        Intent intent = new Intent(this, login1.class);
        startActivity(intent);


    }

}