package service.impl;

import model.ProductDetails;
import repository.ProductDetailsRepository;
import repository.impl.ProductDetailsRepositoryImpl;
import service.ProductDetailsService;

public class ProductDetailsServiceImpl implements ProductDetailsService {
    ProductDetailsRepository repository = new ProductDetailsRepositoryImpl();
    @Override
    public void createProductDetails(ProductDetails productDetails) {
        repository.save(productDetails);
    }

    @Override
    public void update(ProductDetails productDetails) {
        repository.update(productDetails);
    }

    @Override
    public ProductDetails getById(int id) {
        return repository.findById(id);
    }
}
