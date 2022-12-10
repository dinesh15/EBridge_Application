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
import com.example.ebridge.Model.Post;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddPostActivity extends CommonAuth {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private Button addPostButton;
    private TextView postTitle,postDetails;
    DataSnapshot postsData;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_post);
        addPostButton = findViewById(R.id.addPostButton);
        db = FirebaseDatabase.getInstance().getReference().child("E-Bridge");
        db.child("jobs").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                postsData = dataSnapshot;
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        postTitle = findViewById(R.id.postTitle);
        postDetails = findViewById(R.id.postDetails);

        drawerLayout = findViewById(R.id.id_main_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navBars(AddPostActivity.this);
        addPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPost();
            }
        });
    }

    public void addPost(){
        boolean err=false;
        String postTitleS = postTitle.getText().toString().trim();
        String postDetailsS = postDetails.getText().toString().trim();
        if(postTitleS.isEmpty())
        {
            postTitle.setError("Post Title cannot be empty.");
            err=true;
        }
        else if(postDetailsS.isEmpty())
        {
            postDetails.setError("Post Details cannot be empty.");
            err=true;
        }


        if(!err){
            Post post = new Post(postTitleS,postDetailsS);
                db.child("posts").child(postTitleS).setValue(post);
                Toast.makeText(AddPostActivity.this, "Post Added Successfully.", Toast.LENGTH_LONG).show();

                startActivity(new Intent(AddPostActivity.this, FacultyPostsActivity.class));

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