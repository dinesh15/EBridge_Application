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
    public Admin(int id,String username, String email, String password, String firstname, String lastname, String address) {

        super(id,username, email, password, firstname, lastname, address);
        this.subjects = new ArrayList<>();
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.m = m;
    }

    public Admin(int id,String username, String email, String password, String firstname, String lastname, String address, ArrayList<Subject> subjects, ArrayList<Student> students, ArrayList<Faculty> teachers, ArrayList<Feedback> feedbacks, ArrayList<Notification> notifications, MessageMediator m) {

        super(id,username, email, password, firstname, lastname, address);
        this.subjects = subjects;
        this.students = students;
        this.teachers = teachers;
        this.feedbacks = feedbacks;
        this.notifications = notifications;
        this.m = m;
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
