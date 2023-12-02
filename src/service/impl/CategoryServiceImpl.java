package service.impl;

import model.Category;
import repository.CategoryRepository;
import repository.impl.CategoryRepositoryImpl;
import service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryRepository repository = new CategoryRepositoryImpl();
    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public Category getById(int id) {
        return repository.findById(id);
    }

    @Override
    public void removeById(int id) {

    }

    @Override
    public List<Category> getAll() {
        return null;
    }
}
