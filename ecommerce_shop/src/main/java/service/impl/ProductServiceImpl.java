package service.impl;

import dao.AbstractDao;
import dao.GenericDao;
import model.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final GenericDao<Product, Long> dao;

    public ProductServiceImpl() {
        dao = new AbstractDao<>(Product.class);
    }

    @Override
    public Product create(Product product) {
        return dao.create(product);
    }

    @Override
    public Product read(Long id) {
        return dao.read(id);
    }

    @Override
    public Product update(Product product) {
        return dao.update(product);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<Product> readAll() {
        return dao.readAll();
    }
}
