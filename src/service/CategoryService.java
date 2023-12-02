package service;

import model.Category;

public interface CategoryService {

    void createCategory(String name);
    void update(Category category);
    Category getById(int id);


}
