package service.impl;

import dao.AbstractDao;
import dao.GenericDao;
import model.Bucket;
import model.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    public ProductServiceImpl() {
        GenericDao<Product, Long> dao = new AbstractDao<>(Product.class);
    }

    @Override
    public Product create(Product bucket) {
        return null;
    }

    @Override
    public Product read(Long id) {
        return null;
    }

    @Override
    public Product update(Product bucket) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Product> readAll() {
        return null;
    }
}
