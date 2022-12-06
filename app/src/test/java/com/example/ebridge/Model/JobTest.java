package com.example.ebridge.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JobTest {

    @Test
    void getPosition() {
        Job j = new Job("Director","abc" ,"a","2");
        assertEquals("Director",j.getPosition());
    }

    @Test
    void setPosition() {
        Job j = new Job("Director","abc" ,"a","2");
        j.setPosition("Director 1");
        assertEquals("Director 1",j.getPosition());
    }

    @Test
    void getExperienceRequired() {
        Job j = new Job("Director","abc" ,"a","2");
        assertEquals("abc",j.getExperienceRequired());
    }

    @Test
    void setExperienceRequired() {
        Job j = new Job("Director","abc" ,"a","2");
        j.setExperienceRequired("abc1");
        assertEquals("abc1",j.getExperienceRequired());
    }

    @Test
    void getDepartment() {
        Job j = new Job("Director","abc" ,"a","2");
        assertEquals("a",j.getDepartment());
    }

    @Test
    void setDepartment() {
        Job j = new Job("Director","abc" ,"a","2");
        j.setDepartment("a1");
        assertEquals("a1",j.getDepartment());
    }

    @Test
    void getPositionAvailable() {
        Job j = new Job("Director","abc" ,"a","2");
        assertEquals("2",j.getPositionAvailable());
    }

    @Test
    void setPositionAvailable() {
        Job j = new Job("Director","abc" ,"a","2");
        j.setPositionAvailable("21");
        assertEquals("21",j.getPositionAvailable());
    }
}