package repository;

import model.Product;

public interface ProductRepository {

    void save(Product product);
    int findQuantity(Product product);
    int findQuantityAll(Product product);
}
