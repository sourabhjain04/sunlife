package com.junitDemo;

public class Department {

    private int id;
    private String name;

    public Department(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
