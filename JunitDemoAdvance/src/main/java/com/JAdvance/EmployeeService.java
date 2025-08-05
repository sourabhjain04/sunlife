package com.JAdvance;

public class EmployeeService {
    private EmployeeDAO dao;

    public EmployeeService(EmployeeDAO dao) {this.dao = dao;    }

    public Employee getEmployee(int id) {
        Employee emp = dao.findById(id);
        if(emp == null){
            throw new IllegalArgumentException("Employee not found");

        }
        return emp;

    }

    public void addEmployee(Employee emp) {
        if(emp.getSalary()<0){
            throw new IllegalArgumentException("Salary cannot be negative");

        }
        dao.save(emp);
    }


}
