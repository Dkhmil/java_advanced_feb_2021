package service.impl;

import dao.BucketProductDao;
import dao.BucketProductDaoImpl;
import model.BucketProduct;
import model.response.ProductResponse;
import service.BucketProductService;
import service.BucketService;
import service.ProductService;

import java.util.List;
import java.util.Objects;

public class BucketProductServiceImpl implements BucketProductService {

    private final BucketProductDao bucketProductDao;
    private final BucketService bucketService;
    private final ProductService productService;

    public BucketProductServiceImpl() {
        bucketProductDao = new BucketProductDaoImpl();
        bucketService = new BucketServiceImpl();
        productService = new ProductServiceImpl();
    }

    @Override
    public List<ProductResponse> getProductsByBucketId(int bucketId) {
        if (bucketService.isExist(bucketId)) {
            return bucketProductDao.getProductsByBucketId(bucketId);
        } else {
            throw new RuntimeException("No bucket with id : " + bucketId);
        }
    }

    @Override
    public void addProductToBucket(int bucketId, int productId) {
        if (bucketService.isExist(bucketId) && productService.isExist(productId)) {
            if (isExists(bucketId, productId)) {
                BucketProduct bucketProduct = bucketProductDao.getBucketProductByIds(bucketId, productId);
                int currentCount = bucketProduct.getProductCount();
                int updatedCount = currentCount + 1;
                bucketProductDao.updateProductCount(updatedCount, bucketId, productId);
            } else {
                bucketProductDao.addProductToBucket(new BucketProduct(bucketId, productId, 1));
            }
        } else {
            if (!bucketService.isExist(bucketId)) {
                throw new RuntimeException("No bucket with id : " + bucketId);
            } else if (!productService.isExist(productId)) {
                throw new RuntimeException("No product with id : " + productId);
            }
        }
    }


    @Override
    public void removeProductFromBucket(int bucketId, int productId, boolean all) {
        if (bucketService.isExist(bucketId) && productService.isExist(productId)) {
            if (all) {
                bucketProductDao.removeProductFromBucket(bucketId, productId, true);
            } else {
                bucketProductDao.removeProductFromBucket(bucketId, productId, false);
            }
        } else {
            if (!bucketService.isExist(bucketId)) {
                throw new RuntimeException("No bucket with id : " + bucketId);
            } else if (!productService.isExist(productId)) {
                throw new RuntimeException("No product with id : " + productId);
            }
        }
    }

    @Override
    public boolean isExists(int bucketId, int productId) {
        return !Objects.isNull(bucketProductDao.getBucketProductByIds(bucketId, productId));
    }
}
