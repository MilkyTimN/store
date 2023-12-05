package repository.impl;

import model.Category;
import model.Product;
import model.ProductDetails;
import repository.DPHelper;
import repository.ProductDetailsRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailsRepositoryImpl implements ProductDetailsRepository {
    private DPHelper dbHelper = new DbHelperImpl();
    @Override
    public void save(ProductDetails productDetails) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "INSERT INTO Product_info ( product_id ,brand ,price, description ,quantity  )" +
                        "VALUES (?,?,?,?,?,?)")) {
            preparedStatement.setInt(2, productDetails.getProductId());
            preparedStatement.setString(3, productDetails.getBrand());
            preparedStatement.setInt(4, (int) productDetails.getPrice());
            preparedStatement.setString(5, productDetails.getDescription());
            preparedStatement.setInt(6, productDetails.getQuantity());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
        }

    }

    @Override
    public List<ProductDetails> findsorted() {
        List<ProductDetails> productDetailsList = new ArrayList<>();
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement
                ("SELECT * FROM product_info ORDER BY price ASC")){

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                ProductDetails productDetails = new ProductDetails();
                productDetails.setId(resultSet.getInt("id"));
                productDetails.setProductId(resultSet.getInt("product_id")) ;
                productDetails.setBrand(resultSet.getString("brand"));
                productDetails.setPrice(resultSet.getInt("price"));
                productDetails.setDescription(resultSet.getString("description"));
                productDetails.setQuantity(resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
        }
        return productDetailsList;
    }

    @Override
    public List<ProductDetails> findsortedMin() {
        List<ProductDetails> productDetailsList = new ArrayList<>();
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement
                ("SELECT * FROM product_info ORDER BY price DESC")){

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                ProductDetails productDetails = new ProductDetails();
                productDetails.setId(resultSet.getInt("id"));
                productDetails.setProductId(resultSet.getInt("product_id")) ;
                productDetails.setBrand(resultSet.getString("brand"));
                productDetails.setPrice(resultSet.getInt("price"));
                productDetails.setDescription(resultSet.getString("description"));
                productDetails.setQuantity(resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
        }
        return productDetailsList;
    }

    @Override
    public ProductDetails findByBrand(String brand) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement
                ("SELECT * FROM product_info WHERE brand=?")){

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                ProductDetails productDetails = new ProductDetails();
                productDetails.setId(resultSet.getInt("id"));
                productDetails.setProductId(resultSet.getInt("product_id")) ;
                productDetails.setBrand(resultSet.getString("brand"));
                productDetails.setPrice(resultSet.getInt("price"));
                productDetails.setDescription(resultSet.getString("description"));
                productDetails.setQuantity(resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
        }

        return null;
    }

}


