package repository.impl;

import model.Category;
import model.Product;
import repository.DbHelper;
import repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductRepositoryImpl implements ProductRepository {

    private DbHelper dbHelper = new DbHelperImpl();

    public void save(Product product){
        try(PreparedStatement preparedStatement = dbHelper.getPreparedStatement
                ("INSERT INTO tb_product (name, categoryId) VALUES (?, ?)")){

            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategoryId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
