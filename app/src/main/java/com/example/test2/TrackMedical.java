package com.example.test2;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class TrackMedical extends AppCompatActivity {
    TextView a,b,c,d,e,f;
    FirebaseAuth fauth;
    FirebaseFirestore fstore;
    String subject;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("test");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_medical);
        a=findViewById(R.id.ma);
        a.setMovementMethod(new ScrollingMovementMethod());
        b=findViewById(R.id.hod);
       // b.setMovementMethod(new ScrollingMovementMethod());
        c=findViewById(R.id.ar);
       // c.setMovementMethod(new ScrollingMovementMethod());
        d=findViewById(R.id.dean);
       // d.setMovementMethod(new ScrollingMovementMethod());

        fauth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        subject=fauth.getCurrentUser().getUid();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String  currentuid= user.getUid();
       //DocumentReference documentReference=fstore.collection("medical").document(currentuid);
    //    documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
        //    @Override
        //    public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
               // a.setText(value.getString("MA"));
               // b.setText(value.getString("HOD"));
               // c.setText(value.getString("AR"));
               // d.setText(value.getString("Dean"));
                notebookRef.document(currentuid)
                        .collection("Child Notes").get()
                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                String data = "";
                                 String data2 = "";
                                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                                    Note note = documentSnapshot.toObject(Note.class);
                                    note.setDocumentId(documentSnapshot.getId());

                                    String documentId = note.getDean();
                                    data += "\n" + documentId;
                                   // note.setDocumentId(documentSnapshot.getId());
                                    String documentId2 = note.getHOD();
                                    data2 +="\n" + documentId2;
                         /*   for (String tag : note.getTags().keySet()) {
                                data += "\n-" + tag;
                            }
                            data += "\n\n";*/
                                }


                                a.setText(data);
                                b.setText(data2);
                                //   textViewData.setText(data2);
                            }
                        });


            }
       /* });
        }*/
}
