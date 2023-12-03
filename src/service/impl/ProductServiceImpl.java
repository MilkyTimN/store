package service.impl;

import model.Product;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

import java.sql.ResultSet;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository repository = new ProductRepositoryImpl();


    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Product getById(int id) {
        return repository.findById(id);
    }

    @Override
    public void removeById(int id) {
        repository.removeById(id);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> sortAllByDescend() {
        return repository.sortAllByDescend();
    }

    @Override
    public List<Product> sortAllByAscend() {
        return repository.sortAllByAscend();
    }

    @Override
    public List<Product> getByBrand(String brand) {
        return repository.findByBrand(brand);
    }

    @Override
    public int countOfDifferentProducts(int category) {
        return repository.countOfDifferentProducts(category);
    }

}
