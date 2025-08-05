package com.mockDemo;

import java.util.List;


public interface UserRepository {
    User findById(int id);
    void deleteUser(int id);
    List<User> getAllUsers();
}

