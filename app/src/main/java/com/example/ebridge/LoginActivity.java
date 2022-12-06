package com.example.ebridge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ebridge.Model.Admin;
import com.example.ebridge.Model.Faculty;
import com.example.ebridge.Model.Student;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends CommonAuth {

    private EditText email, password;
    private Button btnLogin;
    private TextView textRegister;
    boolean emFound= false;
    DataSnapshot usersData;
    DataSnapshot founddata;
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

        setContentView(R.layout.activity_login);
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        btnLogin = findViewById(R.id.login);
        textRegister = findViewById(R.id.text_register);




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }


    private void login() {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (user.isEmpty()) {
            email.setError("username can not be empty");
        }
        if (pass.isEmpty()) {
            password.setError("Password can not be empty");
        } else {

            emFound = false;
            for (DataSnapshot data : usersData.getChildren()) {
                Log.d("data",data.getKey());
                Log.d("data1",user);
                if(data.getKey().equals(user)){
                    Log.d("data4",data.child("password").getValue().toString());
                    if(data.child("password").getValue().toString().equals(pass)){
                        Log.d("data4","true set");
                        founddata = data;
                        emFound = true;
                        break;
                    }

                }
            }

            if(!emFound)
            {
                Toast.makeText(LoginActivity.this, "Invalid Login Credientials", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(LoginActivity.this, "Login Successful| Welcome "+user, Toast.LENGTH_SHORT).show();

                if(founddata.child("role").getValue().toString().equals("1")){

                    loggedUser = new Student(Integer.parseInt(founddata.child("id").getValue().toString()),
                            founddata.getKey(),
                            founddata.child("email").getValue().toString(),
                            founddata.child("password").getValue().toString(),
                            founddata.child("firstname").getValue().toString(),
                            founddata.child("lastname").getValue().toString(),
                            founddata.child("address").getValue().toString());
                }
                else if(founddata.child("role").getValue().toString().equals("2")){
                    loggedUser = new Faculty(Integer.parseInt(founddata.child("id").getValue().toString()),
                            founddata.getKey(),
                            founddata.child("email").getValue().toString(),
                            founddata.child("password").getValue().toString(),
                            founddata.child("firstname").getValue().toString(),
                            founddata.child("lastname").getValue().toString(),
                            founddata.child("address").getValue().toString());
                }else if(founddata.child("role").getValue().toString().equals("3")){
                    loggedUser = new Admin(Integer.parseInt(founddata.child("id").getValue().toString()),
                            founddata.getKey(),
                            founddata.child("email").getValue().toString(),
                            founddata.child("password").getValue().toString(),
                            founddata.child("firstname").getValue().toString(),
                            founddata.child("lastname").getValue().toString(),
                            founddata.child("address").getValue().toString());
                }

                startActivity(new Intent(LoginActivity.this, MainActivity.class));

            }

        }
    }
}