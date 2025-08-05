package com.mockDemo;

import java.util.List;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUser(int id) {
        return repository.findById(id);

    }

    public void removeUser(int id){
        repository.deleteUser(id);

    }

 public String greetUser(User user) {
        return "Hello," + user.getName();
 }


 public void processUsers() {
        List<User> users =repository.getAllUsers();
     for (User user : users) {
         System.out.println("Processing user: " + user);
     }

 }


}
