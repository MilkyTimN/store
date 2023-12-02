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
    public void save(Category category) {
        String sql = "INSERT INTO tb_category (name) VALUES(?)";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setString(1, category.getName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }

    @Override
    public Category findById(int id) {
        try {
            PreparedStatement preparedStatement = dbHelper.getPreparedStatement("SELECT * FROM tb_category WHERE id = ?");
            preparedStatement.setInt(1, id);


            ResultSet resultSet = preparedStatement.executeQuery();

            Category category = new Category();
            while (resultSet.next()){
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
            }
            return category;
        } catch (SQLException e) {
            throw new RuntimeException(e);
            }
        }


    }
