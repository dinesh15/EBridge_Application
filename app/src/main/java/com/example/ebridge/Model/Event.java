package com.example.ebridge.Model;

import java.util.Date;

public class Event {
    private String name;
    private String desciption;
    private String venu;
    private String date;

    public Event(String name, String desciption, String venu, String date) {
        this.name = name;
        this.desciption = desciption;
        this.venu = venu;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getVenu() {
        return venu;
    }

    public void setVenu(String venu) {
        this.venu = venu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
