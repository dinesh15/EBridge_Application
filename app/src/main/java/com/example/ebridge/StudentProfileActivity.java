package com.example.ebridge;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ebridge.Model.Faculty;
import com.example.ebridge.Model.Student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentProfileActivity extends CommonAuth {

    int role = 1;
    int currId = 0;
    boolean emFound = false;
    DataSnapshot usersData;
    private EditText fname, lname, email, address;
    private Button updateBtn;
    private TextView roleView, username;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = FirebaseDatabase.getInstance().getReference().child("E-Bridge");


        db.child("users").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usersData = dataSnapshot;


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


        setContentView(R.layout.activity_student_profile);

        username = findViewById(R.id.register_username);
        fname = findViewById(R.id.register_fname);
        lname = findViewById(R.id.register_lname);
        email = findViewById(R.id.register_email);
        address = findViewById(R.id.register_address);
        updateBtn = findViewById(R.id.updateButton);
        roleView = findViewById(R.id.register_role);

        username.setText("Username : " + loggedUser.getUsername());
        fname.setText(loggedUser.getFirstname());
        lname.setText(loggedUser.getLastname());
        email.setText(loggedUser.getEmail());
        address.setText(loggedUser.getAddress());

        drawerLayout = findViewById(R.id.id_main_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navBars(StudentProfileActivity.this);
        roleView.setText("Role: Student");

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }


    private void Register() {
        boolean err = false;
        int id = loggedUser.getId();
        String f_name = fname.getText().toString().trim();
        String l_name = lname.getText().toString().trim();
        String em = email.getText().toString().trim();
        String pass = loggedUser.getPassword().trim();
        String add = address.getText().toString().trim();
        String uname = loggedUser.getUsername();


        if (f_name.isEmpty()) {
            fname.setError("First Name can not be empty");
            err = true;
        }
        if (l_name.isEmpty()) {
            lname.setError("Last Name can not be empty");
            err = true;
        }
        if (em.isEmpty()) {
            email.setError("Email can not be empty");
            err = true;
        }


        if (!err) {



                Faculty flt = new Faculty(id, uname, em, pass, f_name, l_name, add);
                db.child("users").child(uname).setValue(flt);

                loggedUser.setAddress(add);
                loggedUser.setFirstname(f_name);
                loggedUser.setEmail(em);
                loggedUser.setLastname(l_name);

                Toast.makeText(StudentProfileActivity.this, "Account Updated Successfully.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(StudentProfileActivity.this, FacultyHomeActivity.class));


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