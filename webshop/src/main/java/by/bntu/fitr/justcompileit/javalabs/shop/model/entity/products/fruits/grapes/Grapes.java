package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.grapes;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Fruit;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Sweetness;

import java.util.Objects;

public class Grapes extends Fruit {

    private GrapesColor grapesColor;

    public Grapes() {
        super();
        grapesColor = GrapesColor.RED;
    }

    public Grapes(String productName, String fileName, String countryProducer, double cost, double weight,
                  Ripeness ripeness, Sweetness sweetness, GrapesColor grapesColor) {
        super(productName, fileName, countryProducer, cost, weight, ripeness, sweetness);
        this.grapesColor = grapesColor;
    }

    public Grapes(Grapes grapes) {
        super(grapes);
        this.grapesColor = grapes.grapesColor;
    }

    public GrapesColor getGrapesColor() {
        return grapesColor;
    }

    public void setGrapesColor(GrapesColor grapesColor) {
        this.grapesColor = grapesColor;
    }

    @Override
    public Product copy() {
        return new Grapes(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Grapes grapes = (Grapes) o;
        return grapesColor == grapes.grapesColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grapesColor);
    }

    @Override
    public String toString() {
        return "price per kilogram: " + super.getCost() + " $" +
                "\nproducing country: " + super.getCountryProducer() +
                "\ncolor: " + grapesColor;
    }
}