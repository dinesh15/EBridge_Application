package com.example.ebridge.Model;

import java.util.ArrayList;

public class Student extends User{
    private String degree;
    private String semester;
    private int stdId;
    private ArrayList<Notification> notifications;
    private ArrayList<Subject> subjects;
    MessageMediator m;
    public Student() {

    }

    public Student(String email, String password, String firstname, String lastname, String address, String degree, String semester) {
        super(email, password, firstname, lastname, address);
        this.degree = degree;
        this.semester = semester;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public int getStdId() {
        return stdId;
    }

    @Override
    public ArrayList<String> screensAllowed(){
        return null;
    }

    @Override
    public void validateUser(String email,String password){
    }

}
