package service;

import model.Product;
import model.ProductDetails;

import java.util.List;

public interface ProductDetailsService {

    void create (ProductDetails productDetails);
    List<ProductDetails> searchByPrice(Product product, Boolean ascOrDesc);
}
