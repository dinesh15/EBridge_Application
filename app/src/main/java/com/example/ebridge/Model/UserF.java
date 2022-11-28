package com.example.ebridge.Model;

public class UserF {
    public User getUser(String userType){
        if(userType.equalsIgnoreCase("Teacher")){
            return new Teacher();
        }else if(userType.equalsIgnoreCase("Student")){
            return new Student();
        }else if(userType.equalsIgnoreCase("Admin")){
            return new Admin();
        }
        return null;
    }
}
