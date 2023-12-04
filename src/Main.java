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

//        categoryService.save(new Category("Keyboard"));
//        productService.save(new Product("Varmilo",2));
//        productService.save(new Product("Logitech",2));
//        productService.save(new Product("Keychron",2));
//        productService.save(new Product("Razer",2));
//        productService.save(new Product("SteelSeries",2));
//        productService.save(new Product("HyperX",2));
//        productService.save(new Product("Asus ROG",2));

//        productDetailsService.save(new ProductDetails(3,"Lenova",5000,"with backlight",6));
//        productDetailsService.save(new ProductDetails(4,"Aser",7000,"with backlight",3));
//        productDetailsService.save(new ProductDetails(5,"Apple",10000,"with backlight",9));
//        productDetailsService.save(new ProductDetails(6,"Aser",5500,"with backlight",10));
//        productDetailsService.save(new ProductDetails(7,"Lenova",6500,"with backlight",8));
//        productDetailsService.save(new ProductDetails(8,"Asus",9500,"with backlight",4));
//        productDetailsService.save(new ProductDetails(9,"Asus",4500,"with backlight",3));
        System.out.println(productService.getCountOfKey());




    }
}