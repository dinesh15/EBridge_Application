package com.example.ebridge.Model;

import java.io.File;
import java.util.ArrayList;

public class Resource {
    private String name;
    private File file;
    private Faculty faculty;
    private ArrayList<Student> students;

    public Resource(String name, File file, Faculty faculty) {
        this.name = name;
        this.file = file;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
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
