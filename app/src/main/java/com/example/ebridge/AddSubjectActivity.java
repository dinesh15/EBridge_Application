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

import com.example.ebridge.Model.Subject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddSubjectActivity extends CommonAuth {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private Button addSButton;
    private TextView subjectName,subjectCode;
    DataSnapshot subjectsData;
    boolean datFound = false;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_subject);
        addSButton = findViewById(R.id.addSubjectButton);
        db = FirebaseDatabase.getInstance().getReference().child("E-Bridge");
        db.child("subjects").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                subjectsData = dataSnapshot;
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        subjectName = findViewById(R.id.addSubjectField);

        subjectCode = findViewById(R.id.subjectCodeField);

        drawerLayout = findViewById(R.id.id_main_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navBars(AddSubjectActivity.this);
        addSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSubject();
            }
        });
    }

    public void addSubject(){
        boolean err=false;
        String sName = subjectName.getText().toString().trim();
        String sCode = subjectCode.getText().toString().trim();
        if(sName.isEmpty())
        {
            subjectName.setError("Subject Name cannot be empty.");
            err=true;
        }
        else if(sCode.isEmpty())
        {
            subjectCode.setError("Subject Code cannot be empty.");
            err=true;
        }

        if(!err){
            datFound = false;
            for (DataSnapshot data : subjectsData.getChildren()) {
                if(data.getKey().equals(sCode)){
                    datFound = true;
                    break;
                }
            }

            if(datFound== false){
                Subject sub = new Subject(sName,sCode);
                db.child("subjects").child(sCode).setValue(sub);
                Toast.makeText(AddSubjectActivity.this, "Subject Added Successfully.", Toast.LENGTH_LONG).show();

                startActivity(new Intent(AddSubjectActivity.this, AdminSubjectsActivity.class));

            }
            else{
                Toast.makeText(AddSubjectActivity.this, "Subject Code Already Exists.", Toast.LENGTH_LONG).show();
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