package com.example.firstplan.model;

public class UserRegister {
    private String name;
    private String lastName;
    private String date;
    private String email;
    private String password;
    private String conPassword;

    public UserRegister(String name, String lastName, String date, String email, String password, String conPassword) {
        this.name = name;
        this.lastName = lastName;
        this.date = date;
        this.email = email;
        this.password = password;
        this.conPassword = conPassword;
    }

    public UserRegister() {
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConPassword() {
        return conPassword;
    }
}
