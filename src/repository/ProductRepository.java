package repository;

import model.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product product);
    Product findById(int id);
    void removeById(int id);
    List<Product> findAll();
    List<Product> sortAllByDescend();
    List<Product> sortAllByAscend();
    List<Product> findByBrand(String brand);
    int countOfDifferentProducts(int category);


}
