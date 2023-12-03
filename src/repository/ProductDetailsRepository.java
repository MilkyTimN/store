package repository;

import model.ProductDetails;

public interface ProductDetailsRepository {
    void save(ProductDetails productDetails);
    int countOfProducts(int category);
}
