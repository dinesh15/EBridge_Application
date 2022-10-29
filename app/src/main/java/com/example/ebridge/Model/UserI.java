package com.example.ebridge.Model;

import java.util.ArrayList;

public interface UserI {

    void validateUser(String email,String password);

    ArrayList<String> screensAllowed();
}
