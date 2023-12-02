package service.impl;

import model.Product;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

import java.sql.ResultSet;

public class ProductServiceImpl implements ProductService {
    ProductRepository repository = new ProductRepositoryImpl();


    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Product getById(int id) {
        return repository.findById(id);
    }

    @Override
    public void removeByUd(int id) {
        repository.removeById(id);
    }

}
