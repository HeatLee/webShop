package by.bntu.fitr.justcompileit.javalabs.shop.util.exceptions.crypto;

import by.bntu.fitr.justcompileit.javalabs.shop.util.exceptions.WebShopWorkException;

public class CryptoException extends WebShopWorkException {

    public CryptoException() {
    }

    public CryptoException(String msg) {
        super(msg);
    }

    public CryptoException(String message, Throwable cause) {
        super(message, cause);
    }
}
