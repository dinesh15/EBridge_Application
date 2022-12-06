package com.example.ebridge.Model;

import java.io.File;
import java.util.ArrayList;

public class Attendance {
    private String month;
    private File attendanceSheet;
    private Faculty faculty;
    private ArrayList<Student> students;

    public Attendance(String month, File attendanceSheet, Faculty faculty) {
        this.month = month;
        this.attendanceSheet = attendanceSheet;
        this.faculty = faculty;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public File getAttendanceSheet() {
        return attendanceSheet;
    }

    public void setAttendanceSheet(File attendanceSheet) {
        this.attendanceSheet = attendanceSheet;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
