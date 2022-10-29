package com.example.ebridge.Model;

import java.util.ArrayList;

public class Teacher extends User{

    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;


    public Teacher(String email, String password, String firstname, String lastname, String address) {
        super(email, password, firstname, lastname, address);
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public ArrayList<String> screensAllowed(){
        return null;
    }

    @Override
    public void validateUser(String email,String password){


    }
}
