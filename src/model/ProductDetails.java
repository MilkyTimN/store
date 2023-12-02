package model;

public class ProductDetails {
    private int id;
    private int productId;
    private String brand;
    private double price;
    private String description;
    private int quantity;

    public ProductDetails(int id, int productId, String brand, double price, String description, int quantity) {
        this.id = id;
        this.productId = productId;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public ProductDetails(int productId, String brand, double price, String description, int quantity) {
        this.productId = productId;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public ProductDetails() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\nProductDetails{" + "id=" + id + ", productId=" + productId + ", brand='" + brand + '\'' + ", price=" + price + ", description='" + description + '\'' + ", quantity=" + quantity + '}';
    }
}
