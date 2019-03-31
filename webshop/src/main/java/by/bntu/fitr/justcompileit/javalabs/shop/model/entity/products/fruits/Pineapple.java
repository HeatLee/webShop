package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;

import java.util.Objects;

public class Pineapple extends Product {

    public static final double DEFAULT_PEAR_DIAMETER = 0.0;

    private double diameter;

    public Pineapple() {
        super();
        diameter = DEFAULT_PEAR_DIAMETER;
    }

    public Pineapple(String productName, String fileName, String countryProducer, double cost, double weight, double diameter) {
        super(productName, fileName, countryProducer, cost, weight);
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
        this.diameter = diameter;
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
        return "Pineapple{" +
                "diameter=" + diameter +
                "} " + super.toString();
    }
}
