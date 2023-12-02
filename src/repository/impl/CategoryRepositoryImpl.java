package repository.impl;

import model.Category;
import repository.CategoryRepository;

public class CategoryRepositoryImpl implements CategoryRepository {

    private DbHelper dbHelper = new DbHelperImpl();
    @Override
    public void save(Client client) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "INSERT INTO Category ( name)" +
                        "VALUES (?)")) {
            preparedStatement.setString(1, Category.getname());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
        }

    }
}
