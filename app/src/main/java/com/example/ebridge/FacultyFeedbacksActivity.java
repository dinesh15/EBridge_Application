package com.example.ebridge;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebridge.Model.Feedback;
import com.example.ebridge.Model.Subject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;

public class FacultyFeedbacksActivity extends CommonAuth {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
//    private Button btnLogout;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_faculty_feedbacks);

        drawerLayout = findViewById(R.id.id_main_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navBars(FacultyFeedbacksActivity.this);

        db = FirebaseDatabase.getInstance().getReference().child("E-Bridge");
        db.child("feedbacks").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Feedback> feedbacks = new LinkedList<>();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    feedbacks.add(new Feedback(data.child("message").getValue().toString(), data.child("feedbackTitle").getValue().toString()));


                }

                RecyclerView recyclerView = findViewById(R.id.feedbacksListView);
                recyclerView.setLayoutManager(new LinearLayoutManager(FacultyFeedbacksActivity.this));

                FeedbackAdaptor adaptor = new FeedbackAdaptor(feedbacks);
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