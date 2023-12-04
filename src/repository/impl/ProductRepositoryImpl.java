package repository.impl;

import model.Product;
import repository.DbHelper;
import repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepositoryImpl implements ProductRepository {

    private DbHelper dbHelper = new DbHelperImpl();

    @Override
    public void save(Product product) {
        try(PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "INSERT INTO tb_product (name, categoryId) VALUES (?, ?)")) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategoryId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findQuantity(Product product) {
        int result = 0;

        try(PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "SELECT pd.brand, COUNT(*) FROM tb_product_details pd JOIN tb_product p ON p.id = pd.product_id WHERE p.id = ? GROUP BY pd.brand")) {

            preparedStatement.setInt(1, product.getId());

            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                result += resultSet.getInt("quantity");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

    @Override
    public int findQuantityAll(Product product) {
        int result = 0;

        try(PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "SELECT sum(pd.quantity) FROM tb_product_details pd JOIN tb_product p ON p.id = pd.product_id WHERE p.id = ?")) {

            preparedStatement.setInt(1, product.getId());

            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();

                while (resultSet.next()) {
                    result += resultSet.getInt("sum");
                }

                return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
