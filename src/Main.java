import service.CategoryService;
import service.ProductDetailsService;
import service.ProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductDetailsServiceImpl;
import service.impl.ProductServiceImpl;

public class Main {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryServiceImpl();
        ProductService productService = new ProductServiceImpl();
        ProductDetailsService productDetailsService = new ProductDetailsServiceImpl();

        System.out.println(productService.getQuantityByCategory("Personal Computer"));


    }
}