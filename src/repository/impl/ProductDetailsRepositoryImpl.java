package repository.impl;

import model.ProductDetails;
import repository.DbHelper;
import repository.ProductDetailsRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDetailsRepositoryImpl implements ProductDetailsRepository {
    DbHelper dbHelper = new DbHelperImpl();
    @Override
    public void save(ProductDetails productDetails) {
        String sql = "INSERT INTO tb_productDetails (productId, brand, price, description, quantity) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setInt(1, productDetails.getProductId());
            preparedStatement.setString(2, productDetails.getBrand());
            preparedStatement.setDouble(3, productDetails.getPrice());
            preparedStatement.setString(4, productDetails.getDescription());
            preparedStatement.setInt(5, productDetails.getQuantity());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }
}
