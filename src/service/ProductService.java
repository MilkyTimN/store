package service;

import model.Product;

public interface ProductService {
    void save(Product product);
    Product getById(int id);
    void removeByUd(int id);
}
