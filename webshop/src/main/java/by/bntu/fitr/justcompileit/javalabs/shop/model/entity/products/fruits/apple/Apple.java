package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.apple;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;

import java.util.Objects;

public class Apple extends Product {

    public static final double DEFAULT_DIAMETER_VALUE = 0.0;

    private double diameter;

    public Apple() {
        super();
        this.diameter = DEFAULT_DIAMETER_VALUE;
    }

    public Apple(String appleName, String imageName, String countryProducer, double cost, double weight, int diameter) {
        super(appleName, imageName, countryProducer, cost, weight);
        this.diameter = diameter;
    }

    public Apple(Apple apple) {
        super(apple);
        this.diameter = apple.diameter;
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
        Apple apple = (Apple) o;
        return Double.compare(apple.diameter, diameter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diameter);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "diameter=" + diameter +
                "} " + super.toString();
    }
}
