package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.garlic;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Vegetable;

import java.util.Objects;

public class Garlic extends Vegetable {

    private static final long serialVersionUID = 205L;

    private GarlicSize garlicSize;

    public Garlic() {
        super();
        this.garlicSize = GarlicSize.AVERAGE;
    }

    public Garlic(String productName, String fileName, String countryProducer, double cost, double weight,
                  Ripeness ripeness, GarlicSize garlicSize) {
        super(productName, fileName, countryProducer, cost, weight, ripeness);
        this.garlicSize = garlicSize;
    }

    public Garlic(Garlic garlic) {
        super(garlic);
        this.garlicSize = garlic.garlicSize;
    }

    public GarlicSize getGarlicSize() {
        return garlicSize;
    }

    public void setGarlicSize(GarlicSize garlicSize) {
        this.garlicSize = garlicSize;
    }

    @Override
    public Product copy() {
        return new Garlic(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Garlic garlic = (Garlic) o;
        return garlicSize == garlic.garlicSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), garlicSize);
    }

    @Override
    public String toString() {
        return "\nPrice per kilogram: " + super.getCost() + " $" +
                "\nProducing country:" + super.getCountryProducer() +
                "\nSize: " + garlicSize;
    }
}

