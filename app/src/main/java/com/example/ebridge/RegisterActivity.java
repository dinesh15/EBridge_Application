package com.example.ebridge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ebridge.Model.Faculty;
import com.example.ebridge.Model.Student;
import com.example.ebridge.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends CommonAuth implements AdapterView.OnItemSelectedListener{
    private Spinner spinner;
    private static final String[] paths = {"Student", "Faculty"};

    private EditText fname, lname,email,password,address,username;
    private Button btnRegister;
    private TextView textLogin;
    String unameF="";
    int role =1;
    int currId = 0;
    boolean emFound = false;
    DataSnapshot usersData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = FirebaseDatabase.getInstance().getReference().child("E-Bridge");

        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currId = dataSnapshot.child("currId").getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        db.child("users").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usersData = dataSnapshot;



            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


        setContentView(R.layout.activity_register);

        username = findViewById(R.id.register_username);
        fname = findViewById(R.id.register_fname);
        lname = findViewById(R.id.register_lname);
        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        address = findViewById(R.id.register_address);
        btnRegister  = findViewById(R.id.register);
        textLogin = findViewById(R.id.text_login);

        spinner = (Spinner)findViewById(R.id.rolesSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });

        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });    }


    private void Register()
    {
        boolean err=false;
        Log.d("currId1", currId +"");
        String f_name = fname.getText().toString().trim();
        String l_name = lname.getText().toString().trim();
        String em = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String add = address.getText().toString().trim();
        String uname = username.getText().toString().trim();

        if(uname.isEmpty())
        {
            username.setError("user Name can not be empty");
            err=true;
        }
        if(f_name.isEmpty())
        {
            fname.setError("First Name can not be empty");
            err=true;
        }
        if(l_name.isEmpty())
        {
            lname.setError("Last Name can not be empty");
            err=true;
        }
        if(em.isEmpty())
        {
            email.setError("Email can not be empty");
            err=true;
        }
        if(pass.isEmpty())
        {
            password.setError("Password can not be empty");
            err=true;
        }


        if(!err){
            emFound = false;
            for (DataSnapshot data : usersData.getChildren()) {
                Log.d("data",data.getKey());
                Log.d("data1",uname);
                if(data.getKey().equals(uname)){
                    Log.d("data4","true set");
                    emFound = true;
                    break;
                }
            }

            if(emFound== false){

                Log.d("data3","false");
                if(role == 1){

                    Student std = new Student(currId,uname,em,pass,f_name,l_name,add);
                    db.child("users").child(uname).setValue(std);
                    currId++;
                    db.child("currId").setValue(currId);
                    Toast.makeText(RegisterActivity.this, "Student Account Registered Successfully.", Toast.LENGTH_LONG).show();
                }

                else if(role == 2){

                    Faculty flt = new Faculty(currId,uname,em,pass,f_name,l_name,add);
                    db.child("users").child(uname).setValue(flt);
                    currId++;
                    db.child("currId").setValue(currId);
                    Toast.makeText(RegisterActivity.this, "Faculty Account Registered Successfully.", Toast.LENGTH_LONG).show();
                }

                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

            }
            else{
                Toast.makeText(RegisterActivity.this, "Username Already Exists.", Toast.LENGTH_LONG).show();
            }


        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                role = 1;
                break;
            case 1:
                role = 2;
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

}