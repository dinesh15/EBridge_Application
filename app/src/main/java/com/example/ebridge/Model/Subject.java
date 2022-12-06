package com.example.ebridge.Model;

import java.util.ArrayList;

public class Subject {
    private String name;
    private ArrayList<Student> studentsEnrolled;


    public Subject(String name) {
        this.name = name;
    }

    public java.lang.String getName() {
        return name;
    }

    public ArrayList<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(ArrayList<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public void setName(String name) {
        this.name = name;
    }
}
