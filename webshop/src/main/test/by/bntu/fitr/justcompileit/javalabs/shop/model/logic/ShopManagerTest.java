package by.bntu.fitr.justcompileit.javalabs.shop.model.logic;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.ArrayStock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Human;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Orange;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ShopManagerTest {

    private Human human;
    private double expectedAmount;

    public ShopManagerTest(Human human, double expectedAmount) {
        this.human = human;
        this.expectedAmount = expectedAmount;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {new Human(new ArrayStock(new Product[]{
                        new Orange()})), Orange.DEFAULT_PRODUCT_COST}
        });
    }

    @Test
    public void testCalculateTotalAmount() {
        double actual = ShopManager.calculateTotalAmount(human);
        assertEquals(actual, expectedAmount, 0);
    }
}