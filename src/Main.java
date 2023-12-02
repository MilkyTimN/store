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


        productDetailsService.createProductDetails(new ProductDetails( 1, "Logitech", 1000.5, "The Logitech keyboard is a stylish and efficient input solution, combining a sleek design with advanced functionality. Featuring responsive keys, customizable shortcuts, and often equipped with backlighting for enhanced visibility in any environment, Logitech keyboards offer a comfortable and tailored typing experience. Known for their durability and compatibility, Logitech keyboards are a popular choice for both productivity and leisure, providing users with a reliable and stylish tool for seamless computing.", 20));

        System.out.println();
    }
}