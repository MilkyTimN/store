package repository.impl;

import model.Product;
import model.ProductDetails;
import repository.DbHelper;
import repository.ProductDetailsRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDetailsRepositoryImpl implements ProductDetailsRepository {
    DbHelper dbHelper = new DbHelperImpl();
    @Override
    public void save(ProductDetails productDetails) {
        String sql = "INSERT INTO tb_product_details (product_id, brand, price, description, quantity) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setInt(1, productDetails.getProductId());
            preparedStatement.setString(2,productDetails.getBrand());
            preparedStatement.setDouble(3, productDetails.getPrice());
            preparedStatement.setString(4, productDetails.getDescription());
            preparedStatement.setInt(5, productDetails.getQuantity());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(ProductDetails productDetails) {
        String sql = "UPDATE tb_product_details SET product_id = ?, brand = ?, price = ?, description = ?, quantity = ?;";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setInt(1, productDetails.getProductId());
            preparedStatement.setString(2, productDetails.getBrand());
            preparedStatement.setDouble(3, productDetails.getPrice());
            preparedStatement.setString(4, productDetails.getDescription());
            preparedStatement.setInt(5, productDetails.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductDetails findById(int id) {
        String sql = "SELECT * FROM tb_product_details WHERE id = ?;";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                ProductDetails productDetails = new ProductDetails();
                productDetails.setProductId(resultSet.getInt("product_id"));
                productDetails.setBrand(resultSet.getString("brand"));
                productDetails.setPrice(resultSet.getDouble("price"));
                productDetails.setDescription(resultSet.getString("description"));
                productDetails.setQuantity(resultSet.getInt("quantity"));

                return productDetails;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
