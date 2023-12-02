package repository.impl;

import model.Category;
import model.Product;
import repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public void save(Product product) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "INSERT INTO Category ( name,  category_id )" +
                        "VALUES (?,?)")) {
            preparedStatement.setString(1, Category.getname());
            preparedStatement.setInt(2, Math.toIntExact(id));

            preparedStatement.executeUpdate();
        }catch (SQLException e){
        }

    }
    }
}
