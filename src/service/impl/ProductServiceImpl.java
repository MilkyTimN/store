package service.impl;

import model.Category;
import model.Product;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

import java.util.List;

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

}
