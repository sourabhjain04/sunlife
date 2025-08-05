package com.JAdvance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class EmployeeServiceTest {

    private EmployeeService service;

    private EmployeeDAO dao;
    @BeforeEach
    void setUp(){
        dao = new EmployeeDAO();
        service = new EmployeeService(dao);
    }


    // Using Assumptions

    @Test
    void testGetEmployeeOnlyOnWindows(){
        assumeTrue(System.getProperty("os.name").startsWith("Windows"),
                "Test skipped: Not running on Windows");
        dao.save(new Employee(1,"John", 50000));
        assertEquals("John" ,service.getEmployee(1).getName());
      }

    @Test
    void testSkipIfDatabaseEmpty(){
        assumeFalse(dao.findById(1)!=null,
                "DB not emplty, Skipping Test");
        assertThrows(IllegalAccessException.class,()->service.getEmployee(1));


    }


    @Test
    void testPartialCheckWithAssumingThat(){
        dao.save(new Employee(1,"John", 6000));
        Employee emp=service.getEmployee(1);
        assumingThat(emp.getSalary()>5000,()->{
            assertTrue(emp.getName().startsWith("J"));
        });
        assertEquals(6000,emp.getSalary());

    }

    // Testing Exception

    @Test
    void testAddEmployeeNegativeSalaryThrowsException(){
        assertThrows(IllegalArgumentException.class,()->
            service.addEmployee(new Employee(2,"Mark", -1000)));
    }

    @Test
    void testAddEmployeeValidSalaryDoesNotThrow(){
        assertDoesNotThrow(()->
                service.addEmployee(new Employee(3,"Alice", 7000)));
    }

    // Repeated Test

    @RepeatedTest(3)
    void testRepeatedAddEmployee(){
        int id = (int) (Math.random()*1000);
        assertDoesNotThrow(()->service.addEmployee(new Employee(id,"TestEmp", 4000)));

    }


    @ParameterizedTest
    @ValueSource(doubles={3000,4500,6000})
    void testAddEmployeeWithDifferentSalaries(double salary){
        assertDoesNotThrow(()->service.addEmployee(new Employee((int)(Math.random()*1000),"ParamEmp",salary)));
    }










}
