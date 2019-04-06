package by.bntu.fitr.justcompileit.javalabs.shop.model.container.arraystock;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.ArrayStock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Orange;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Pear;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Pineapple;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.apple.Apple;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.banana.Banana;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.grapes.Grapes;
import by.bntu.fitr.justcompileit.javalabs.shop.model.exceptions.logic.IndexOutOfBoundsContainerException;
import by.bntu.fitr.justcompileit.javalabs.shop.model.exceptions.logic.WebShopWorkLogicException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayStockNullTest {

    private ArrayStock stock;
    private Product[] products;

    @Before
    public void stockNullInit() {
        products = new Product[100];
        stock = new ArrayStock(products);
    }

    @Test
    public void testGetWithNormalIndex() {
        int numOfProduct = 2;

        Product actual = null;
        Product expected = products[numOfProduct];

        try {
            actual = stock.get(numOfProduct);
        } catch (IndexOutOfBoundsContainerException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPositiveOutOfBoundOfStock() {
        int numOfProduct = stock.size() + 10;
        try {
            stock.get(numOfProduct);
        } catch (WebShopWorkLogicException e) {
            assertEquals(IndexOutOfBoundsContainerException.class, e.getClass());
        }
    }

    @Test
    public void testGetNegativeOutOfBoundOfStock() {
        int numOfProduct = -1;
        try {
            stock.get(numOfProduct);
        } catch (WebShopWorkLogicException e) {
            assertEquals(IndexOutOfBoundsContainerException.class, e.getClass());
        }
    }

    @Test
    public void testGetAll() {
        Product[] actual = stock.getAll();
        Product[] expected = products;

        assertArrayEquals(actual, expected);
    }

    @Test
    public void testAdd() {

        Orange testOrange = new Orange();
        Product[] expected = Arrays.copyOf(products, products.length + 1);
        expected[expected.length - 1] = testOrange;

        stock.add(testOrange);
        assertArrayEquals(expected, stock.getAll());
    }

    @Test
    public void testAddWithNull() {
        assertFalse(stock.add(null));

    }

    @Test
    public void testAddAll() {

        Orange testOrange = new Orange();
        Banana testBanana = new Banana();
        Apple testApple = new Apple();
        Grapes testGrapes = new Grapes();
        Pineapple testPineapple = new Pineapple();

        Product[] expected = Arrays.copyOf(products, products.length + 5);

        expected[expected.length - 5] = testOrange;
        expected[expected.length - 4] = testBanana;
        expected[expected.length - 3] = testApple;
        expected[expected.length - 2] = testGrapes;
        expected[expected.length - 1] = testPineapple;

        stock.addAll(new Product[]{testOrange, testBanana, testApple, testGrapes, testPineapple});

        assertArrayEquals(expected, stock.getAll());
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllWithNull() {
        stock.addAll(null);
    }

    @Test
    public void testIsContainsGoodResult() {
        assertTrue(stock.isContains(products[0]));
    }

    @Test
    public void testIsContainsBadResult() {
        assertFalse(stock.isContains(new Pineapple()));
    }

    @Test
    public void testDeleteOfIndex() {
        int index = products.length - 2;
        Product[] expected = new Product[products.length - 1];
        System.arraycopy(products, 0, expected, 0, index);
        System.arraycopy(products, index + 1, expected, index, products.length - index - 1);

        try {
            stock.delete(index);
        } catch (IndexOutOfBoundsContainerException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expected, stock.getAll());
    }

    @Test
    public void testDeletePositiveOutOfBoundOfStock() {
        int index = products.length + 10;

        try {
            stock.delete(index);
        } catch (WebShopWorkLogicException e) {
            assertEquals(IndexOutOfBoundsContainerException.class, e.getClass());
        }
    }

    @Test
    public void testDeleteNegativeOutOfBoundOfStock() {
        int index = -1;

        try {
            stock.delete(index);
        } catch (WebShopWorkLogicException e) {
            assertEquals(IndexOutOfBoundsContainerException.class, e.getClass());
        }
    }

    @Test
    public void testDeleteByElement() {
        int index = 2;
        Product testPear = products[index];

        Product[] expected = new Product[products.length - 1];
        System.arraycopy(products, 0, expected, 0, index);
        System.arraycopy(products, index + 1, expected, index, products.length - index - 1);

        assertTrue(stock.delete(testPear));
        assertArrayEquals(expected, stock.getAll());
    }

    @Test
    public void testDeleteByNonexistentElement() {
        Pear testPear = new Pear();
        assertFalse(stock.delete(testPear));
    }

    @Test
    public void testClear() {
        stock.clear();
        assertEquals(0, stock.size());
        assertArrayEquals(null, stock.getAll());
    }

    @Test
    public void testSize() {
        assertEquals(products.length, stock.size());
    }

    @Test
    public void testIndexOf() {
        int expectedIndex = 0;

        Product actual = products[expectedIndex];

        assertEquals(expectedIndex, stock.indexOf(actual));
    }

    @Test
    public void testIndexOfNonexistentElement() {

        Orange actual = new Orange();

        assertEquals(ArrayStock.DEFAULT_INDEX, stock.indexOf(actual));
    }

    @Test
    public void testSet() {

        Banana banana = new Banana();
        int index = products.length - 2;
        products[index] = banana;

        try {
            stock.set(index, banana);
        } catch (IndexOutOfBoundsContainerException e) {
            e.printStackTrace();
        }

        Product[] actual = stock.getAll();

        assertArrayEquals(products, actual);
    }

    @Test
    public void testSetPositiveOutOfBoundOfStock() {

        Banana banana = new Banana();
        int index = products.length + 10;

        try {
            stock.set(index, banana);
        } catch (WebShopWorkLogicException e) {
            assertEquals(IndexOutOfBoundsContainerException.class, e.getClass());
        }
    }

    @Test
    public void testSetNegativeOutOfBoundOfStock() {

        Banana banana = new Banana();
        int index = -1;

        try {
            stock.set(index, banana);
        } catch (WebShopWorkLogicException e) {
            assertEquals(IndexOutOfBoundsContainerException.class, e.getClass());
        }
    }

    @Test
    public void testToArray() {
        fail();
    }

    @Test
    public void equals() {
        fail();
    }
}