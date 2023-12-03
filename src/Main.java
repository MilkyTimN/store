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
        CategoryService service = new CategoryServiceImpl();
        ProductService productService = new ProductServiceImpl();
        ProductDetails productDetails = new ProductDetails();
        ProductDetailsService   productDetailsService = new ProductDetailsServiceImpl();
//   3) Клиент должен уметь создавать Категорию, Товар и Детальную информацию о товаре
//   4) Создайте запсиь в категорию "PC", товар "Клавиатура" и несколько деталей клавиатуры на ваше усмотрение.
//        service.save(new Category("KeyBoard"));

//        productService.save(new Product("Keychron Keyboard", 2));

//        productService.removeByUd(1);

//        productDetailsService.save(new ProductDetails(4, "Keychron" , 899.99, "Keyboard", 10));

//   5) Дайте возможность клиенту искать клавиатуры по нарастающей или убывающей цене

//        System.out.println("without sort - " + productService.getAll());
//        System.out.println("with sort DESC - " + productService.sortAllByDescend());
//        System.out.println("with sort ASC - " + productService.sortAllByAscend());
//   6) Дайте возможнсть клиенту искать клавиатуры по определенному бренду

//        System.out.println(productService.getByBrand("Keychron"));

//   7) Клиент хочет занть сколько у нас есть разных клавиатур

//        System.out.println(productService.countOfDifferentProducts(1));// << 1 -это id категории, один метод для просмотра количество разных продуктов всех категорий

//   8) Админу нужно знать сколько вообще в количесте осталось клавиатур

//        System.out.println("count of keyboard " + productDetailsService.countOfProducts(2)); // << 2 -это id категории, один метод для просмотра количество всех категорий

    }

}