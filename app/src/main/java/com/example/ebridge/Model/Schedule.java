package com.example.ebridge.Model;

import java.util.Date;

public class Schedule {
    private Days day;
    private Date timeSlot;
    private boolean available;

    public Schedule(Days day, Date timeSlot, boolean available) {
        this.day = day;
        this.timeSlot = timeSlot;
        this.available = available;
    }

    public Days getDay() {
        return day;
    }

    public void setDay(Days day) {
        this.day = day;
    }

    public Date getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Date timeSlot) {
        this.timeSlot = timeSlot;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
