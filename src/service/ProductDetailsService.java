package service;

import model.Product;
import model.ProductDetails;

public interface ProductDetailsService {
    void createProductDetails(ProductDetails productDetails);
    void update(ProductDetails productDetails);
    ProductDetails getById(int id);
}
