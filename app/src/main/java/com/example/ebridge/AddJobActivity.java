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

import com.example.ebridge.Model.Job;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddJobActivity extends CommonAuth {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private Button addjobBT;
    private TextView positionET,experienceRequiredET,departmentET,positionAvailableET;
    DataSnapshot jobsData;
    boolean datFound = false;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_job);
        addjobBT = findViewById(R.id.addjob);
        db = FirebaseDatabase.getInstance().getReference().child("E-Bridge");
        db.child("jobs").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                jobsData = dataSnapshot;
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        positionET = findViewById(R.id.position);
        experienceRequiredET = findViewById(R.id.experienceRequired);
        departmentET = findViewById(R.id.department);
        positionAvailableET = findViewById(R.id.positionAvailable);

        drawerLayout = findViewById(R.id.id_main_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navBars(AddJobActivity.this);
        // new comment 
        addjobBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addJob();
            }
        });
    }

    public void addJob(){
        boolean err=false;
        String sposition = positionET.getText().toString().trim();
        String sexperienceRequired = experienceRequiredET.getText().toString().trim();
        String sdepartment = departmentET.getText().toString().trim();
        String spositionAvailable = positionAvailableET.getText().toString().trim();
        if(sposition.isEmpty())
        {
            positionET.setError("Position Name cannot be empty.");
            err=true;
        }
        else if(sexperienceRequired.isEmpty())
        {
            experienceRequiredET.setError("Experience Required cannot be empty.");
            err=true;
        }
        else if(sdepartment.isEmpty())
        {
            departmentET.setError("Department cannot be empty.");
            err=true;
        }
        else if(spositionAvailable.isEmpty())
        {
            positionAvailableET.setError("Position Available cannot be empty.");
            err=true;
        }

        if(!err){
            Job job = new Job(sposition,sexperienceRequired,sdepartment,spositionAvailable);
                db.child("jobs").child(sposition).setValue(job);
                Toast.makeText(AddJobActivity.this, "Job Added Successfully.", Toast.LENGTH_LONG).show();

                startActivity(new Intent(AddJobActivity.this, AdminJobsActivity.class));

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