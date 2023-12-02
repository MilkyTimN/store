package repository;

import model.Product;
import model.ProductDetails;

import java.util.List;

public interface ProductDetailsRepository {

    void save(ProductDetails productDetails);
    List<ProductDetails> findByPriceAsc(Product product);
    List<ProductDetails> findByPriceDesc(Product product);
}
