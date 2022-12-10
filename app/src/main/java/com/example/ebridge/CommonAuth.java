package com.example.ebridge;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ebridge.Model.User;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;

public class CommonAuth  extends AppCompatActivity {
    public DatabaseReference db;
    public static User loggedUser;

    public void navBars(Context contaxt){

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.nav_home){
                    startActivity(new Intent(contaxt, AdminHomeActivity.class));
                }else  if(item.getItemId() == R.id.nav_feedbacks_admin){
                    startActivity(new Intent(contaxt, AdminFeedbacksActivity.class));
                }else  if(item.getItemId() == R.id.nav_student_profile){
                    Intent l = new Intent(contaxt, StudentProfileActivity.class);
                    startActivity(l);
                }else  if(item.getItemId() == R.id.nav_admin_profile){
                    Intent l = new Intent(contaxt, AdminProfileActivity.class);
                    startActivity(l);
                }else  if(item.getItemId() == R.id.nav_faculty_profile){
                    Intent l = new Intent(contaxt, FacultyProfileActivity.class);
                    startActivity(l);
                }
                else  if(item.getItemId() == R.id.nav_add_subject){
                    startActivity(new Intent(contaxt, AddSubjectActivity.class));
                }else  if(item.getItemId() == R.id.nav_subjects_faculty){
                    Intent l = new Intent(contaxt, FacultySubjectsActivity.class);
                    startActivity(l);
                }else  if(item.getItemId() == R.id.nav_subjects_student){
                    Intent l = new Intent(contaxt, StudentSubjectsActivity.class);
                    startActivity(l);
                }else  if(item.getItemId() == R.id.nav_logout){
                    loggedUser = null;
                    startActivity(new Intent(contaxt, LoginActivity.class));
                }else  if(item.getItemId() == R.id.nav_add_job){
                    startActivity(new Intent(contaxt, AddJobActivity.class));
                }else  if(item.getItemId() == R.id.nav_add_alert){
                    startActivity(new Intent(contaxt, AddAlertActivity.class));
                }else  if(item.getItemId() == R.id.nav_add_event){
                    startActivity(new Intent(contaxt, AddEventActivity.class));
                }else  if(item.getItemId() == R.id.nav_view_events_admin){
                    startActivity(new Intent(contaxt, AdminEventsActivity.class));
                }else  if(item.getItemId() == R.id.nav_view_jobs_admin){
                    startActivity(new Intent(contaxt, AdminJobsActivity.class));
                }else  if(item.getItemId() == R.id.nav_view_alerts_admin){
                    startActivity(new Intent(contaxt, AdminAlertsActivity.class));
                }else  if(item.getItemId() == R.id.nav_view_subjects_admin){
                    startActivity(new Intent(contaxt, AdminSubjectsActivity.class));
                }else  if(item.getItemId() == R.id.nav_events_faculty){
                    startActivity(new Intent(contaxt, FacultyEventsActivity.class));
                }else  if(item.getItemId() == R.id.nav_jobs_faculty){
                    startActivity(new Intent(contaxt, FacultyJobsActivity.class));
                }else  if(item.getItemId() == R.id.nav_alerts_faculty){
                    startActivity(new Intent(contaxt, FacultyAlertsActivity.class));
                }else  if(item.getItemId() == R.id.nav_subjects_faculty){
                    startActivity(new Intent(contaxt, FacultySubjectsActivity.class));
                }else  if(item.getItemId() == R.id.nav_posts_faculty){
                    startActivity(new Intent(contaxt, FacultyPostsActivity.class));
                }else  if(item.getItemId() == R.id.nav_resources_faculty){
                    startActivity(new Intent(contaxt, FacultyResourcesActivity.class));
                }else  if(item.getItemId() == R.id.nav_feedbacks_faculty){
                    startActivity(new Intent(contaxt, FacultyFeedbacksActivity.class));
                }else  if(item.getItemId() == R.id.nav_statuses_faculty){
                    startActivity(new Intent(contaxt, FacultyStatusesActivity.class));
                }else  if(item.getItemId() == R.id.nav_events_student){
                    startActivity(new Intent(contaxt, StudentEventsActivity.class));
                }else  if(item.getItemId() == R.id.nav_jobs_student){
                    startActivity(new Intent(contaxt, StudentJobsActivity.class));
                }else  if(item.getItemId() == R.id.nav_alerts_student){
                    startActivity(new Intent(contaxt, StudentAlertsActivity.class));
                }else  if(item.getItemId() == R.id.nav_subjects_student){
                    startActivity(new Intent(contaxt, StudentSubjectsActivity.class));
                }else  if(item.getItemId() == R.id.nav_posts_student){
                    startActivity(new Intent(contaxt, StudentPostsActivity.class));
                }else  if(item.getItemId() == R.id.nav_schedules_student){
                    startActivity(new Intent(contaxt, StudentSchedulesActivity.class));
                }else  if(item.getItemId() == R.id.nav_resources_student){
                    startActivity(new Intent(contaxt, StudentResourcesActivity.class));
                }else  if(item.getItemId() == R.id.nav_feedbacks_student){
                    startActivity(new Intent(contaxt, StudentFeedbacksActivity.class));
                }else  if(item.getItemId() == R.id.nav_statuses_student){
                    startActivity(new Intent(contaxt, StudentStatusesActivity.class));
                }else  if(item.getItemId() == R.id.nav_doubts_student){
                    startActivity(new Intent(contaxt, StudentDoubtsActivity.class));
                }else  if(item.getItemId() == R.id.nav_assign_subject){
                    startActivity(new Intent(contaxt, AssignSubjectActivity.class));
                }else  if(item.getItemId() == R.id.nav_remove_assign_subject){
                    startActivity(new Intent(contaxt, RemoveAssignSubjectActivity.class));
                }else  if(item.getItemId() == R.id.nav_add_post){
                    startActivity(new Intent(contaxt, AddPostActivity.class));
                }else  if(item.getItemId() == R.id.nav_enroll_student){
                    startActivity(new Intent(contaxt, EnrollStudentActivity.class));
                }else  if(item.getItemId() == R.id.nav_add_feedback){
                    startActivity(new Intent(contaxt, AddFeedbackActivity.class));
                }

                DrawerLayout drawerLayout = findViewById(R.id.id_main_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }


}
