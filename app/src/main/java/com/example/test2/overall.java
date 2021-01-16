package com.example.test2;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
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

public class overall extends AppCompatActivity {
    FirebaseAuth fauth;
    FirebaseFirestore fstore;
    private TextView txtProgress;

    private ProgressBar progressBar;
    private int pStatus = 0;
    private Handler handler = new Handler();
    String overall;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overall);

        //textView3=(TextView)findViewById(R.id.textView3) ;
        txtProgress = (TextView) findViewById(R.id.txtProgress);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        fauth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        overall=fauth.getCurrentUser().getUid();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String  currentuid= user.getUid();
        final DocumentReference documentReference=fstore.collection("subid").document(currentuid);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable final DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

            //   a=Integer.valueOf(value.getValue());
                //txtProgress.setText(money);

                txtProgress.setText( value.getLong("sub7").toString());
               // final int handicapV= Integer.parseInt(txtProgress.getText().toString());
             //   progressBar.setProgress(handicapV);
               // String y = String.valueOf(handicapV);
              //  txtProgress.setText(Integer.toString(handicapV));

            new Thread(new Runnable() {
                    @Override
                    public void run() {
                       // int handicapV= parseInt((String) value.get("sub1"));
                      //txtProgress.setText(Integer.toString(handicapV));
                        int money = value.getLong("sub7").intValue();
                        //progressBar.setProgress(money);
                            while (pStatus <=money) {

                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                   progressBar.setProgress(pStatus);


                              txtProgress.setText( pStatus+"%");
                                }
                            });
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            pStatus++;

                        }
                    }
                }).start();
      //  a=getInteger(txtProgress.getText().toString());
       // progressBar.setMax(a);
       // progressBar.setProgress(a);


    }
        });
}


}