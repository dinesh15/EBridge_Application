package com.example.ebridge.Model;

import java.util.ArrayList;

public class Faculty extends User{

    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;
    private ArrayList<Post> posts;
    private ArrayList<Schedule> schedules;
    private ArrayList<Resource> resources;
    private ArrayList<Attendance> attendances;
    private ArrayList<Notification> notifications;

    MessageMediator m;
    public Faculty() {

    }

    public Faculty(String email, String password, String firstname, String lastname, String address) {
        super(email, password, firstname, lastname, address);
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

    public ArrayList<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(ArrayList<Attendance> attendances) {
        this.attendances = attendances;
    }

    public MessageMediator getM() {
        return m;
    }

    public void setM(MessageMediator m) {
        this.m = m;
    }

    @Override
    public ArrayList<String> screensAllowed(){
        return null;
    }

    @Override
    public void validateUser(String email,String password){


    }
}
