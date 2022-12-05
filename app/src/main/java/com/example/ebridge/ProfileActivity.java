package com.example.ebridge;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends CommonAuth {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
//    private Button btnLogout;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        super.setmAuth(FirebaseAuth.getInstance());
        drawerLayout = findViewById(R.id.id_profile_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.nav_home){
                    Intent l = new Intent(ProfileActivity.this, MainActivity.class);
                    startActivity(l);
                }else  if(item.getItemId() == R.id.nav_feedback){
                    Intent l = new Intent(ProfileActivity.this, FeedbackActivity.class);
                    startActivity(l);
                }else  if(item.getItemId() == R.id.nav_profile){
                    Intent l = new Intent(ProfileActivity.this, ProfileActivity.class);
                    startActivity(l);
                }
                else  if(item.getItemId() == R.id.nav_add_subject){
                    Intent l = new Intent(ProfileActivity.this, AddSubjectActivity.class);
                    startActivity(l);
                }else  if(item.getItemId() == R.id.nav_Subjects){
                    Intent l = new Intent(ProfileActivity.this, SubjectsActivity.class);
                    startActivity(l);
                }else  if(item.getItemId() == R.id.nav_logout){
                    // logout();
                }

                DrawerLayout drawerLayout = findViewById(R.id.id_profile_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
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

        FirebaseUser currentUser = super.getmAuth().getCurrentUser();

        if (currentUser == null) {
            startActivity(new Intent(ProfileActivity.this, LoginActivity.class));

        }
    }

}