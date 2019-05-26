package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.onion;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Bitterness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Vegetable;

import java.util.Objects;

public class Onion extends Vegetable {

    private static final long serialVersionUID = 202L;

    private static final double DEFAULT_DIAMETER_VALUE = 9;

    private OnionColor color;
    private double diameter;
    private Bitterness bitterness;

    public Onion() {
        super();
        this.diameter = DEFAULT_DIAMETER_VALUE;
        this.color = OnionColor.WHITE;
        this.bitterness = Bitterness.BITTER;
    }

    public Onion(String productName, String fileName, String countryProducer, double cost, double weight,
                 Ripeness ripeness, OnionColor color, double diameter, Bitterness bitterness) {
        super(productName, fileName, countryProducer, cost, weight, ripeness);
        this.color = color;
        this.diameter = diameter;
        this.bitterness = bitterness;
    }

    public Onion(Onion onion) {
        super(onion);
        this.color = onion.color;
        this.bitterness = onion.bitterness;
        this.diameter = onion.diameter;
    }

    public OnionColor getColor() {
        return color;
    }

    public void setColor(OnionColor color) {
        this.color = color;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public Bitterness getBitterness() {
        return bitterness;
    }

    public void setBitterness(Bitterness bitterness) {
        this.bitterness = bitterness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Onion onion = (Onion) o;
        return Double.compare(onion.diameter, diameter) == 0 &&
                color == onion.color &&
                bitterness == onion.bitterness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, diameter, bitterness);
    }

    @Override
    public String toString() {
        return  "\nPrice per kilogram: " + super.getCost() +
                "\nProducing country:" + super.getCountryProducer() +
                "\nRipeness: " + super.getRipeness() +
                "\nColor: " + color +
                "\nDiameter: " + diameter +
                "\nSweetness: " + bitterness;
    }
}
