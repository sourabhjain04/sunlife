package com.junitDemo;

public class EmployeeService
{

    public boolean isHighEarner(Employee emp){
        return emp.getSalary() > 1_000_000;
    }
}
