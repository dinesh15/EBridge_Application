package com.example.ebridge.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void getDegree() {
        Student std = new Student(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        std.setDegree("abc");

        assertEquals("abc",std.getDegree());
    }

    @Test
    void setDegree() {
        Student std = new Student(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        std.setDegree("abc");

        assertEquals("abc",std.getDegree());
    }

    @Test
    void getSemester() {
        Student std = new Student(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        std.setLastname("1");

        assertEquals("1",std.getSemester());
    }

    @Test
    void setSemester() {
        Student std = new Student(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        std.setLastname("1");

        assertEquals("1",std.getSemester());
    }
}