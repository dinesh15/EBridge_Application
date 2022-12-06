package com.example.ebridge.Model;

public class Alert extends Notification{
    String nature;
    int type;

    public Alert(String name, String description, String nature, int type) {
        super(name, description);
        this.nature = nature;
        this.type = type;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
