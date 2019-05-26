package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;

import java.util.Objects;

public class Fruit extends Product {

    private static final long serialVersionUID = 11L;

    private Ripeness ripeness;
    private Sweetness sweetness;

    public Fruit() {
        ripeness = Ripeness.UNRIPE;
        sweetness = Sweetness.SOUR;
    }

    public Fruit(String productName, String fileName, String countryProducer, double cost, double weight,
                 Ripeness ripeness, Sweetness sweetness) {
        super(productName, fileName, countryProducer, cost, weight);
        this.ripeness = ripeness;
        this.sweetness = sweetness;
    }

    public Fruit(Fruit fruit) {
        super(fruit);
        this.ripeness = fruit.ripeness;
        this.sweetness = fruit.sweetness;
    }

    public Ripeness getRipeness() {
        return ripeness;
    }

    public void setRipeness(Ripeness ripeness) {
        this.ripeness = ripeness;
    }

    public Sweetness getSweetness() {
        return sweetness;
    }

    public void setSweetness(Sweetness sweetness) {
        this.sweetness = sweetness;
    }

    @Override
    public Product copy() {
        return new Fruit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fruit fruit = (Fruit) o;
        return ripeness == fruit.ripeness &&
                sweetness == fruit.sweetness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ripeness, sweetness);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "ripeness=" + ripeness +
                ", sweetness=" + sweetness +
                "} " + super.toString();
    }

}
