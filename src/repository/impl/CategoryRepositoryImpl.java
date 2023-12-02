package repository.impl;

import model.Category;
import repository.CategoryRepository;
import repository.DbHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepositoryImpl implements CategoryRepository {
    DbHelper dbHelper = new DbHelperImpl();
    @Override
    public void save(String name) {
        String sql = "INSERT INTO tb_category(name) VALUES (?)";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Category category) {
        String sql = "UPDATE tb_category SET name = ?";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category findById(int id) {

        String sql = "SELECT * FROM tb_category WHERE id = ?";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));

                return category;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
