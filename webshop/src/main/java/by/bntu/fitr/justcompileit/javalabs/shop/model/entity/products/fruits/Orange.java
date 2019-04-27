package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Fruit;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Sweetness;

import java.util.Objects;

public class Orange extends Fruit {

    public static final double DEFAULT_DIAMETER_ORANGE = 0.0;
    public static final double DEFAULT_AMOUNT_OF_VITAMIN_C_OF_ORANGE = 0.0;

    private double diameter;
    private double amountOfVitaminC;

    public Orange() {
        super();
        diameter = DEFAULT_DIAMETER_ORANGE;
        amountOfVitaminC = DEFAULT_AMOUNT_OF_VITAMIN_C_OF_ORANGE;
    }

    public Orange(String productName, String fileName, String countryProducer, double cost, double weight,
                  Ripeness ripeness, Sweetness sweetness, double diameter, double amountOfVitaminC) {
        super(productName, fileName, countryProducer, cost, weight, ripeness, sweetness);
        this.diameter = diameter;
        this.amountOfVitaminC = amountOfVitaminC;
    }

    public Orange(Orange orange) {
        super(orange);
        this.diameter = orange.diameter;
        this.amountOfVitaminC = orange.amountOfVitaminC;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        if (diameter > DEFAULT_DIAMETER_ORANGE) {
            this.diameter = diameter;
        }
    }

    public double getAmountOfVitaminC() {
        return amountOfVitaminC;
    }

    public void setAmountOfVitaminC(double amountOfVitaminC) {
        if (amountOfVitaminC > DEFAULT_AMOUNT_OF_VITAMIN_C_OF_ORANGE) {
            this.amountOfVitaminC = amountOfVitaminC;
        }
    }

    @Override
    public Product copy() {
        return new Orange(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Orange orange = (Orange) o;
        return Double.compare(orange.diameter, diameter) == 0 &&
                Double.compare(orange.amountOfVitaminC, amountOfVitaminC) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diameter, amountOfVitaminC);
    }

    @Override
    public String toString() {
        return "price per kilogram: " + super.getCost() + " $" +
                "\nproducing country: " + super.getCountryProducer() +
                "\nvitamin C: " + amountOfVitaminC + " %" +
                "\naverage diameter: " + diameter + " mm";
    }
}
