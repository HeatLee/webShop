package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;

import java.util.Objects;

public class Vegetable extends Product {
    private static final long serialVersionUID = 12L;

    private Ripeness ripeness;

    public Vegetable() {
        this.ripeness = Ripeness.UNRIPE;
    }

    public Vegetable(String productName, String fileName, String countryProducer, double cost, double weight,
                     Ripeness ripeness){
        super(productName, fileName, countryProducer, cost, weight);
        this.ripeness = ripeness;
    }

    public Vegetable(Vegetable vegetable){
        super(vegetable);
        this.ripeness = vegetable.ripeness;
    }

    public Ripeness getRipeness() {
        return ripeness;
    }

    public void setRipeness(Ripeness ripeness) {
        this.ripeness = ripeness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vegetable vegetable = (Vegetable) o;
        return ripeness == vegetable.ripeness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ripeness);
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "ripeness=" + ripeness +
                '}' + super.toString();
    }
}
