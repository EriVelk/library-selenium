package com.example.firstplan.model;

public class Author {
    private String firstName;
    private String familyName;
    private String dateBirth;
    private String dateDeath;

    public Author(String firstName, String familyName, String dateBirth, String dateDeath) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
    }

    public Author(String firstName, String familyName, String dateBirth) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.dateBirth = dateBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public String getDateDeath() {
        return dateDeath;
    }
}
