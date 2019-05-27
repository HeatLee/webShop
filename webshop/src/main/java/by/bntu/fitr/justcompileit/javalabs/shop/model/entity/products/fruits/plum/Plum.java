package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.plum;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Fruit;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Sweetness;

import java.util.Objects;

public class Plum extends Fruit {

    private static final long serialVersionUID = 108L;

    private PlumColor plumColor;

    public Plum() {
        super();
        this.plumColor = PlumColor.PURPLE;
    }

    public Plum(String productName, String fileName, String countryProducer, double cost, double weight,
                Ripeness ripeness, Sweetness sweetness, PlumColor plumColor) {
        super(productName, fileName, countryProducer, cost, weight, ripeness, sweetness);
        this.plumColor = plumColor;
    }

    public Plum(Plum plum) {
        super(plum);
        this.plumColor = plum.plumColor;
    }

    public PlumColor getPlumColor() {
        return plumColor;
    }

    public void setPlumColor(PlumColor plumColor) {
        this.plumColor = plumColor;
    }

    @Override
    public Product copy() {
        return new Plum(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plum plum = (Plum) o;
        return plumColor == plum.plumColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), plumColor);
    }

    @Override
    public String toString() {
        return "Price per kilogram: " + super.getCost() + " $" +
                "\nProducing country: " + super.getCountryProducer() +
                "\nColor: " + plumColor;
    }
}
