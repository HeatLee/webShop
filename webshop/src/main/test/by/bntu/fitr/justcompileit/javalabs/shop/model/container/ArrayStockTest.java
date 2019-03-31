package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Orange;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Pear;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Pineapple;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.apple.Apple;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.banana.Banana;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.grapes.Grapes;
import by.bntu.fitr.justcompileit.javalabs.shop.model.exceptions.logic.IndexOutOfBoundsContainerException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayStockTest {

    private ArrayStock stock;
    private Product[] products;

    @Before
    public void stockInit() {
        products = new Product[]{new Apple(), new Banana(), new Grapes(), new Orange(), new Pear(),
                new Pineapple()};
        stock = new ArrayStock(products);
    }

    @Test
    public void testGet() {
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
    public void testGetAll() {
        Product[] actual = stock.getAll();
        Product[] expected = products;

        assertArrayEquals(actual, expected);
    }

    @Test
    public void testAdd() {

        Orange testOrange = new Orange();
        Product[] expected = Arrays.copyOf(stock.getAll(), stock.size() + 1);
        expected[expected.length - 1] = testOrange;

        stock.add(testOrange);
        assertArrayEquals(expected, stock.getAll());

    }

    @Test
    public void testAddAll() {

        Orange testOrange = new Orange();
        Banana testBanana = new Banana();
        Apple testApple = new Apple();
        Grapes testGrapes = new Grapes();
        Pineapple testPineapple = new Pineapple();

        Product[] expected = Arrays.copyOf(stock.getAll(), stock.size() + 5);

        expected[expected.length - 5] = testOrange;
        expected[expected.length - 4] = testBanana;
        expected[expected.length - 3] = testApple;
        expected[expected.length - 2] = testGrapes;
        expected[expected.length - 1] = testPineapple;

        stock.addAll(new Product[]{testOrange, testBanana, testApple, testGrapes, testPineapple});

        assertArrayEquals(expected, stock.getAll());
    }

    @Test
    public void testContainsGoodResult() {
        assertTrue(stock.contains(products[0]));
    }

    @Test
    public void testContainsBadResult() {
        assertFalse(stock.contains(new Pineapple()));
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
    public void testDeleteByElement() {
        int index = 2;
        Product testPear = products[index];

        Product[] expected = new Product[products.length - 1];
        System.arraycopy(products, 0, expected, 0, index);
        System.arraycopy(products, index + 1, expected, index, products.length - index - 1);

        stock.delete(testPear);

        assertArrayEquals(expected, stock.getAll());


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

        int expectedIndex = 3;
        Product actual = products[expectedIndex];

        assertEquals(expectedIndex, stock.indexOf(actual));
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
    public void testToArray() {
        fail();
    }

    @Test
    public void equals() {
    }

//    @Test
//    public int hashCode() {
//
//    }
//
//    @Test
//    public String toString() {
//    }
}