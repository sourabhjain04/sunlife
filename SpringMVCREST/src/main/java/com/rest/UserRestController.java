package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserDAO userDAO;

    @PostMapping
    public void addUser(@RequestBody User user) {
        userDAO.save(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        userDAO.update(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userDAO.getById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userDAO.delete(id);
    }
}
