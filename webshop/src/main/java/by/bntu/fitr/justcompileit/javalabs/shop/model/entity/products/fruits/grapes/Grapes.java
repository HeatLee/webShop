package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.grapes;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;

import java.util.Objects;

public class Grapes extends Product {

    private GrapesColor grapesColor;

    public Grapes() {
        super();
        grapesColor = GrapesColor.DEFAULT_COLOR;
    }

    public Grapes(String productName, String fileName, String countryProducer, double cost, double weight, GrapesColor grapesColor) {
        super(productName, fileName, countryProducer, cost, weight);
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
        return "Grapes{" +
                "grapesColor=" + grapesColor +
                "} " + super.toString();
    }
}