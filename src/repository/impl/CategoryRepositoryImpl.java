package repository.impl;

import model.Category;
import repository.CategoryRepository;
import repository.DPHelper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryRepositoryImpl implements CategoryRepository {
    private DPHelper dbHelper = new DbHelperImpl();

    @Override
    public void save(Category category) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "INSERT INTO Category ( name)" +
                        "VALUES (?)")) {
            preparedStatement.setString(1, category.getName());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
        }

    }
}
