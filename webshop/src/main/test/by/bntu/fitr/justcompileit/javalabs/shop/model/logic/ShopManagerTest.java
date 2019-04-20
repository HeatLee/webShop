package by.bntu.fitr.justcompileit.javalabs.shop.model.logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShopManagerTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(expected = NullPointerException.class)
    public void testCalculateTotalAmountNullPointer() {
        ShopManager.calculateTotalAmount(null);
    }

    @Test
    public void calculateTotalWeight() {
    }
}