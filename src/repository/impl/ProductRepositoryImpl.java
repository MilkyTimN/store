package repository.impl;

import model.Product;
import model.ProductDetails;
import repository.DbHelper;
import repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductRepositoryImpl implements ProductRepository {
    private DbHelper dbHelper = new DbHelperImpl();

    @Override
    public List<Product> sortByPrice() {
        System.out.println("1->DESC");
        System.out.println("2->ASC");
        Scanner sc = new Scanner(System.in);
        int choos = sc.nextInt();

        switch (choos) {
            case 1:
                try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement
                        ("SELECT p.id, p.name, p.categoryid, pd.brand, pd.price, pd.description, pd.quantity FROM tb_product p\n" +
                                "join tb_productdetails pd ON pd.productid = p.id ORDER BY price DESC")) {

                    ResultSet resultSet = preparedStatement.executeQuery();
                    List<Product> sortedList = new ArrayList<>();

                    while (resultSet.next()) {
                        Product product = new Product();
                        product.setId(resultSet.getInt("id"));
                        product.setName(resultSet.getString("name"));
                        product.setCategoryId(resultSet.getInt("categoryid"));
                        sortedList.add(product);
                    }
                    return sortedList;

                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Failed to save client", e);
                }
            case 2:
                try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement
                        ("SELECT p.id, p.name, p.categoryid, pd.brand, pd.price, pd.description, pd.quantity FROM tb_product p\n" +
                                "join tb_productdetails pd ON pd.productid = p.id ORDER BY price ASC")) {

                    ResultSet resultSet = preparedStatement.executeQuery();
                    List<Product> sortedList = new ArrayList<>();

                    while (resultSet.next()) {
                        Product product = new Product();
                        product.setId(resultSet.getInt("id"));
                        product.setName(resultSet.getString("name"));
                        product.setCategoryId(resultSet.getInt("categoryid"));
                        sortedList.add(product);
                    }
                    return sortedList;

                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Failed to save client", e);
                }
        }
        return null;
    }


    @Override
    public void save(Product product) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement
                ("INSERT INTO tb_product(name,categoryID)" +
                        "VALUES(?,?)")) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategoryId());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save client", e);

        }
    }

    @Override
    public List<Product> findByBrand(String brand) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement
                ("SELECT p.id, p.name, p.categoryid, pd.brand, pd.price, pd.description, pd.quantity FROM tb_product p\n" +
                        "join tb_productdetails pd ON pd.productid = p.id WHERE brand= ?")) {
            preparedStatement.setString(1, brand);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> sortedList = new ArrayList<>();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setCategoryId(resultSet.getInt("categoryid"));
                sortedList.add(product);
            }
            return sortedList;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }

    @Override
    public int getCount() {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "SELECT COUNT(DISTINCT id) AS total_keyboards FROM tb_product")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int totalKeyboards = resultSet.getInt("total_keyboards");
                return totalKeyboards;
            } else {
                return 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to get keyboard count", e);
        }
    }

    @Override
    public int getCountOfKey() {
        try(PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "SELECT SUM(pd.quantity) AS total_keyboards_remaining\n" +
                        "FROM tb_productdetails pd\n" +
                        "JOIN tb_product p ON pd.productid = p.id;\n" )){

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int total_keyboards_remaining = resultSet.getInt("total_keyboards_remaining");
                return total_keyboards_remaining;
            } else {

                return 0;
            }

        } catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Failed to get keyboard count", e);
        }

    }
}
