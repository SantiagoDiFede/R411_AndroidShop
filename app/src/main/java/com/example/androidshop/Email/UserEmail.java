package com.example.androidshop.Email;

public class UserEmail {
    private static UserEmail instance;
    private String email;

    private UserEmail() {}

    public static synchronized UserEmail getInstance() {
        if (instance == null) {
            instance = new UserEmail();
        }
        return instance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
