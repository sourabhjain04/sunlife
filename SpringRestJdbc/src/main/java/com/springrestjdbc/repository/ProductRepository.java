package com.springrestjdbc.repository;

import com.springrestjdbc.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbc;

    public ProductRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Product> findAll() {
        String sql = "SELECT id, name, price, qty FROM products ORDER BY id";
        return jdbc.query(sql, new ProductRowMapper());
    }

    public Optional<Product> findById(Long id) {
        String sql = "SELECT id, name, price, qty FROM products WHERE id = ?";
        List<Product> list = jdbc.query(sql, new ProductRowMapper(), id);
        return list.stream().findFirst();
    }

    public Product save(Product p) {
        String sql = "INSERT INTO products (name, price, qty) VALUES (?, ?, ?)";
        KeyHolder kh = new GeneratedKeyHolder();
        jdbc.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getQty());
            return ps;
        }, kh);
        Number key = kh.getKey();
        p.setId(key != null ? key.longValue() : null);
        return p;
    }

    public int update(Long id, Product p) {
        String sql = "UPDATE products SET name = ?, price = ?, qty = ? WHERE id = ?";
        return jdbc.update(sql, p.getName(), p.getPrice(), p.getQty(), id);
    }

    public int delete(Long id) {
        String sql = "DELETE FROM products WHERE id = ?";
        return jdbc.update(sql, id);
    }
}
