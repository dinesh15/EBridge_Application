package com.example.ebridge;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebridge.Model.Job;
import com.example.ebridge.Model.Subject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;

public class AdminSubjectsActivity extends CommonAuth {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public ListView subjectsListView;
    public DataSnapshot subjectsData;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin_subjects);
        subjectsListView = findViewById(R.id.eventsListView);

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

        drawerLayout = findViewById(R.id.id_main_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navBars(AdminSubjectsActivity.this);
        db = FirebaseDatabase.getInstance().getReference().child("E-Bridge");
        db.child("subjects").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Subject> subjects = new LinkedList<>();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    subjects.add(new Subject(data.child("name").getValue().toString(), data.child("subjectCode").getValue().toString()));
                }

                RecyclerView recyclerView = findViewById(R.id.subjectsListView);
                recyclerView.setLayoutManager(new LinearLayoutManager(AdminSubjectsActivity.this));
                SubjectAdaptor adaptor = new SubjectAdaptor(subjects);
                recyclerView.setAdapter(adaptor);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
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