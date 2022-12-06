package com.example.ebridge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends CommonAuth {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
//    private Button btnLogout;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        super.setmAuth(FirebaseAuth.getInstance());
        drawerLayout = findViewById(R.id.id_main_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.nav_home){
                    Log.d("Action","Home");
                    Intent l = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(l);
                }else  if(item.getItemId() == R.id.nav_feedback){
                    Log.d("Action","Feedback");
                    Intent k = new Intent(MainActivity.this, FeedbackActivity.class);
                    startActivity(k);
                }else  if(item.getItemId() == R.id.nav_profile){
                    Intent l = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(l);
                }
                else  if(item.getItemId() == R.id.nav_add_subject){
                    Intent l = new Intent(MainActivity.this, AddSubjectActivity.class);
                    startActivity(l);
                }else  if(item.getItemId() == R.id.nav_Subjects){
                    Intent l = new Intent(MainActivity.this, SubjectsActivity.class);
                    startActivity(l);
                }else  if(item.getItemId() == R.id.nav_logout){
                    logout();
                }

                DrawerLayout drawerLayout = findViewById(R.id.id_main_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


//        btnLogout = findViewById(R.id.btnlogout);
//
//        btnLogout.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//
//            public void onClick(View v) {
//
//                logout();
//
//            }
//        });
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
            startActivity(new Intent(MainActivity.this, LoginActivity.class));

        }
    }

    public void logout() {

        FirebaseAuth.getInstance().signOut();

        startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }
}