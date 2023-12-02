package repository.impl;

import model.Category;
import repository.CategoryRepository;
import repository.DbHelper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryRepositoryImpl implements CategoryRepository {

    private DbHelper dbHelper = new DbHelperImpl();
    public void save(Category category){
        try(PreparedStatement preparedStatement = dbHelper.getPreparedStatement
                ("INSERT INTO tb_category (name) VALUES (?)")){

            preparedStatement.setString(1, category.getName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
