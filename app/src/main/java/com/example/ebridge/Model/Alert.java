package com.example.ebridge.Model;

public class Alert {
    private String name;
    private String desciption;

    public Alert(String name, String desciption) {
        this.name = name;
        this.desciption = desciption;
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
}
