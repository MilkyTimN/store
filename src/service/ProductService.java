package service;

import model.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);
    void update(Product product);
    Product getById(int id);
    List<Product> getByPrice(String categoryName, Boolean typeSort); // price: false = increase, true = decrease
    List<Product> getByBrand(String categoryName, String brand);
    List<String> getBrandsByCategory(String categoryName);
    int getQuantityByCategory(String categoryName);

}
