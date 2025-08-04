package com.junitDemo;

import com.junitDemo.Department;
import com.junitDemo.Employee;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Allows non-static @BeforeAll
class EmployeeServiceTest {

    private EmployeeService service;
    private Employee emp1;
    private Employee emp2;

//@BeforeAll
    void beforeAllTests() {
        System.out.println(">>> Setting up resources before ALL tests");
    }

   // @AfterAll
    void afterAllTests() {
        System.out.println(">>> Cleaning up resources after ALL tests");
    }

//    @BeforeEach
    void setUp() {
        System.out.println(">> Setting up before EACH test");

        service = new EmployeeService();
        Department itDept = new Department(1, "IT");
        emp1 = new Employee(101, "Alice", itDept, 120000); // monthly salary
        emp2 = new Employee(102, "Bob", itDept, 50000); // monthly salary
    }

   // @AfterEach
    void tearDown() {
        System.out.println(">> Cleaning up after EACH test");
    }

   // @Test
    void testYearlySalaryCalculation() {
        assertEquals(1_440_000, emp1.getSalary(),
                "Yearly salary calculation should be correct");
    }

   // @Test
    void testHighEarner() {
        assertTrue(service.isHighEarner(emp1),
                "Alice should be a high earner");
    }

  //  @Test
    void testDepartmentNotNull() {
        assertNotNull(emp1.getDepartment(),
                "Department should not be null for employee");
    }

  //  @Test
    void testLowEarner() {
        assertFalse(service.isHighEarner(emp2),
                "Bob should not be a high earner");
    }

   // @Test
    void testGroupedAssertions() {
        assertAll("Employee details",
                () -> assertEquals("IT", emp1.getDepartment().getName(), "Department name check"),
                () -> assertEquals(1, emp1.getDepartment().getName().length() > 0 ? 1 : 0, "Name length > 0")
        );
    }
}
