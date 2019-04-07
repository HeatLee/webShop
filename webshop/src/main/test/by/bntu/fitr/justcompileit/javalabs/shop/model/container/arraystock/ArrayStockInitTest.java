package by.bntu.fitr.justcompileit.javalabs.shop.model.container.arraystock;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.ArrayStock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Orange;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Pineapple;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.banana.Banana;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.grapes.Grapes;
import org.junit.After;
import org.junit.Test;

public class ArrayStockInitTest {

    private ArrayStock stock;

    @After
    public void cleaner() {
        stock = null;
    }

    @Test
    public void testStockDefaultInit() {
        stock = new ArrayStock();
    }

    @Test()
    public void testStockCopyConstructor() {
        ArrayStock arrayStock = new ArrayStock();
        stock = new ArrayStock(arrayStock);
    }

    @Test
    public void testStockProductInit() {
        stock = new ArrayStock(new Product(), new Product());
    }

    @Test
    public void testStockZeroLengthInit() {
        stock = new ArrayStock(new Product[0]);
    }

    @Test
    public void testStockNormalInit() {
        stock = new ArrayStock(new Orange(),
                new Grapes(),
                new Banana(),
                new Pineapple());
    }
}
