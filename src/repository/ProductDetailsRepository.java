package repository;

import model.ProductDetails;

public interface ProductDetailsRepository {
    void save(ProductDetails productDetails);

    void update(ProductDetails productDetails);

    ProductDetails findById(int id);
}
