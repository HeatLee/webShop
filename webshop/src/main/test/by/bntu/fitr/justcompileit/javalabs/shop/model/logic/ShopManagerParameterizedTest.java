package by.bntu.fitr.justcompileit.javalabs.shop.model.logic;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.ArrayStock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Human;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Ripeness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Sweetness;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Orange;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Pear;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Pineapple;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.apple.Apple;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.apple.AppleColor;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.grapes.Grapes;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.grapes.GrapesColor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ShopManagerParameterizedTest {

    private Human human;
    private double expectedAmount;
    private double expectedWeight;

    public ShopManagerParameterizedTest(Human human, double expectedAmount, double expectedWeight) {
        this.human = human;
        this.expectedAmount = expectedAmount;
        this.expectedWeight = expectedWeight;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {

        Product[] testProducts1 = new Product[]{new Orange("test1", "test1", "test1", 100, 100, Ripeness.UNRIPE, Sweetness.SOUR, 0.5, 0.8),
                new Apple("test1", "test1", "test1", 200, 150, Ripeness.UNRIPE, Sweetness.SOUR, 0.5, AppleColor.GREEN),
                new Pineapple("test1", "test1", "test1", 1400, 10, Ripeness.UNRIPE, Sweetness.SOUR, 0.3)};

        Product[] testProducts2 = new Product[]{new Orange("test1", "test1", "test1", 100, 100, Ripeness.UNRIPE, Sweetness.SOUR, 0.5, 0.8),
                new Apple("test1", "test1", "test1", 200, 150, Ripeness.UNRIPE, Sweetness.SOUR, 0.5, AppleColor.GREEN),
                new Pineapple("test1", "test1", "test1", 1400, 10, Ripeness.UNRIPE, Sweetness.SOUR, 0.3),
                new Grapes("test1", "test1", "test1", 8580, 10, Ripeness.UNRIPE, Sweetness.SOUR, GrapesColor.RED),
                new Pear("test1", "test1", "test1", 990, 10, Ripeness.UNRIPE, Sweetness.SOUR, 0.3),
                new Orange("test1", "test1", "test1", 10400, 10, Ripeness.UNRIPE, Sweetness.SOUR, 0.3, 0.2)};

        return Arrays.asList(new Object[][]{
                {new Human(new ArrayStock(new Orange())), Orange.DEFAULT_PRODUCT_COST, Product.DEFAULT_PRODUCT_WEIGHT},
                {new Human(new ArrayStock(testProducts1)), testProducts1[0].getCost() + testProducts1[1].getCost() +
                        testProducts1[2].getCost(), testProducts1[0].getWeight() + testProducts1[1].getWeight() +
                        testProducts1[2].getWeight()},
                {new Human(new ArrayStock(testProducts2)), testProducts2[0].getCost() + testProducts2[1].getCost() +
                        testProducts2[2].getCost() + testProducts2[3].getCost() + testProducts2[4].getCost() +
                        testProducts2[5].getCost(), testProducts2[0].getWeight() + testProducts2[1].getWeight() +
                        testProducts2[2].getWeight() + testProducts2[3].getWeight() + testProducts2[4].getWeight() +
                        testProducts2[5].getWeight()}
        });
    }

    @Test
    public void testCalculateTotalAmount() {
        double actual = ShopManager.calculateTotalAmount(human);
        assertEquals(actual, expectedAmount, 0);
    }


    @Test
    public void calculateTotalWeight() {
        double actual = ShopManager.calculateTotalWeight(human);
        assertEquals(actual, expectedWeight, 0);
    }
}