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

import com.example.ebridge.Model.Alert;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddAlertActivity extends CommonAuth {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private Button addSButton;
    private TextView alertNameET,alertDescriptionET;
    DataSnapshot alertsData;
    boolean datFound = false;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_alert);
        addSButton = findViewById(R.id.alertButton);
        db = FirebaseDatabase.getInstance().getReference().child("E-Bridge");
        db.child("alerts").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                alertsData = dataSnapshot;
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        alertNameET = findViewById(R.id.alertName);
        alertDescriptionET = findViewById(R.id.alertDescription);

        drawerLayout = findViewById(R.id.id_main_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navBars(AddAlertActivity.this);

        addSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAlert();
            }
        });
    }

    public void addAlert(){
        boolean err=false;
        String sAlertName = alertNameET.getText().toString().trim();
        String sAlertDescription = alertDescriptionET.getText().toString().trim();
        if(sAlertName.isEmpty())
        {
            alertNameET.setError("Alert Name cannot be empty.");
            err=true;
        }
        else if(sAlertDescription.isEmpty())
        {
            alertDescriptionET.setError("Alert Description cannot be empty.");
            err=true;
        }

        if(!err){
            Alert alert = new Alert(sAlertName,sAlertDescription);
                db.child("alerts").child(sAlertName).setValue(alert);
                Toast.makeText(AddAlertActivity.this, "Alert Added Successfully.", Toast.LENGTH_LONG).show();

                startActivity(new Intent(AddAlertActivity.this, AdminAlertsActivity.class));


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