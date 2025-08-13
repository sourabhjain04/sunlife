package com.restempdep.springmongodbatlas1;

import com.restempdep.springmongodbatlas1.Employee;
import com.restempdep.springmongodbatlas1.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Employee> getAll() {
        return repository.findAll();
    }



    @GetMapping("/{id}")
    public Employee getById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }


    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        Employee saved = repository.save(employee);
        System.out.println("Saved: " + saved);
        return saved;
    }
}
