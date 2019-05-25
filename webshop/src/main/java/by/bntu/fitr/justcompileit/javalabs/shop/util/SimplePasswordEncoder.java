package by.bntu.fitr.justcompileit.javalabs.shop.util;

import org.springframework.security.crypto.password.PasswordEncoder;

public class SimplePasswordEncoder implements PasswordEncoder {


    private static final PasswordEncoder INSTANCE = new SimplePasswordEncoder();

    public String encode(CharSequence rawPassword) {
        return MD5Hash.getHash(rawPassword.toString());
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return MD5Hash.checkHash(rawPassword.toString(), encodedPassword);
    }

    public static PasswordEncoder getInstance() {
        return INSTANCE;
    }

    private SimplePasswordEncoder() {
    }
}
