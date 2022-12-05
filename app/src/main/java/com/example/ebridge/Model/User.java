package com.example.ebridge.Model;

import java.util.ArrayList;

public abstract class User implements UserI{
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String address;

    public User() {

    }

    public User(String email, String password, String firstname, String lastname, String address) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public ArrayList<String> screensAllowed(){
        return null;
    }


    @Override
    public  abstract void validateUser(String email,String password);
}
