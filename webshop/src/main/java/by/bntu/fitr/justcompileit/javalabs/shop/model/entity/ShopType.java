package by.bntu.fitr.justcompileit.javalabs.shop.model.entity;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.banana.Banana;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.grapes.Grapes;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.kiwi.Kiwi;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.orange.Orange;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.pear.Pear;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.pineapple.Pineapple;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.apple.Apple;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.plum.Plum;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.beet.Beet;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.cabbage.Cabbage;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.carrot.Carrot;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.cucumber.Cucumber;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.garlic.Garlic;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.onion.Onion;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.potato.Potato;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.tomato.Tomato;

public enum ShopType {

    PRODUCT(new Class[]{Orange.class, Pear.class, Pineapple.class, Apple.class, Banana.class, Grapes.class, Kiwi.class,
            Plum.class, Onion.class, Potato.class, Cabbage.class, Cucumber.class, Beet.class, Carrot.class,
            Garlic.class, Tomato.class});

    private Class[] types;

    private ShopType(Class[] types) {
        this.types = types;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}
