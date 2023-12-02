package repository;

import model.Product;

public interface ProductRepository {
    void save(Product product);

    void update(Product product);

    Product findById(int id);
}
