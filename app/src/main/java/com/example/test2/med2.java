package com.example.test2;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class med2 extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private EditText editTextPriority;
    private EditText editTextTags;
    private TextView textViewData;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("test");
    private String Dean;
    private String HOD;
    FirebaseAuth fauth;
    FirebaseFirestore fstore;
    String subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med2);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        editTextPriority = findViewById(R.id.edit_text_priority);
        editTextTags = findViewById(R.id.edit_text_tags);
        textViewData = findViewById(R.id.text_view_data);
      //  fauth= FirebaseAuth.getInstance();
      //  fstore=FirebaseFirestore.getInstance();
       // subject=fauth.getCurrentUser().getUid();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String  currentuid= user.getUid();
 /*   public void addNote(View v) {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        if (editTextPriority.length() == 0) {
            editTextPriority.setText("0");
        }
        int priority = Integer.parseInt(editTextPriority.getText().toString());
        String tagInput = editTextTags.getText().toString();
        String[] tagArray = tagInput.split("\\s*,\\s*");
        Map<String, String> tags = new HashMap<>();
        for (String tag : tagArray) {
            tags.put(tag, "");
        }
        Note note = new Note(title, description,HOD,Dean, priority, tags);
        notebookRef.document("14g7Y5YjuaRcmGAiikUi")
                .collection("Child Notes").add(note);
    }*/

        notebookRef.document(currentuid)
                .collection("Child Notes").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String data = "";
                       // String data2 = "";
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            Note note = documentSnapshot.toObject(Note.class);
                            note.setDocumentId(documentSnapshot.getId());
                            String documentId = note.getDean();
                            data += "\n\n"+"HOD: " + documentId;
                            //note.setDocumentId(documentSnapshot.getId());
                            String documentId2 = note.getHOD();
                            data +="\n\n"+ "Dean: " + documentId2;
                         /*   for (String tag : note.getTags().keySet()) {
                                data += "\n-" + tag;
                            }
                            data += "\n\n";*/
                        }
                        textViewData.setText(data);
                     //   textViewData.setText(data2);
                    }
                });
    }}