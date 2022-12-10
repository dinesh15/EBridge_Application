package com.example.ebridge.Model;

import java.util.ArrayList;

public class Subject {
    private String name;
    private String subjectCode;
    private ArrayList<Student> studentsEnrolled;

    public Subject(String name,String subjectCode) {
        this.name = name;
        this.subjectCode = subjectCode;
        studentsEnrolled = new ArrayList<>();
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

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setName(String name) {
        this.name = name;
    }
}
