package com.example.ebridge.Model;

import java.util.ArrayList;

public class Admin extends User{

    private ArrayList<Subject> subjects;
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;

    public Admin(String email, String password, String firstname, String lastname, String address) {
        super(email, password, firstname, lastname, address);
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public ArrayList<String> screensAllowed(){
        return null;
    }

    @Override
    public void validateUser(String email,String password){


    }
}
