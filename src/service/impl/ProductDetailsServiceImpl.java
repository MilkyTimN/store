package service.impl;

import model.Product;
import model.ProductDetails;
import repository.ProductDetailsRepository;
import repository.impl.ProductDetailsRepositoryImpl;
import service.ProductDetailsService;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsServiceImpl implements ProductDetailsService {

    private ProductDetailsRepository repository = new ProductDetailsRepositoryImpl();

    @Override
    public void create(ProductDetails productDetails) {
        repository.save(productDetails);
    }


    @Override
    public List<ProductDetails> searchByPrice(Product product, Boolean ascOrDesc) {
        List<ProductDetails> productDetailsList = new ArrayList<>();
        if (ascOrDesc) {
            productDetailsList =  repository.findByPriceAsc(product);
        } else if (ascOrDesc == false) {
            productDetailsList = repository.findByPriceDesc(product);
        }
        return productDetailsList;
    }

    @Override
    public List<ProductDetails> searchByBrand(Product product, String brand) {
        List<ProductDetails> productDetailsList = new ArrayList<>();
        productDetailsList = repository.findByBrand(product ,brand);

        return productDetailsList;
    }
}
