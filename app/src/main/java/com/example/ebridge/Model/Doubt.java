package com.example.ebridge.Model;


public class Doubt {
    private String title;
    private String details;
    private String subjectCode;

    public Doubt(String title, String details, String subjectCode) {
        this.title = title;
        this.details = details;
        this.subjectCode = subjectCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
}
