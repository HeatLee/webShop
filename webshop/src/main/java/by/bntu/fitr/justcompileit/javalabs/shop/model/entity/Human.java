package by.bntu.fitr.justcompileit.javalabs.shop.model.entity;

import java.util.Objects;

public class Human {

    private double money;

    public Human() {
        money = 0;
    }

    public Human(double money) {
        this.money = money;
    }

    public Human(Human human) {
        this.money = human.money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Double.compare(human.money, money) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return "Human: " + "money = " + money + ".";
    }
}
