package com.example.ebridge.Model;

public class Job {
    private String position;
    private String experienceRequired;
    private String department;
    private String positionAvailable;

    public Job(String position, String experienceRequired, String department, String positionAvailable) {
        this.position = position;
        this.experienceRequired = experienceRequired;
        this.department = department;
        this.positionAvailable = positionAvailable;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getExperienceRequired() {
        return experienceRequired;
    }

    public void setExperienceRequired(String experienceRequired) {
        this.experienceRequired = experienceRequired;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPositionAvailable() {
        return positionAvailable;
    }

    public void setPositionAvailable(String positionAvailable) {
        this.positionAvailable = positionAvailable;
    }
}
