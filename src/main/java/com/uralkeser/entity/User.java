package com.uralkeser.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String id, String name, String lastName, String email, String mobileNumber, String username) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.username = username;
    }
}
