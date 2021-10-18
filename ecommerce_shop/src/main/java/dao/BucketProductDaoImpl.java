package dao;

import model.BucketProduct;
import model.Product;
import util.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BucketProductDaoImpl implements BucketProductDao {

    private static final String GET_BUCKET_PRODUCT = "SELECT * FROM bucket_product WHERE BUCKET_ID = ? AND PRODUCT_ID = ?";

    private Connection connection;

    public BucketProductDaoImpl(Connection connection) {
        this.connection = MySQLConnector.getConnection();
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
               // add logger here
        }
        return bucketProduct;
    }

    @Override
    public List<Product> getProductsByBucketId(int bucketId) {
        return null;
    }

    @Override
    public void addProductToBucket(BucketProduct bucketProduct) {

    }

    @Override
    public void removeProductFromBucket(int bucketId, int productId, boolean all) {

    }

    @Override
    public void updateProductCount(int productCount, int bucketId, int productId) {

    }
}
