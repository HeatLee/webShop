package by.bntu.fitr.justcompileit.javalabs.shop.model.entity;

public class Product {

    private double price;
    private String productName;
    private int count;

    public Product() {
        price = 1;
        count = 1;
        productName = "no name";
    }

    public Product(String productName, double price, int count) {
        this.price = price;
        if (this.price < 0) {
            this.price = 1;
        }
        this.productName = productName;
        this.count = count;
        if (this.count < 0) {
            this.count = 0;
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product: " + "productName = " + productName + ", price = " + price + ", productName = " +
                productName + ", count = " + count + ".";
    }
}
