package com.example.ebridge;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ebridge.Model.Subject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RemoveAssignSubjectActivity extends CommonAuth {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private Spinner spinnerSubject,spinnerFaculty;
    public DataSnapshot subjectsData,usersData;

    ArrayList<String> subjectCodeS= new ArrayList<>();
    ArrayList<String> facultyS= new ArrayList<>();
    private Button removeAssignSubjectButton;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_remove_assign_subject);

        drawerLayout = findViewById(R.id.id_main_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navBars(RemoveAssignSubjectActivity.this);
        removeAssignSubjectButton = findViewById(R.id.removeAssignSubjectButton);
        db = FirebaseDatabase.getInstance().getReference().child("E-Bridge");
        db.child("subjects").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                subjectsData = dataSnapshot;

                for (DataSnapshot data : subjectsData.getChildren()) {
                    subjectCodeS.add(data.child("subjectCode").getValue().toString());
                }


                spinnerSubject = (Spinner)findViewById(R.id.subjectSpinner);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(RemoveAssignSubjectActivity.this,
                        android.R.layout.simple_spinner_item,subjectCodeS);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerSubject.setAdapter(adapter);
              //  spinnerSubject.setOnItemSelectedListener(this);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        db = FirebaseDatabase.getInstance().getReference().child("E-Bridge");
        db.child("users").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usersData = dataSnapshot;
                for (DataSnapshot data : usersData.getChildren()) {

                    if(data.child("role").getValue().toString().equals("2")){
                        facultyS.add(data.child("username").getValue().toString());
                    }
                }

                spinnerFaculty = (Spinner)findViewById(R.id.facultySpinner);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(RemoveAssignSubjectActivity.this,
                        android.R.layout.simple_spinner_item,facultyS);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerFaculty.setAdapter(adapter);
                //  spinnerSubject.setOnItemSelectedListener(this);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        removeAssignSubjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAssignSubjectButtonAction();
            }
        });
    }

    public void removeAssignSubjectButtonAction(){
        String subjectCodeS = spinnerSubject.getSelectedItem().toString();
        String facultyCodeS = spinnerFaculty.getSelectedItem().toString();


        for (DataSnapshot data : usersData.getChildren()) {
            if (data.getKey().equals(facultyCodeS)) {
                if (data.child("subjects").hasChild(subjectCodeS)) {
                    db.child("users").child(facultyCodeS).child("subjects").child(subjectCodeS).setValue(null);
                    Toast.makeText(RemoveAssignSubjectActivity.this, "Subject unassigned Successfully.", Toast.LENGTH_SHORT).show();
                    break;
                }
                else{
                    Toast.makeText(RemoveAssignSubjectActivity.this, "Subject is not assigned to Faculty.", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
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