package service.impl;

import model.Category;
import repository.CategoryRepository;
import repository.impl.CategoryRepositoryImpl;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    CategoryRepository repository = new CategoryRepositoryImpl();
    @Override
    public void save(Category category) {
        repository.save(category);

    }
}
