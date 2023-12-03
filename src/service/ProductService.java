package service;

import model.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    Product getById(int id);
    void removeById(int id);
    List<Product> getAll();
    List<Product> sortAllByDescend();
    List<Product> sortAllByAscend();
    List<Product> getByBrand(String brand);
    int countOfDifferentProducts(int category);
}
