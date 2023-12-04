package service.impl;

import model.Product;
import model.ProductDetails;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository repository = new ProductRepositoryImpl();
    @Override
    public void save(Product product) {
        repository.save(product);

    }

    @Override
    public int getCountOfKey() {
        return repository.getCountOfKey();
    }

    @Override
    public int getCount() {
        return repository.getCount();
    }

    @Override
    public List<Product> getByBrand(String brand) {
        return repository.findByBrand(brand);
    }

    @Override
    public List<Product> sortByPrice() {
        return repository.sortByPrice();
    }
}
