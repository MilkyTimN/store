package repository;

import model.Product;
import model.ProductDetails;

import java.util.List;

public interface ProductRepository {
    void save(Product product);

    List<Product> sortByPrice();

    List<Product> findByBrand(String brand);

    int getCount();

    int getCountOfKey();
}
