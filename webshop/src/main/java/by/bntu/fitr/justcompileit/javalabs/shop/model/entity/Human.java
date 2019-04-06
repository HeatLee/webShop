package by.bntu.fitr.justcompileit.javalabs.shop.model.entity;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.Stock;

import java.util.Objects;

public class Human {

    private Stock basket;

    public Human() {

    }

    public Human(Stock basket) {
        this.basket = basket;
    }

    public Human(Human human) {
        this.basket = human.basket;
    }

    public Stock getBasket() {
        return basket;
    }

    public void setBasket(Stock basket) {
        this.basket = basket;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return basket.equals(human.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basket);
    }

    @Override
    public String toString() {
        return "Human{" +
                "basket=" + basket +
                '}';
    }
}
