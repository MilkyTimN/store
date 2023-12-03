package service.impl;

import model.ProductDetails;
import repository.ProductDetailsRepository;
import repository.impl.ProductDetailsRepositoryImpl;
import service.ProductDetailsService;

public class ProductDetailsServiceImpl implements ProductDetailsService {
    private ProductDetailsRepository repository = new ProductDetailsRepositoryImpl();
    @Override
    public void save(ProductDetails productDetails) {
        repository.save(productDetails);
    }

    @Override
    public int countOfProducts(int category) {
        return repository.countOfProducts(category);
    }
}
