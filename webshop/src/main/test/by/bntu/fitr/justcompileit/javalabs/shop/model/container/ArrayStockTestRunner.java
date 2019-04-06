package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.arraystock.ArrayStockInitTest;
import by.bntu.fitr.justcompileit.javalabs.shop.model.container.arraystock.ArrayStockNullTest;
import by.bntu.fitr.justcompileit.javalabs.shop.model.container.arraystock.ArrayStockTest;
import by.bntu.fitr.justcompileit.javalabs.shop.model.container.arraystock.ArrayStockZeroLengthTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ArrayStockInitTest.class,
        ArrayStockTest.class,
        ArrayStockNullTest.class,
        ArrayStockZeroLengthTest.class
})
public class ArrayStockTestRunner {
}
