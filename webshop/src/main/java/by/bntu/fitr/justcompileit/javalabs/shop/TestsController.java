package by.bntu.fitr.justcompileit.javalabs.shop;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.ArrayStock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.container.Stock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.ShopType;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Bitterness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Sweetness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.cabbage.Cabbage;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.cabbage.CabbageColor;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.cucumber.Cucumber;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.cucumber.Smoothness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.onion.Onion;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.onion.OnionColor;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.potato.Potato;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.vegetables.potato.PotatoColor;
import by.bntu.fitr.justcompileit.javalabs.shop.util.io.JsonDeserializer;
import by.bntu.fitr.justcompileit.javalabs.shop.util.io.JsonSerializer;

public class TestsController {
    public static void main(String[] args) {
        Stock stock = new ArrayStock(new JsonDeserializer<Product>("dataSource/products.json").
                readArrayPolymorphicObjects(Product[].class, Product.class, ShopType.PRODUCT.getTypes()));
        stock.addAll(new Product[]{
                new Cabbage("Cabbage", "cabbage.png", "Belarus", 2.60,
                        0, Ripeness.RIPE, 20, CabbageColor.GREEN, 10),
                new Cucumber("Little Cucumber", "cucumber.png", "Russia", 2.99,
                        0, Ripeness.RIPE, 10, 2, Smoothness.GRAINY),
                new Onion("White Onion", "onion.png", "Belarus", 3.20,
                        0, Ripeness.RIPE, OnionColor.WHITE, 4, Bitterness.BITTER),
                new Potato("Potato", "potato", "Spain", 3.20, 0,
                        Ripeness.RIPE, PotatoColor.BEIGE, 17, 4.5, Sweetness.LENTEN)
        });

        new JsonSerializer<Product>("dataSource/products.json").
                writePolymorphicObjects(stock.toArray(), Product.class, ShopType.PRODUCT.getTypes());
    }
}
