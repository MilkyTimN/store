package model;

public class Product {
    private int id;
    private String name;
    private int categoryId;

    public Product(String name, int categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public Product(int id, String name, int categoryId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "\nProduct{" + "id=" + id + ", name='" + name + '\'' + ", categoryId=" + categoryId + '}';
    }
}
