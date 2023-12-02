package repository;

import model.Category;

public interface CategoryRepository {

    void save(String name);

    void update(Category category);

    Category findById(int id);
}
