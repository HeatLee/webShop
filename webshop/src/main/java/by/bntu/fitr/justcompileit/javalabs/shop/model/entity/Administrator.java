package by.bntu.fitr.justcompileit.javalabs.shop.model.entity;

import by.bntu.fitr.justcompileit.javalabs.shop.container.Storable;
import by.bntu.fitr.justcompileit.javalabs.shop.container.StorageShop;

import java.util.Objects;

public class Administrator extends User {

    private Storable<Product> stock;
    private Storable<Customer> customerDataBase;

    public Administrator() {
        stock = new StorageShop<>();
        customerDataBase = new StorageShop<>();
    }

    public Administrator(double money, String username, String password,boolean active, Storable<Product> stock,
                         Storable<Customer> customerDataBase) {
        super(money, username, password,active);
        this.stock = stock;
        this.customerDataBase = customerDataBase;
    }

    public Administrator(Administrator administrator) {
        super(administrator);
        this.stock = administrator.stock;
        this.customerDataBase = administrator.customerDataBase;
    }

    public Storable<Product> getStock() {
        return stock;
    }

    public void setStock(Storable<Product> stock) {
        this.stock = stock;
    }

    public Storable<Customer> getCustomerDataBase() {
        return customerDataBase;
    }

    public void setCustomerDataBase(Storable<Customer> customerDataBase) {
        this.customerDataBase = customerDataBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Administrator that = (Administrator) o;
        return stock.equals(that.stock) &&
                customerDataBase.equals(that.customerDataBase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stock, customerDataBase);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

