package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Fruit;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Sweetness;

import java.util.Objects;

public class Pear extends Fruit {

    private static final long serialVersionUID = 102L;

    public static final double DEFAULT_PEAR_DIAMETER = 0.0;

    private double diameter;

    public Pear() {
        super();
        diameter = DEFAULT_PEAR_DIAMETER;
    }

    public Pear(String productName, String fileName, String countryProducer, double cost, double weight,
                Ripeness ripeness, Sweetness sweetness, double diameter) {
        super(productName, fileName, countryProducer, cost, weight, ripeness, sweetness);
        this.diameter = diameter;
    }

    public Pear(Pear pear) {
        super(pear);
        this.diameter = pear.diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        if (diameter > DEFAULT_PEAR_DIAMETER) {
            this.diameter = diameter;
        }
    }

    @Override
    public Product copy() {
        return new Pear(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pear pear = (Pear) o;
        return Double.compare(pear.diameter, diameter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diameter);
    }

    @Override
    public String toString() {
        return "price per kilogram: " + super.getCost() + " $" +
                "\nproducing country: " + super.getCountryProducer() +
                "\naverage diameter: " + diameter + " mm";
    }
}
