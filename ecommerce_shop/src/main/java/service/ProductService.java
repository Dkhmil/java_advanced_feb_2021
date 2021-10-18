package service;

import model.Product;

import java.util.List;

public interface ProductService {
    Product create(Product bucket);

    Product read(Long id);

    Product update(Product bucket);

    void delete(Long id);

    List<Product> readAll();

    boolean isExist(long productId);
}
