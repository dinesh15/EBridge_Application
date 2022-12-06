package com.example.ebridge;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ebridge.Model.User;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class CommonAuth  extends AppCompatActivity {
    public DatabaseReference db;
    public static User loggedUser;

    public void navBars(int role, Context contaxt){

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.nav_home){
                    startActivity(new Intent(contaxt, HomeAdminActivity.class));
                }else  if(item.getItemId() == R.id.nav_feedbacks){
                    startActivity(new Intent(contaxt, FeedbackActivity.class));
                }else  if(item.getItemId() == R.id.nav_profile){
                    Intent l = new Intent(contaxt, ProfileActivity.class);
                    startActivity(l);
                }
                else  if(item.getItemId() == R.id.nav_add_subject){
                    startActivity(new Intent(contaxt, AddSubjectActivity.class));
                }else  if(item.getItemId() == R.id.nav_subjects){
                    Intent l = new Intent(contaxt, SubjectsActivity.class);
                    startActivity(l);
                }else  if(item.getItemId() == R.id.nav_logout){
                    loggedUser = null;
                    startActivity(new Intent(contaxt, LoginActivity.class));
                }

                DrawerLayout drawerLayout = findViewById(R.id.id_main_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }


}
