package repository.impl;

import model.Category;
import model.ProductDetails;
import repository.ProductDetailsRepository;

public class ProductDetailsRepositoryImpl implements ProductDetailsRepository {
    @Override
    public void save(ProductDetails productDetails) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "INSERT INTO Category ( id, product_id ,brand ,price, description ,quantity  )" +
                        "VALUES (?,?,?,?,?,?)")) {
            preparedStatement.setInt(1, Math.toIntExact(id));
            preparedStatement.setInt(2, Math.toIntExact(product_id));
            preparedStatement.setString(3, Category.getbrand());
            preparedStatement.setInt(4, Category.getprice());
            preparedStatement.setString(5, Category.getdescription());
            preparedStatement.setString(6, Category.getquantity());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
        }

    }
}


