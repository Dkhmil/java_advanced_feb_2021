package service.impl;

import model.Product;
import service.BucketProductService;
import service.BucketService;
import service.ProductService;

import java.util.List;

public class BucketProductServiceImpl implements BucketProductService {

    private ProductService productService;
    private BucketService bucketService;


    @Override
    public void addProductToBucket(long bucketId, long productId) {

    }

    @Override
    public void removeProductFromBucket(long bucketId, long productId, boolean all) {

    }

    @Override
    public List<Product> getProductByBucketId(int bucketId) {
        return null;
    }
}
