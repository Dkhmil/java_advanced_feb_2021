package dao;

import model.BucketProduct;
import model.Product;

import java.util.List;

public interface BucketProductDao {

    BucketProduct getBucketProductByIds(int bucketId, int productId);

    List<Product> getProductsByBucketId(int bucketId);

    void addProductToBucket(BucketProduct bucketProduct);

    void removeProductFromBucket(int bucketId, int productId, boolean all);

    void updateProductCount(int productCount, int bucketId, int productId);
}
