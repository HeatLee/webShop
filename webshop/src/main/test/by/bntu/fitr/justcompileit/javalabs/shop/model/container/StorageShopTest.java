package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.exceptions.logic.IndexOutOfBoundsContainerException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StorageShopTest {

    @Test
    public void delete() {

        StorageShop<Integer> storageShop = new StorageShop<>(new Integer[]{1, 2, 3,
                4, 5, 6});

        System.out.println(storageShop.size());
        try {
            storageShop.delete(3);
        } catch (IndexOutOfBoundsContainerException e) {
            e.printStackTrace();
        }

        StorageShop<Integer> expected = new StorageShop<>(new Integer[]{1, 2, 4, 5, 6});
        assertEquals(expected, storageShop);
    }
}