package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.cucumber;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Vegetable;

import java.util.Objects;

public class Cucumber extends Vegetable {

    private static final long serialVersionUID = 203L;

    private static final double DEFAULT_LENGTH_VALUE = 10;
    private static final double DEFAULT_THICKNESS_VALUE = 2;

    private double length;
    private double thickness;
    private Smoothness smoothness;

    public Cucumber() {
        super();
        this.length = DEFAULT_LENGTH_VALUE;
        this.smoothness = Smoothness.GRAINY;
        this.thickness = DEFAULT_THICKNESS_VALUE;
    }

    public Cucumber(String productName, String fileName, String countryProducer, double cost, double weight,
                    Ripeness ripeness, double length, double thickness, Smoothness smoothness) {
        super(productName, fileName, countryProducer, cost, weight, ripeness);
        this.length = length;
        this.thickness = thickness;
        this.smoothness = smoothness;
    }

    public Cucumber(Cucumber cucumber) {
        super(cucumber);
        this.thickness = cucumber.thickness;
        this.smoothness = cucumber.smoothness;
        this.length = cucumber.length;
    }

    public Smoothness getSmoothness() {
        return smoothness;
    }

    public void setSmoothness(Smoothness smoothness) {
        this.smoothness = smoothness;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public Product copy() {
        return new Cucumber(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cucumber cucumber = (Cucumber) o;
        return Double.compare(cucumber.length, length) == 0 &&
                Double.compare(cucumber.thickness, thickness) == 0 &&
                smoothness == cucumber.smoothness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length, thickness, smoothness);
    }

    @Override
    public String toString() {
        return "\nPrice per kilogram: " + super.getCost() + " $" +
                "\nProducing country:" + super.getCountryProducer() +
                "\nLength: " + length + " mm" +
                "\nThickness: " + thickness + " mm" +
                "\nSmoothness: " + smoothness;
    }
}
