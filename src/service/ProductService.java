package service;

import model.Product;

public interface ProductService {

    void create(Product product);
    int getQuantity(Product product);
    int getQuantityAll(Product product);
}
