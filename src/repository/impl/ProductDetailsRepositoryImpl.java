package repository.impl;

import model.Product;
import model.ProductDetails;
import repository.DbHelper;
import repository.ProductDetailsRepository;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailsRepositoryImpl implements ProductDetailsRepository {

    DbHelper dbHelper = new DbHelperImpl();

    @Override
    public void save(ProductDetails productDetails) {
        try(PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "INSERT INTO tb_product_details (product_id, brand, price, description, quantity) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setInt(1, productDetails.getProductId());
            preparedStatement.setString(2, productDetails.getBrand());
            preparedStatement.setDouble(3, productDetails.getPrice());
            preparedStatement.setString(4, productDetails.getDescription());
            preparedStatement.setInt(5, productDetails.getQuantity());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductDetails> findByPriceAsc(Product product) {

        List<ProductDetails> productDetailsList = new ArrayList<>();

        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "SELECT * FROM tb_product_details pd JOIN tb_product p ON p.id = pd.product_id WHERE p.id = ? ORDER BY pd.price")) {

            preparedStatement.setInt(1, product.getId());

            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();

            while(resultSet.next()) {
                ProductDetails productDetails = new ProductDetails();
                productDetails.setId(resultSet.getInt("id"));
                productDetails.setBrand(resultSet.getString("brand"));
                productDetails.setPrice(resultSet.getDouble("price"));
                productDetails.setDescription(resultSet.getString("description"));
                productDetails.setProductId(resultSet.getInt("product_id"));
                productDetails.setQuantity(resultSet.getInt("quantity"));

                productDetailsList.add(productDetails);

            }

            return productDetailsList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProductDetails> findByPriceDesc(Product product) {
        List<ProductDetails> productDetailsList = new ArrayList<>();

        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "SELECT * FROM tb_product_details pd JOIN tb_product p ON p.id = pd.product_id WHERE p.id = ? ORDER BY pd.price DESC")) {

            preparedStatement.setInt(1, product.getId());

            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ProductDetails productDetails = new ProductDetails();
                productDetails.setId(resultSet.getInt("id"));
                productDetails.setProductId(resultSet.getInt("productId"));
                productDetails.setBrand(resultSet.getString("brand"));
                productDetails.setPrice(resultSet.getDouble("price"));
                productDetails.setDescription(resultSet.getString("description"));
                productDetails.setQuantity(resultSet.getInt("quantity"));

                productDetailsList.add(productDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productDetailsList;
    }
}
