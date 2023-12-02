package service.impl;

import model.Category;
import repository.CategoryRepository;
import repository.impl.CategoryRepositoryImpl;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    CategoryRepository repository = new CategoryRepositoryImpl();

    @Override
    public void createCategory(String name) {
        repository.save(name);
    }

    @Override
    public void update(Category category) {
        repository.update(category);
    }

    @Override
    public Category getById(int id) {
        return repository.findById(id);
    }
}
