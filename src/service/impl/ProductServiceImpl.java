package service.impl;

import model.Category;
import model.Product;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductServiceImpl implements ProductService {
    ProductRepository repository = new ProductRepositoryImpl();

    @Override
    public void createProduct(Product product) {
        repository.save(product);
    }

    @Override
    public void update(Product product) {
        repository.update(product);
    }

    @Override
    public Product getById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> getByPrice(String categoryName, Boolean typeSort) {
        return repository.findByPrice(categoryName, typeSort);
    }

    @Override
    public List<Product> getByBrand(String categoryName, String brand) {
        return repository.findByBrand(categoryName, brand);
    }

    @Override
    public List<String> getBrandsByCategory(String categoryName) {
        return repository.findBrands(categoryName);
    }

    @Override
    public int getQuantityByCategory(String categoryName) {
        return repository.findQuantityByCategory(categoryName);
    }


}
