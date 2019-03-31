package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class LoginActivity extends Activity {
    Button b1, b2;
    EditText ed1, ed2;

    TextView tx1;
    int counter = 3;
    private DatabaseReference mDatabase;
//    mDatabase = FirebaseDatabase.getInstance().getReference();

    DatabaseReference myRef;
    ArrayList<String> userlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseApp.initializeApp(this);

        myRef = FirebaseDatabase.getInstance().getReference("events");

        b1 = findViewById(R.id.button);
        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);

        b2 = findViewById(R.id.push);
        tx1 = findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (ed1.getText().toString().equals("123") &&
//                        ed2.getText().toString().equals("123")) {
                Toast.makeText(getApplicationContext(),
                        "Redirecting...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), EventsActivity.class));
//                } else {
//                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
//
//                    tx1.setVisibility(View.VISIBLE);
//                    tx1.setBackgroundColor(Color.RED);
//                    counter--;
//                    tx1.setText(Integer.toString(counter));
//
//                    if (counter == 0) {
//                        b1.setEnabled(false);
//                    }
//                }
            }
        });

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userlist = new ArrayList<String>();
                // Result will be holded Here
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    userlist.add(String.valueOf(dsp.getValue())); //add result into array list
                }
//                Toast.makeText(LoginActivity.this, "updated", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_SHORT).show();
            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                myRef.push().getKey();
//                String x = myRef.child("events").toString();

                Toast.makeText(LoginActivity.this, userlist.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void pushToDb(String data) {
        // read the largest key and
        // key++
        myRef.child("2").setValue("Yasir");
    }

}