package com.example.ebridge.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void getEmail() {
        Admin admin = new Admin(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        assertEquals("admin@gmail.com",admin.getEmail());
    }

    @Test
    void setEmail() {
        Admin admin = new Admin(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        admin.setEmail("admin1@gmail.com");
        assertEquals("admin1@gmail.com",admin.getEmail());
    }

    @Test
    void getPassword() {
        Admin admin = new Admin(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        assertEquals("123",admin.getPassword());
    }

    @Test
    void setPassword() {
        Admin admin = new Admin(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        admin.setPassword("456");
        assertEquals("456",admin.getPassword());
    }

    @Test
    void getId() {
        Admin admin = new Admin(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        assertEquals(1,admin.getId());
    }

    @Test
    void setId() {
        Admin admin = new Admin(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        admin.setId(2);
        assertEquals(2,admin.getId());
    }

    @Test
    void getRole() {
        Admin admin = new Admin(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        assertEquals(3,admin.getRole());
    }



    @Test
    void getFirstname() {
        Admin admin = new Admin(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        assertEquals("admin",admin.getFirstname());
    }

    @Test
    void setFirstname() {
        Admin admin = new Admin(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        admin.setFirstname("admin1");
        assertEquals("admin1",admin.getFirstname());
    }

    @Test
    void getLastname() {
        Admin admin = new Admin(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        assertEquals("admin",admin.getLastname());
    }

    @Test
    void setLastname() {
        Admin admin = new Admin(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        admin.setLastname("admin1");
        assertEquals("admin1",admin.getLastname());
    }

    @Test
    void getAddress() {
        Admin admin = new Admin(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        assertEquals("street 1",admin.getAddress());
    }

    @Test
    void setAddress() {
        Admin admin = new Admin(1,"admin","admin@gmail.com","123","admin","admin","street 1");
        admin.setAddress("street 2");
        assertEquals("street 2",admin.getAddress());
    }
}