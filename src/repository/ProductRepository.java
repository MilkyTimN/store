package repository;

import model.Product;

import java.util.List;
import java.util.Set;

public interface ProductRepository {
    void save(Product product);

    void update(Product product);

    Product findById(int id);

    List<Product> findByPrice(String categoryName, Boolean typeSort);

    List<Product> findByBrand(String categoryName, String brand);

    List<String> findBrands(String categoryName);

    int findQuantityByCategory(String categoryName);
}
