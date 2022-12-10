package com.example.ebridge;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ebridge.Model.Event;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddEventActivity extends CommonAuth {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private Button addSButton;
    private TextView eventNameET, eventDescriptionET, eventVenueET, eventDateET;
    DataSnapshot eventsData;
    boolean datFound = false;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_event);
        addSButton = findViewById(R.id.eventButton);
        db = FirebaseDatabase.getInstance().getReference().child("E-Bridge");
        db.child("events").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                eventsData = dataSnapshot;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        eventNameET = findViewById(R.id.eventName);
        eventDescriptionET = findViewById(R.id.eventDescription);
        eventVenueET = findViewById(R.id.eventVenue);
        eventDateET = findViewById(R.id.eventDate);

        drawerLayout = findViewById(R.id.id_main_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navBars(AddEventActivity.this);

        addSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSubject();
            }
        });
    }

    public void addSubject() {
        boolean err = false;
        String sEventName = eventNameET.getText().toString().trim();
        String sEventDescription = eventDescriptionET.getText().toString().trim();
        String sEventVenue = eventVenueET.getText().toString().trim();
        String sEventDate = eventDateET.getText().toString().trim();
        if (sEventName.isEmpty()) {
            eventNameET.setError("Event Name cannot be empty.");
            err = true;
        } else if (sEventDescription.isEmpty()) {
            eventDescriptionET.setError("Event Description cannot be empty.");
            err = true;
        } else if (sEventVenue.isEmpty()) {
            eventVenueET.setError("Event Venue cannot be empty.");
            err = true;
        } else if (sEventDate.isEmpty()) {
            eventDateET.setError("Event Date cannot be empty.");
            err = true;
        }

        if (!err) {
            Event event = new Event(sEventName, sEventDescription, sEventVenue, sEventDate);
            db.child("events").child(sEventName).setValue(event);
            Toast.makeText(AddEventActivity.this, "Event Added Successfully.", Toast.LENGTH_LONG).show();

            startActivity(new Intent(AddEventActivity.this, AdminEventsActivity.class));

        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override

    public void onStart() {

        super.onStart();

    }

}