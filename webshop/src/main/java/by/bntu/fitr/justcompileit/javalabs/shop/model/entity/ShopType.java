package by.bntu.fitr.justcompileit.javalabs.shop.model.entity;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Orange;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Pear;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Pineapple;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.apple.Apple;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.cabbage.Cabbage;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.cucumber.Cucumber;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.onion.Onion;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.potato.Potato;

public enum ShopType {

    PRODUCT(new Class[]{Orange.class,Pear.class,Pineapple.class,Apple.class, Onion.class, Potato.class,
            Cabbage.class, Cucumber.class});

    private Class[] types ;

    private ShopType(Class[] types) {
        this.types=types;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}
