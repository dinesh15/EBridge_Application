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
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends CommonAuth {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
//    private Button btnLogout;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if(loggedUser == null){

            Intent l = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(l);
        }

        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.id_main_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navBars(1,MainActivity.this);



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

    }

    public void logout() {

        FirebaseAuth.getInstance().signOut();

        startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }
}