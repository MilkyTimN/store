package service;

import model.ProductDetails;

public interface ProductDetailsService {
    void save(ProductDetails productDetails);
    int  countOfProducts(int category);
}
