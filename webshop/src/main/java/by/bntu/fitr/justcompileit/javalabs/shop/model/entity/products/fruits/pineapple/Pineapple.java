package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.pineapple;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Fruit;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Sweetness;

import java.util.Objects;

public class Pineapple extends Fruit {

    private static final long serialVersionUID = 103L;

    public static final double DEFAULT_PEAR_DIAMETER = 0.0;

    private double diameter;

    public Pineapple() {
        super();
        diameter = DEFAULT_PEAR_DIAMETER;
    }

    public Pineapple(String productName, String fileName, String countryProducer, double cost, double weight,
                     Ripeness ripeness, Sweetness sweetness, double diameter) {
        super(productName, fileName, countryProducer, cost, weight, ripeness, sweetness);
        this.diameter = diameter;
    }

    public Pineapple(Pineapple pineapple) {
        super(pineapple);
        this.diameter = pineapple.diameter;
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
        return new Pineapple(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pineapple pineapple = (Pineapple) o;
        return Double.compare(pineapple.diameter, diameter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diameter);
    }

    @Override
    public String toString() {
        return "Price per kilogram: " + super.getCost() + " $" +
                "\nProducing country: " + super.getCountryProducer() +
                "\nAverage diameter: " + diameter + " mm";
    }
}
