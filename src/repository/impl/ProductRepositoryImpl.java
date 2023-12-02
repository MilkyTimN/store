package repository.impl;

import model.Category;
import model.Product;
import repository.DbHelper;
import repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepositoryImpl implements ProductRepository {
    DbHelper dbHelper = new DbHelperImpl();

    public void save(Product product){
        String sql = "INSERT INTO tb_product (name, categoryId) VALUES(?, ?)";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategoryId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }

    @Override
    public Product findById(int id) {
        try {
            PreparedStatement preparedStatement = dbHelper.getPreparedStatement("SELECT * FROM tb_product WHERE id = ?");
            preparedStatement.setInt(1, id);


            ResultSet resultSet = preparedStatement.executeQuery();

            Product product = new Product();
            while (resultSet.next()){
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setCategoryId(resultSet.getInt("categoryId"));
            }
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeById(int id) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement("DELETE FROM tb_product WHERE id= ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println("catch");
        }
    }
}
