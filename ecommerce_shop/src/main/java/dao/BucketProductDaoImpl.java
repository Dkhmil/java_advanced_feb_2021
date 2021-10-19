package dao;

import model.BucketProduct;
import model.response.ProductResponse;
import util.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BucketProductDaoImpl implements BucketProductDao {

    private static final String GET_BUCKET_PRODUCT = "SELECT * FROM bucket_product WHERE BUCKET_ID = ? AND PRODUCT_ID = ?";
    public static final String ADD_PRODUCT_TO_BUCKET = "INSERT INTO bucket_product (BUCKET_ID, PRODUCT_ID, PRODUCT_COUNT) VALUES (?, ?, ?)";
    public static final String REMOVE_PRODUCT_FROM_BUCKET = "DELETE FROM bucket_product WHERE BUCKET_ID = ? AND PRODUCT_ID = ?";
    public static final String GET_ALL_PRODUCTS_FROM_BUCKET = "SELECT product.PRODUCT_ID, product.PRODUCT_NAME, product.PRODUCT_DESCRIPTION, product.PRODUCT_PRICE, bucket_product.PRODUCT_COUNT " +
            "FROM product INNER JOIN bucket_product ON product.PRODUCT_ID = bucket_product.PRODUCT_ID WHERE bucket_product.BUCKET_ID = ?";
    public static final String UPDATE_PRODUCT_COUNT = "UPDATE bucket_product SET PRODUCT_COUNT = ? WHERE (BUCKET_ID = ?) and (PRODUCT_ID = ?)";
    private final Connection connection;

    public BucketProductDaoImpl() {
        connection = MySQLConnector.getConnection();
    }


    @Override
    public BucketProduct getBucketProductByIds(int bucketId, int productId) {
        ResultSet resultSet;
        BucketProduct bucketProduct = null;
        try (PreparedStatement statement = connection.prepareStatement(GET_BUCKET_PRODUCT)) {
            statement.setInt(1, bucketId);
            statement.setInt(2, productId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                bucketProduct = new BucketProduct(resultSet.getInt("BUCKET_ID"),
                        resultSet.getInt("PRODUCT_ID"), resultSet.getInt("PRODUCT_COUNT"));
            }
        } catch (SQLException throwables) {
            //logger here
        }
        return bucketProduct;
    }

    @Override
    public List<ProductResponse> getProductsByBucketId(int bucketId) {
        ResultSet resultSet;
        List<ProductResponse> products = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_PRODUCTS_FROM_BUCKET)) {
            statement.setInt(1, bucketId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                products.add(getProductFromResult(resultSet));
            }
        } catch (SQLException throwables) {
            // logger here
        }
        return products;
    }

    @Override
    public void addProductToBucket(BucketProduct bucketProduct) {
        try (PreparedStatement statement = connection.prepareStatement(ADD_PRODUCT_TO_BUCKET)) {
            statement.setInt(1, bucketProduct.getBucketId());
            statement.setInt(2, bucketProduct.getProductId());
            statement.setInt(3, bucketProduct.getProductCount());
            statement.execute();
        } catch (SQLException throwables) {
            // logger here
        }
    }

    @Override
    public void removeProductFromBucket(int bucketId, int productId, boolean all) {
        if (all) {
            try (PreparedStatement statement = connection.prepareStatement(REMOVE_PRODUCT_FROM_BUCKET)) {
                statement.setInt(1, bucketId);
                statement.setInt(2, productId);
                statement.execute();
            } catch (SQLException throwables) {
                // logger  here
            }
        } else {
            int currentCount = getBucketProductByIds(bucketId, productId).getProductCount();
            int productCount = currentCount - 1;
            updateProductCount(productCount, bucketId, productId);
        }
    }

    @Override
    public void updateProductCount(int productCount, int bucketId, int productId) {
        if (productCount == 0) {
            removeProductFromBucket(bucketId, productId, true);
        } else {
            try (PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_COUNT)) {
                statement.setInt(1, productCount);
                statement.setInt(2, bucketId);
                statement.setInt(3, productId);
                statement.execute();
            } catch (SQLException throwables) {
                // logger here
            }
        }
    }

    private static ProductResponse getProductFromResult(ResultSet resultSet) throws SQLException {
        return new ProductResponse(resultSet.getInt("PRODUCT_ID"), resultSet.getString("PRODUCT_NAME"),
                resultSet.getString("PRODUCT_DESCRIPTION"), resultSet.getDouble("PRODUCT_PRICE"),
                resultSet.getInt("PRODUCT_COUNT"));
    }
}
