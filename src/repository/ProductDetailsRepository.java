package repository;

import model.Category;
import model.Product;
import model.ProductDetails;

public interface ProductDetailsRepository {
    void save(ProductDetails productDetails);
    Product finddByPrice(int price);
}
