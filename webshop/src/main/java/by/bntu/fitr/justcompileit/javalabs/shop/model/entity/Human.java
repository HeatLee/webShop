package by.bntu.fitr.justcompileit.javalabs.shop.model.entity;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.Stock;

import java.util.Objects;

public class Human {

    private Stock stock;

    public Human() {
    }

    public Human(Stock stock) {
        this.stock = stock;
    }

    public Human(Human human) {
        this.stock = human.stock;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(stock, human.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stock);
    }

    @Override
    public String toString() {
        return "Human{" +
                "stock=" + stock +
                '}';
    }
}
