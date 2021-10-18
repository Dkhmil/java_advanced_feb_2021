package service;

import model.response.ProductResponse;

import java.util.List;

public interface BucketProductService {

    List<ProductResponse> getProductsByBucketId(int bucketId);

    void addProductToBucket(int bucketId, int productId);

    void removeProductFromBucket(int bucketId, int productId, boolean all);

    boolean isExists(int bucketId, int productId);
}
