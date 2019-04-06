package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;

import java.util.Objects;

public class Pear extends Product {

    public static final double DEFAULT_PEAR_DIAMETER = 0.0;

    private double diameter;

    public Pear() {
        super();
        diameter = DEFAULT_PEAR_DIAMETER;
    }

    public Pear(String productName, String fileName, String countryProducer, double cost, double weight, double diameter) {
        super(productName, fileName, countryProducer, cost, weight);
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
        this.diameter = diameter;
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
        return "Pear{" +
                "diameter=" + diameter +
                "} " + super.toString();
    }
}
