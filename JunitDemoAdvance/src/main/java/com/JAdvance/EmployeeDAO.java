package com.JAdvance;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDAO {

    private Map<Integer, Employee> database = new HashMap<Integer, Employee>();

    public Employee findById(int id) {return database.get(id);  }

    public void save(Employee emp) {database.put(emp.getId(), emp);}



}
