package com.rest;

import java.util.List;

public interface UserDAO {


    void save(User user);
    void update(User user);
    void delete(int user);
    User getById(int id);
    List<User> getAll();

}
