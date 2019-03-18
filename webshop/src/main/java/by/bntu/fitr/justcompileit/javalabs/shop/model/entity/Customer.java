package by.bntu.fitr.justcompileit.javalabs.shop.model.entity;

import by.bntu.fitr.justcompileit.javalabs.shop.container.Storable;
import by.bntu.fitr.justcompileit.javalabs.shop.container.StorageShop;

import java.util.Objects;

public class Customer extends User {

    private Storable<Product> basket;

    public Customer() {
        basket = new StorageShop<>();
    }

    public Customer(double money, String username, String password, boolean active, Storable<Product> basket) {
        super(money, username, password, active);
        this.basket = basket;
    }

    public Customer(Customer customer) {
        super(customer);
        this.basket = customer.basket;
    }

    public Storable<Product> getBasket() {
        return basket;
    }

    public void setBasket(Storable<Product> basket) {
        this.basket = basket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return basket.equals(customer.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basket);
    }

    @Override
    public String toString() {
        return "Customer:" + "basket=" + basket + ".";
    }
}
