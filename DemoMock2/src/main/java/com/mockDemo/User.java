package com.mockDemo;

public class User {
    private int id;
    private String name;

    // Constructor
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) { 
        this.id = id; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { 
        this.name = name; 
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}
