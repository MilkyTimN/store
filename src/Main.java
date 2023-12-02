import model.Category;
import model.Product;
import service.CategoryService;
import service.ProductDetailsService;
import service.ProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductDetailsServiceImpl;
import service.impl.ProductServiceImpl;

public class Main {
    public static void main(String[] args) {
        CategoryService service = new CategoryServiceImpl();
        ProductService productService = new ProductServiceImpl();
        ProductDetailsService   productDetailsService = new ProductDetailsServiceImpl();
//        service.save(new Category("PC"));
//        System.out.println(service.getById(1));

//        productService.save(new Product("Acer", 1));
//        System.out.println(productService.getById(1));
//        productService.removeByUd(1);
//        productDetailsService.save();

    }

}