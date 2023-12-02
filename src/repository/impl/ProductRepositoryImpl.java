package repository.impl;

import model.Product;
import repository.DbHelper;
import repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepositoryImpl implements ProductRepository {
    DbHelper dbHelper = new DbHelperImpl();
    @Override
    public void save(Product product) {
        String sql = "INSERT INTO tb_product (name, category_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE tb_product SET name = ?, category_id = ?";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findById(int id) {
        String sql = "SELECT * FROM tb_product WHERE id = ?";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setCategoryId(resultSet.getInt("category_id"));
                return product;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
