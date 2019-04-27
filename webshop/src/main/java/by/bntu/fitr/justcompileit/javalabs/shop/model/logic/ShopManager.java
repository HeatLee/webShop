package by.bntu.fitr.justcompileit.javalabs.shop.model.logic;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.Stock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Human;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.util.exceptions.logic.IndexOutOfBoundsStockException;
import org.apache.log4j.Logger;

public class ShopManager {

    public static final double DEFAULT_TOTAL_VALUE = 0.0;
    public static final String LOGGER_GET_PRODUCT = "Attempt to get product with index ";
    public static final String LOGGER_NULL_POINTER_PRODUCT_INFO = "Product has NullPointer. Index of basket: ";

    private static Logger LOGGER = Logger.getLogger(ShopManager.class);

    public static double calculateTotalAmount(Human human) {

        double totalAmount = DEFAULT_TOTAL_VALUE;
        Stock stock = human.getBasket();

        for (int i = 0; i < stock.size(); i++) {
            Product product = null;
            try {
                LOGGER.trace(LOGGER_GET_PRODUCT + i);
                product = stock.get(i);
            } catch (IndexOutOfBoundsStockException e) {
                LOGGER.error(e.getMessage());
            }

            if (product != null) {
                totalAmount += product.getCost() * product.getWeight();
            } else {
                LOGGER.warn(LOGGER_NULL_POINTER_PRODUCT_INFO + i);
            }
        }
        return totalAmount;
    }

    public static double calculateTotalWeight(Human human) {

        double totalWeight = DEFAULT_TOTAL_VALUE;
        Stock stock = human.getBasket();

        for (int i = 0; i < stock.size(); i++) {
            Product product = null;
            try {
                LOGGER.trace(LOGGER_GET_PRODUCT);
                product = stock.get(i);
            } catch (IndexOutOfBoundsStockException e) {
                LOGGER.error(e.getMessage());
            }
            if (product != null) {
                totalWeight += product.getWeight();
            } else {
                LOGGER.warn(LOGGER_NULL_POINTER_PRODUCT_INFO + i);
            }
        }
        return totalWeight;
    }

    public static boolean buyPurchase(User user) {

        boolean buyResult = false;

        double totalPrice = calculateTotalAmount(user);

        if (totalPrice < user.getMoney()) {
            user.getBasket().clear();
            user.setMoney(user.getMoney() - totalPrice);
            buyResult = true;
        }
        return buyResult;
    }
}
