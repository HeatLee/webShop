package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.kiwi;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Fruit;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Sweetness;

import java.util.Objects;

public class Kiwi extends Fruit {

    private static final long serialVersionUID = 107L;

    private KiwiColor kiwiColor;

    public Kiwi() {
        super();
        this.kiwiColor = KiwiColor.GREEN;
    }

    public Kiwi(String productName, String fileName, String countryProducer, double cost, double weight,
                Ripeness ripeness, Sweetness sweetness, KiwiColor kiwiColor) {
        super(productName, fileName, countryProducer, cost, weight, ripeness, sweetness);
        this.kiwiColor = kiwiColor;
    }

    public Kiwi(Kiwi kiwi) {
        super(kiwi);
        this.kiwiColor = kiwi.kiwiColor;
    }

    public KiwiColor getKiwiColor() {
        return kiwiColor;
    }

    public void setKiwiColor(KiwiColor kiwiColor) {
        this.kiwiColor = kiwiColor;
    }

    @Override
    public Product copy() {
        return new Kiwi(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Kiwi kiwi = (Kiwi) o;
        return kiwiColor == kiwi.kiwiColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), kiwiColor);
    }

    @Override
    public String toString() {
        return "Price per kilogram: " + super.getCost() + " $" +
                "\nProducing country: " + super.getCountryProducer() +
                "\nColor: " + kiwiColor;
    }
}

