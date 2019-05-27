package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.potato;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Sweetness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Vegetable;

import java.util.Objects;

public class Potato extends Vegetable {

    private static final long serialVersionUID = 201L;

    private static final double DEFAULT_DIAMETR_VALUE = 7;
    private static final double DEFAULT_PERCENTAGE_VALUE = 17;

    private PotatoColor color;
    private double starchPercentage;
    private double diameter;
    private Sweetness sweetness;

    public Potato(){
        super();
        this.color = PotatoColor.BEIGE;
        this.starchPercentage = DEFAULT_PERCENTAGE_VALUE;
        this.diameter = DEFAULT_DIAMETR_VALUE;
        this.sweetness = Sweetness.LENTEN;
    }

    public Potato(String productName, String fileName, String countryProducer, double cost, double weight,
                  Ripeness ripeness, PotatoColor color, double starchPercentage, double diameter, Sweetness sweetness){
        super(productName, fileName, countryProducer, cost, weight, ripeness);
        this.color = color;
        this.starchPercentage = starchPercentage;
        this.diameter = diameter;
        this.sweetness = sweetness;
    }

    public Potato(Potato potato){
        super(potato);
        this.color = potato.color;
        this.diameter = potato.diameter;
        this.starchPercentage = potato.starchPercentage;
        this.sweetness = potato.sweetness;
    }

    public PotatoColor getColor() {
        return color;
    }

    public void setColor(PotatoColor color) {
        this.color = color;
    }

    public double getStarchPercentage() {
        return starchPercentage;
    }

    public void setStarchPercentage(double starchPercentage) {
        this.starchPercentage = starchPercentage;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public Sweetness getSweetness() {
        return sweetness;
    }

    public void setSweetness(Sweetness sweetness) {
        this.sweetness = sweetness;
    }

    @Override
    public Product copy() {
        return new Potato(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Potato potato = (Potato) o;
        return Double.compare(potato.starchPercentage, starchPercentage) == 0 &&
                Double.compare(potato.diameter, diameter) == 0 &&
                color == potato.color &&
                sweetness == potato.sweetness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, starchPercentage, diameter, sweetness);
    }

    @Override
    public String toString() {
        return  "\nPrice per kilogram: " + super.getCost() +
                "\nRipeness: " + super.getRipeness() +
                "\nProducing country:" + super.getCountryProducer() +
                "\nColor: " + color +
                "\nStarch Percentage: " + starchPercentage +
                "\nDiameter: " + diameter +
                "\nSweetness: " + sweetness;
    }
}
