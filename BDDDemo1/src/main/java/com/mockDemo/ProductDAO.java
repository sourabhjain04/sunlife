package com.mockDemo;

public interface ProductDAO {
    Product findById(int id);
    void save(Product product);
}
