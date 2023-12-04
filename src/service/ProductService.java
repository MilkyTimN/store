package service;

import model.Product;
import model.ProductDetails;

import java.util.List;

public interface ProductService {
    void save (Product product);
    List<Product> sortByPrice();
    List<Product> getByBrand(String brand);
    int  getCount();
    int getCountOfKey();

}
