package by.bntu.fitr.justcompileit.javalabs.shop.model.entity;

import java.util.Objects;

public class Product {

    private static Long amount;
    private Long id;
    private double price;
    private String fileName;
    private String name;

    static {
        amount = 1L;
    }

    {
        this.id = amount++;
    }

    public Product() {
    }

    public Product(double price, String fileName, String name) {
        this.price = price;
        this.fileName = fileName;
        this.name = name;
    }

    public Product(Product product) {
        this.price = product.price;
        this.fileName = product.fileName;
        this.name = product.name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    @Override
    public String toString() {
        return "Product{" + "price = " + price + ", fileName = " + fileName + ", name = " + name + "}";
    }
}
