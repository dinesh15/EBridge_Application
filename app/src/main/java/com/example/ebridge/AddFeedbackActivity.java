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

import com.example.ebridge.Model.Feedback;
import com.example.ebridge.Model.Post;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddFeedbackActivity extends CommonAuth {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private Button sendFeedbackButton;
    private TextView feedbackTitle,message;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_feedback);
        sendFeedbackButton = findViewById(R.id.sendFeedbackButton);
        db = FirebaseDatabase.getInstance().getReference().child("E-Bridge");
        feedbackTitle = findViewById(R.id.feedbackTitle);
        message = findViewById(R.id.message);

        drawerLayout = findViewById(R.id.id_main_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navBars(AddFeedbackActivity.this);
        sendFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFeedback();
            }
        });
    }

    public void addFeedback(){
        boolean err=false;
        String feedbackTitleS = feedbackTitle.getText().toString().trim();
        String messageS = message.getText().toString().trim();
        if(feedbackTitleS.isEmpty())
        {
            feedbackTitle.setError("Feedback Title cannot be empty.");
            err=true;
        }
        else if(messageS.isEmpty())
        {
            message.setError("Feedback Message cannot be empty.");
            err=true;
        }


        if(!err){
            Feedback feedback = new Feedback(feedbackTitleS,messageS);
                db.child("feedbacks").child(feedbackTitleS).setValue(feedback);
                Toast.makeText(AddFeedbackActivity.this, "Feedback Added Successfully.", Toast.LENGTH_LONG).show();
                if(loggedUser.getRole() == 1)
                    startActivity(new Intent(AddFeedbackActivity.this, StudentFeedbacksActivity.class));
                else if(loggedUser.getRole() == 2)
                    startActivity(new Intent(AddFeedbackActivity.this, FacultyFeedbacksActivity.class));
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