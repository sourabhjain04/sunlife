package com.junitDemo;

public class Employee {


    private int id;
    private String name;
    private Department department;
    private double salary;

    public Employee(int id, String name, Department department, double salary){

        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;



    }


    public double getSalary(){
        return salary*12;
    }


    public Department getDepartment(){
        return department;
    }



}
