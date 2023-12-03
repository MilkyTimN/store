package repository.impl;

import model.Category;
import model.Product;
import model.ProductDetails;
import repository.DbHelper;
import repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private DbHelper dbHelper = new DbHelperImpl();

    public void save(Product product){
        String sql = "INSERT INTO tb_product (name, categoryId) VALUES(?, ?)";
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategoryId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }

    @Override
    public Product findById(int id) {
        try {
            PreparedStatement preparedStatement = dbHelper.getPreparedStatement("SELECT * FROM tb_product WHERE id = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Product product = new Product();
            while (resultSet.next()){
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setCategoryId(resultSet.getInt("categoryId"));
            }
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeById(int id) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement("DELETE FROM tb_product WHERE id= ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println("catch");
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try(PreparedStatement preparedStatement = dbHelper.getPreparedStatement("SELECT * FROM tb_product ")){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setCategoryId(resultSet.getInt("categoryId"));
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Product> sortAllByDescend() {
        return sortAllByDescendAndAscend("select p.id, p.name, p.categoryid, pd.brand, pd.price, pd.description, pd.quantity from tb_product p join tb_productdetails pd ON pd.productid = p.id order by price desc");
    }

    @Override
    public List<Product> sortAllByAscend() {
        return sortAllByDescendAndAscend("select p.id, p.name, p.categoryid, pd.brand, pd.price, pd.description, pd.quantity from tb_product p join tb_productdetails pd ON pd.productid = p.id order by price asc");
//
    }

    private List<Product> sortAllByDescendAndAscend(String sql) {

        List<Product> productList = new ArrayList<>();
        try(PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                sql)){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setCategoryId(resultSet.getInt("categoryId"));
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findByBrand(String brand) {
        List<Product> productList = new ArrayList<>();
        try(PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "select p.id, p.name, p.categoryid, pd.brand from tb_product p join tb_productdetails pd on pd.productid = p.id where brand = ? ")){
            preparedStatement.setString(1, brand);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setCategoryId(resultSet.getInt("categoryId"));
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countOfDifferentProducts(int category) {

        try(PreparedStatement preparedStatement = dbHelper.getPreparedStatement("select distinct count(p.name) from tb_product p join tb_category c on p.categoryid = c.id where categoryid = ?;")){
            preparedStatement.setInt(1, category);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt("count");
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
