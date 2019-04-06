package by.bntu.fitr.justcompileit.javalabs.shop.model.logic;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.Stock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Human;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.util.exceptions.logic.IndexOutOfBoundsStockException;

import org.apache.log4j.Logger;

public class ShopManager {

    public static final double DEFAULT_TOTAL_AMOUNT = 0.0;
    public static final String LOGGER_GET_PRODUCT_INFO = "Attempt to get product with index ";

    private static Logger logger = Logger.getLogger(ShopManager.class);

    public static double calculateTotalAmount(Human human) {

        double totalAmount = DEFAULT_TOTAL_AMOUNT;
        Stock stock = human.getBasket();

        for (int i = 0; i < stock.size(); i++) {
            Product product = null;
            try {
                logger.info(LOGGER_GET_PRODUCT_INFO + i);
                product = stock.get(i);
            } catch (IndexOutOfBoundsStockException e) {
                logger.error(e.getMessage());
            }
            if (product != null) {
                totalAmount += product.getCost();
            }
        }
        return totalAmount;
    }


    public static double calculateTotalWeight() {
        return DEFAULT_TOTAL_AMOUNT;
    }
}

