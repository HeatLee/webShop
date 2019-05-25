package by.bntu.fitr.justcompileit.javalabs.shop.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Copyable, Serializable {

    public static final double DEFAULT_VALUE = 0.0;
    public static final double DEFAULT_PRODUCT_COST = Double.MAX_VALUE;
    public static final double DEFAULT_PRODUCT_WEIGHT = Double.MAX_VALUE;

    public static final String DEFAULT_COUNTRY = "No country";
    public static final String DEFAULT_PRODUCT_NAME = "No name";

    private static long amount;

    static {
        amount = 1L;
    }

    private long id;
    private double cost;
    private double weight;

    private String fileName;
    private String productName;
    private String countryProducer;

    {
        this.id = amount++;
    }

    public Product() {
        cost = DEFAULT_PRODUCT_COST;
        weight = DEFAULT_PRODUCT_WEIGHT;
        productName = DEFAULT_PRODUCT_NAME;
        countryProducer = DEFAULT_COUNTRY;
    }

    public Product(String productName, String fileName, String countryProducer, double cost, double weight) {
        this.cost = cost;
        this.weight = weight;
        this.productName = productName;
        this.countryProducer = countryProducer;
        this.fileName = fileName;
    }

    public Product(Product product) {
        this.id = product.id;
        this.cost = product.cost;
        this.weight = product.weight;
        this.productName = product.productName;
        this.fileName = product.fileName;
        this.countryProducer = product.countryProducer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost > DEFAULT_VALUE) {
            this.cost = cost;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > DEFAULT_VALUE) {
            this.weight = weight;
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCountryProducer() {
        return countryProducer;
    }

    public void setCountryProducer(String countryProducer) {
        this.countryProducer = countryProducer;
    }

    @Override
    public Product copy() {
        return new Product(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.cost, cost) == 0 &&
                Double.compare(product.weight, weight) == 0 &&
                Objects.equals(fileName, product.fileName) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(countryProducer, product.countryProducer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, weight, fileName, productName, countryProducer);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", cost=" + cost +
                ", weight=" + weight +
                ", fileName='" + fileName + '\'' +
                ", productName='" + productName + '\'' +
                ", countryProducer='" + countryProducer + '\'' +
                '}';
    }
}