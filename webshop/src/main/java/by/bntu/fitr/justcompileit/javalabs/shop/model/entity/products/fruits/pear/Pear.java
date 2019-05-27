package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.pear;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Fruit;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Sweetness;

import java.util.Objects;

public class Pear extends Fruit {

    private static final long serialVersionUID = 102L;

    private PearForm pearForm;

    public Pear() {
        super();
        this.pearForm = PearForm.OBLONG;
    }

    public Pear(String productName, String fileName, String countryProducer, double cost, double weight,
                Ripeness ripeness, Sweetness sweetness, PearForm pearForm) {
        super(productName, fileName, countryProducer, cost, weight, ripeness, sweetness);
        this.pearForm = pearForm;
    }

    public Pear(Pear pear) {
        super(pear);
        this.pearForm = pear.pearForm;
    }

    public PearForm getPearForm() {
        return pearForm;
    }

    public void setPearForm(PearForm pearForm) {
        this.pearForm = pearForm;
    }

    @Override
    public Product copy() {
        return new Pear(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pear pear = (Pear) o;
        return pearForm == pear.pearForm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pearForm);
    }

    @Override
    public String toString() {
        return "Price per kilogram: " + super.getCost() + " $" +
                "\nProducing country: " + super.getCountryProducer() +
                "\nForm: " + pearForm;
    }
}
