package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.banana;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Fruit;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Sweetness;

import java.util.Objects;

public class Banana extends Fruit {

    public static final double DEFAULT_BANANA_LENGTH = 0.0;

    private double length;

    public Banana() {
        super();
        this.length = DEFAULT_BANANA_LENGTH;
    }

    public Banana(String productName, String fileName, String countryProducer, double cost, double weight,
                  Ripeness ripeness, Sweetness sweetness, double length) {
        super(productName, fileName, countryProducer, cost, weight, ripeness, sweetness);
        this.length = length;
    }

    public Banana(Banana banana) {
        super(banana);
        this.length = banana.length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Banana banana = (Banana) o;
        return Double.compare(banana.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length);
    }

    @Override
    public String toString() {
        return "Banana{" +
                "length=" + length +
                "} " + super.toString();
    }
}
