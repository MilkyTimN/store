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

        CategoryService category = new CategoryServiceImpl();
        ProductService product = new ProductServiceImpl();
        ProductDetailsService productDetails = new ProductDetailsServiceImpl();

        category.save(new Category("PC"));
        product.save(new Product("keyword", 1));
        productDetails.save(new ProductDetails(1, "Lenovo", 750.50, "ThinkPad business laptop", 10));

    }

}