package repository.impl;

import model.Category;
import repository.CategoryRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepositoryImpl implements CategoryRepository {
    @Override
    public void findById(int id) {
         {try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement
                    ("SELECT brand FROM product_details WHERE id = ?")) {
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getResultSet();

                Category category = new Category();
                category.setId(resultSet.getInt("id"));

                return category;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @Override
    public void findByName(String name) {
        {try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement
                ("SELECT * FROM tb_order WHERE id = ?")) {
            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getResultSet();

            Category category = new Category();
            category.setName(resultSet.getString(name));

            return category;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }


    }

    }
}
