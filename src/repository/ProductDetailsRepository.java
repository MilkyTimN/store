package repository;

import model.Category;
import model.Product;
import model.ProductDetails;

import java.util.List;

public interface ProductDetailsRepository {
    void save(ProductDetails productDetails);
    List<ProductDetails> findsorted();
    List<ProductDetails> findsortedMin();
    ProductDetails findByBrand(String brand);

}
