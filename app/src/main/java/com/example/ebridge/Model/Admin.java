package com.example.ebridge.Model;

import java.util.ArrayList;

public class Admin extends User {

    private ArrayList<Subject> subjects;
    private ArrayList<Student> students;
    private ArrayList<Faculty> teachers;

    private ArrayList<Feedback> feedbacks;

    private ArrayList<Notification> notifications;

    MessageMediator m;
    public Admin() {

    }

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

    public ArrayList<Faculty> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Faculty> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public ArrayList<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(ArrayList<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public ArrayList<String> screensAllowed() {
        return null;
    }

    @Override
    public void validateUser(String email, String password) {


    }
}
