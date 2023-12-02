package service;

import model.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    Category getById(int id);
    void removeById(int id);
    List<Category> getAll();
}
