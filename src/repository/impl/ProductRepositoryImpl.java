package repository.impl;

import model.Product;
import repository.DbHelper;
import repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ProductRepositoryImpl implements ProductRepository {
    private DbHelper dbHelper = new DbHelperImpl();
    @Override
    public void save(Product product) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement
                ("INSERT INTO tb_product(name,categoryID)"+
                        "VALUES(?,?)")) {

            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getCategoryId());

            preparedStatement.executeUpdate();




        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save client", e);

        }
    }


}
