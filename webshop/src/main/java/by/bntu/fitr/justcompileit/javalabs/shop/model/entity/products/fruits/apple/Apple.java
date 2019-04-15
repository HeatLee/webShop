package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.apple;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Fruit;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Sweetness;

import java.util.Objects;

public class Apple extends Fruit {

    public static final double DEFAULT_DIAMETER_VALUE = 0.0;

    private double diameter;
    private AppleColor appleColor;

    public Apple() {
        super();
        diameter = DEFAULT_DIAMETER_VALUE;
        appleColor = AppleColor.GREEN;
    }

    public Apple(String productName, String fileName, String countryProducer, double cost, double weight,
                 Ripeness ripeness, Sweetness sweetness, double diameter, AppleColor appleColor) {
        super(productName, fileName, countryProducer, cost, weight, ripeness, sweetness);
        this.diameter = diameter;
        this.appleColor = appleColor;
    }

    public Apple(Apple apple) {
        super(apple);
        this.diameter = apple.diameter;
        this.appleColor = apple.appleColor;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        if (diameter > DEFAULT_DIAMETER_VALUE) {
            this.diameter = diameter;
        }
    }

    public AppleColor getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(AppleColor appleColor) {
        this.appleColor = appleColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apple apple = (Apple) o;
        return Double.compare(apple.diameter, diameter) == 0 &&
                appleColor == apple.appleColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diameter, appleColor);
    }

    @Override
    public String toString() {
        return "price per kilogram: " + super.getCost() + " $" +
                "\nproducing country: " + super.getCountryProducer() +
                "\ncolor: " + appleColor +
                "\naverage weight: " + super.getWeight() + " g" +
                "\naverage diameter: " + diameter + " mm";
    }
}
