package com.JdbcCrud;

public class App {
    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();

        //  dao.addEmployee(new Employee(101,"Jhon Doe","Manager"));


        // READ
        System.out.println("All Employees");
        dao.getAllEmployees().forEach(System.out::println);

        //update

        dao.updateEmployeeRole(101, "Developer");

        //Delete
        dao.deleteEmployee(101);
    }
}
