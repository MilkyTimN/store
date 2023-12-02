import model.Category;
import model.Product;
import service.CategoryService;
import service.ProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;

public class Main {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryServiceImpl();

        categoryService.save(new Category("PC"));

    }
}