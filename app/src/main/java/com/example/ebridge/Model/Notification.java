package com.example.ebridge.Model;

import java.util.Date;

public class Notification {

    String name;
    String description;
    String type;
    String nature;
    String code;
    Date time;
    String location;

    public Notification(String name, String description, String type, String nature, String code, Date time, String location) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.nature = nature;
        this.code = code;
        this.time = time;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
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
