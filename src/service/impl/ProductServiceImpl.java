package service.impl;

import model.Product;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

public class ProductServiceImpl implements ProductService {

    private ProductRepository repository = new ProductRepositoryImpl();

    @Override
    public void create(Product product) {
        repository.save(product);
    }

}
