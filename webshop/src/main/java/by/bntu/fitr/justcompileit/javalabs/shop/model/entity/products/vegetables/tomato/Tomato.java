package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.tomato;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Vegetable;

import java.util.Objects;

public class Tomato extends Vegetable {

    private static final long serialVersionUID = 208L;

    private TomatoColor tomatoColor;
    private TomatoForm tomatoForm;

    public Tomato() {
        super();
        this.tomatoColor = TomatoColor.RED;
        this.tomatoForm = TomatoForm.SPHERICAL;
    }

    public Tomato(String productName, String fileName, String countryProducer, double cost, double weight,
                  Ripeness ripeness, TomatoColor tomatoColor, TomatoForm tomatoForm) {
        super(productName, fileName, countryProducer, cost, weight, ripeness);
        this.tomatoColor = tomatoColor;
        this.tomatoForm = tomatoForm;
    }

    public Tomato(Tomato tomato) {
        super(tomato);
        this.tomatoColor = tomato.tomatoColor;
        this.tomatoForm = tomato.tomatoForm;
    }

    public TomatoColor getTomatoColor() {
        return tomatoColor;
    }

    public void setTomatoColor(TomatoColor tomatoColor) {
        this.tomatoColor = tomatoColor;
    }

    public TomatoForm getTomatoForm() {
        return tomatoForm;
    }

    public void setTomatoForm(TomatoForm tomatoForm) {
        this.tomatoForm = tomatoForm;
    }

    @Override
    public Product copy() {
        return new Tomato(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tomato tomato = (Tomato) o;
        return tomatoColor == tomato.tomatoColor &&
                tomatoForm == tomato.tomatoForm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tomatoColor, tomatoForm);
    }

    @Override
    public String toString() {
        return "\nPrice per kilogram: " + super.getCost() +
                "\nProducing country:" + super.getCountryProducer() +
                "\nColor: " + tomatoColor +
                "\nForm: " + tomatoForm;
    }
}
