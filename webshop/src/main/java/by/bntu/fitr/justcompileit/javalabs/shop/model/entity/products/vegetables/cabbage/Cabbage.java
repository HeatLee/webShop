package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.cabbage;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Vegetable;

import java.util.Objects;

public class Cabbage extends Vegetable {
    private static final long serialVersionUID = 203L;

    private static final double DEFAULT_DIAMETER_VALUE = 20;
    private  static final double DEFAULT_LEAF_SIZE_VALUE = 30;

    private double diameter;
    private CabbageColor color;
    private double leafSize;

    public Cabbage() {
        super();
        this.color = CabbageColor.GREEN;
        this.diameter = DEFAULT_DIAMETER_VALUE;
        this.leafSize = DEFAULT_LEAF_SIZE_VALUE;
    }

    public Cabbage(String productName, String fileName, String countryProducer, double cost, double weight,
                   Ripeness ripeness, double diameter, CabbageColor color, double leafSize) {
        super(productName, fileName, countryProducer, cost, weight, ripeness);
        this.leafSize = leafSize;
        this.diameter = diameter;
        this.color = color;
    }

    public Cabbage(Cabbage cabbage) {
        super(cabbage);
        this.color = cabbage.color;
        this.diameter = cabbage.diameter;
        this.leafSize = cabbage.leafSize;
    }

    public double getLeafSize() {
        return leafSize;
    }

    public void setLeafSize(double leafSize) {
        this.leafSize = leafSize;
    }

    public CabbageColor getColor() {
        return color;
    }

    public void setColor(CabbageColor color) {
        this.color = color;
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
        Cabbage cabbage = (Cabbage) o;
        return Double.compare(cabbage.diameter, diameter) == 0 &&
                Double.compare(cabbage.leafSize, leafSize) == 0 &&
                color == cabbage.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diameter, color, leafSize);
    }

    @Override
    public String toString() {
        return  "\nPrice per kilogram: " + super.getCost() +
                "\nProducing country:" + super.getCountryProducer() +
                "\nRipeness: " + super.getRipeness() +
                "\nDiameter: " + diameter +
                "\nColor: " + color +
                "\nLeaf Size: " + leafSize;
    }
}
