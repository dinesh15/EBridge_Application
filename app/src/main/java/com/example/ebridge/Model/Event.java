package com.example.ebridge.Model;

import java.util.Date;

public class Event extends Notification{
    String code;
    Date time;
    String location;

    public Event(String name, String description, String code, Date time, String location) {
        super(name, description);
        this.code = code;
        this.time = time;
        this.location = location;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
