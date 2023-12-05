package repository.impl;

import model.Category;
import model.Product;
import repository.DPHelper;
import repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductRepositoryImpl implements ProductRepository {
    private DPHelper dbHelper = new DbHelperImpl();
    @Override
    public void save(Product product) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "INSERT INTO Category ( name,  category_id )" +
                        "VALUES (?,?)")) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategoryId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
        }

    }
    }
}
