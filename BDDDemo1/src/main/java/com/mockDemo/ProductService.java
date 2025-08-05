package com.mockDemo;

public class ProductService {
    private final ProductDAO dao;

    public ProductService(ProductDAO dao) {
        this.dao = dao;
    }

    public Product getProduct(int id) {
        return dao.findById(id);
    }

    public void addProduct(Product product) {
        dao.save(product);
    }
}
