package com.rest;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO users (name, email) VALUES (?, ?)",
                user.getName(), user.getEmail());
    }

    public void update(User user) {
        jdbcTemplate.update("UPDATE users SET name=?, email=? WHERE id=?",
                user.getName(), user.getEmail(), user.getId());
    }


    public void delete(int user) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", user);
    }


    public User getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?",
                new BeanPropertyRowMapper<>(User.class), id);
    }

    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM users",
                new BeanPropertyRowMapper<>(User.class));
    }
}
