package repository;

import model.Product;

public interface ProductRepository {
    void save(Product product);
    Product findById(int id);
    void removeById(int id);

}
