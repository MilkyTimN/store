package service;

import model.Category;
import model.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);
    void update(Product product);
    Product getById(int id);
}
