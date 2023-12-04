import model.Category;
import model.Product;
import model.ProductDetails;
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

        Category pc = new Category("PC");
        categoryService.create(pc);

        Product keyboard = new Product("keyboard", 1);
        productService.create(keyboard);

        ProductDetails keyboard1 = new ProductDetails(1, "Logitech", 49.99, "Wireless keyboard", 10);
        ProductDetails keyboard2 = new ProductDetails(1, "Corsair", 89.99, "Mechanical gaming keyboard", 5);

        productDetailsService.create(keyboard1);
        productDetailsService.create(keyboard2);

    }
}