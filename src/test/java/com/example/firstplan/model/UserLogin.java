package com.example.firstplan.model;

public class UserLogin {
    private String email;
    private String passsword;

    public UserLogin() {
    }

    public UserLogin(String email, String passsword) {
        this.email = email;
        this.passsword = passsword;
    }

    public String getEmail() {
        return email;
    }

    public String getPasssword() {
        return passsword;
    }
}
