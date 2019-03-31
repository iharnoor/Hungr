package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShareActivity extends AppCompatActivity {

    ArrayList<String> userlist;
    private DatabaseReference myRef;
    private EditText etEventName;
    private EditText etEventLocation;
    private EditText etEventTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        etEventName = findViewById(R.id.etEventName);
        etEventLocation = findViewById(R.id.etEventLocation);
        etEventTime = findViewById(R.id.etComeBy);

        FirebaseApp.initializeApp(this);

        myRef = FirebaseDatabase.getInstance().getReference("events");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userlist = new ArrayList<String>();
                // Result will be holded Here
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    userlist.add(String.valueOf(dsp.getKey())); //add result into array list
                }
                Toast.makeText(getApplicationContext(), "updated: " + userlist.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnShare = findViewById(R.id.btnPublish);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushToDb(etEventName.getText().toString(), etEventLocation.getText().toString(), etEventTime.getText().toString());
            }
        });
    }

    public void pushToDb(String a, String b, String c) {
        // read the largest key and
        // key++
        int key = Integer.parseInt(userlist.get(userlist.size() - 1));

        ++key;
        myRef.child(key + "").child("eventName").setValue(a);
        myRef.child(key + "").child("eventLocation").setValue(b);
        myRef.child(key + "").child("eventTime").setValue(c);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cart:
                Intent homeIntent = new Intent(this, LoginActivity.class);
                startActivity(homeIntent);
                break;
        }
        return true;
    }

}
