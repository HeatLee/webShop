package by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.carrot;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Vegetable;

import java.util.Objects;

public class Carrot extends Vegetable {

    private static final long serialVersionUID = 206L;

    private CarrotColor carrotColor;
    private CarrotForm carrotForm;

    public Carrot() {
        this.carrotColor = CarrotColor.ORANGE;
        this.carrotForm = CarrotForm.OBLONG;
    }

    public Carrot(String productName, String fileName, String countryProducer, double cost, double weight,
                  Ripeness ripeness, CarrotColor carrotColor, CarrotForm carrotForm) {
        super(productName, fileName, countryProducer, cost, weight, ripeness);
        this.carrotColor = carrotColor;
        this.carrotForm = carrotForm;
    }

    public Carrot(Carrot carrot) {
        super(carrot);
        this.carrotColor = carrot.carrotColor;
        this.carrotForm = carrot.carrotForm;
    }

    public CarrotColor getCarrotColor() {
        return carrotColor;
    }

    public void setCarrotColor(CarrotColor carrotColor) {
        this.carrotColor = carrotColor;
    }

    public CarrotForm getCarrotForm() {
        return carrotForm;
    }

    public void setCarrotForm(CarrotForm carrotForm) {
        this.carrotForm = carrotForm;
    }


    @Override
    public Product copy() {
        return new Carrot(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Carrot carrot = (Carrot) o;
        return carrotColor == carrot.carrotColor &&
                carrotForm == carrot.carrotForm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carrotColor, carrotForm);
    }

    @Override
    public String toString() {
        return "\nPrice per kilogram: " + super.getCost() + " $" +
                "\nProducing country:" + super.getCountryProducer() +
                "\nColor: " + carrotColor +
                "\nForm: " + carrotForm;
    }
}
