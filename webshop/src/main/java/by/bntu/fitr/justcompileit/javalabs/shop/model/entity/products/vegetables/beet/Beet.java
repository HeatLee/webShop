package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.beet;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Vegetable;

import java.util.Objects;

public class Beet extends Vegetable {

    private static final long serialVersionUID = 207L;

    private BeetColor beetColor;
    private BeetSweetness beetSweetness;

    public Beet() {
        this.beetColor = BeetColor.PURPLE;
        this.beetSweetness = BeetSweetness.SAVORY;
    }

    public Beet(String productName, String fileName, String countryProducer, double cost, double weight,
                Ripeness ripeness, BeetColor beetColor, BeetSweetness beetSweetness) {
        super(productName, fileName, countryProducer, cost, weight, ripeness);
        this.beetColor = beetColor;
        this.beetSweetness = beetSweetness;
    }

    public Beet(Beet beet) {
        super(beet);
        this.beetColor = beet.beetColor;
        this.beetSweetness = beet.beetSweetness;
    }

    public BeetColor getBeetColor() {
        return beetColor;
    }

    public void setBeetColor(BeetColor beetColor) {
        this.beetColor = beetColor;
    }

    public BeetSweetness getBeetSweetness() {
        return beetSweetness;
    }

    public void setBeetSweetness(BeetSweetness beetSweetness) {
        this.beetSweetness = beetSweetness;
    }

    @Override
    public Product copy() {
        return new Beet(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Beet beet = (Beet) o;
        return beetColor == beet.beetColor &&
                beetSweetness == beet.beetSweetness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), beetColor, beetSweetness);
    }

    @Override
    public String toString() {
        return "\nPrice per kilogram: " + super.getCost() + " $" +
                "\nProducing country:" + super.getCountryProducer() +
                "\nColor: " + beetColor +
                "\nSweetness: " + beetSweetness;
    }
}
