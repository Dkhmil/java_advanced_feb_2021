package service;

import model.Product;

import java.util.List;

public interface BucketProductService {

    void addProductToBucket(long bucketId, long productId);

    void removeProductFromBucket(long bucketId, long productId, boolean all);

    List<Product> getProductByBucketId(int bucketId);
}
