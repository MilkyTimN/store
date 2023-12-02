package repository.impl;

import model.Product;
import model.ProductDetails;
import repository.DbHelper;
import repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Override
    public List<Product> findByPrice(String categoryName, Boolean typeSort) {

        List<Product> response = new ArrayList<>();
        String sql = "SELECT p.id, p.name, p.category_id FROM tb_product p JOIN tb_category c on c.id = p.category_id JOIN tb_product_details d on p.id = d.product_id WHERE c.name = ? ORDER BY d.price";

        if(typeSort) sql = sql + " DESC";

        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setString(1, categoryName);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setCategoryId(resultSet.getInt("category_id"));
                response.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public List<Product> findByBrand(String categoryName, String brand) {
        List<Product> response = new ArrayList<>();
        String sql = "SELECT p.id, p.name, p.category_id FROM tb_product p JOIN tb_product_details d on p.id = d.product_id JOIN tb_category c on c.id = p.category_id WHERE c.name = ? AND d.brand = ?";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setString(1, categoryName);
            preparedStatement.setString(2, brand);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setCategoryId(resultSet.getInt("category_id"));
                response.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public List<String> findBrands(String categoryName) {
        List<String> response = new ArrayList<>();
        String sql = "SELECT DISTINCT d.brand FROM tb_product_details d JOIN tb_product p on p.id = d.product_id JOIN tb_category c on c.id = p.category_id WHERE c.name = ?";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setString(1, categoryName);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                response.add(resultSet.getString("brand"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public int findQuantityByCategory(String categoryName) {
        String sql = "SELECT sum(d.quantity) as quantity FROM tb_product_details d JOIN tb_product p on p.id = d.product_id JOIN tb_category c on c.id = p.category_id WHERE c.name = ?";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setString(1, categoryName);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                return resultSet.getInt("quantity");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
