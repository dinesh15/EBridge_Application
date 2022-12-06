package com.example.ebridge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends CommonAuth {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
//    private Button btnLogout;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (loggedUser == null) {
            Intent l = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(l);
        } else {
             Log.d("role",loggedUser.getRole()+"");
            if (loggedUser.getRole() == 1) {
                Intent l = new Intent(MainActivity.this, HomeStudentActivity.class);
                startActivity(l);

            } else if (loggedUser.getRole() == 2) {
                Intent l = new Intent(MainActivity.this, HomeFacultyActivity.class);
                startActivity(l);

            } else if (loggedUser.getRole() == 3) {
                Intent l = new Intent(MainActivity.this, HomeAdminActivity.class);
                startActivity(l);

            }
        }

        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.id_main_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navBars(1, MainActivity.this);


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

    public void logout() {

        FirebaseAuth.getInstance().signOut();

        startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }
}