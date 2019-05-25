package by.bntu.fitr.justcompileit.javalabs.shop.util;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash {

    private static String HASH_ALGORITHM_MD5 = "MD5";
    private static int MAX_BYTE_VALUE_IN_HEX = 0xff;
    private static int RADIX_HEX = 16;
    private static int HEX_OFFSET = 0x100;
    private static int BEGIN_INDEX_NUMBER_IN_HEX = 1;
    private static String MESSAGE_HASH_FAILED = "Such algorithm does not exist";

    private static Logger LOGGER = Logger.getLogger(MD5Hash.class);

    public static String getHash(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(HASH_ALGORITHM_MD5);

            byte[] bytesData = messageDigest.digest(password.getBytes());

            StringBuilder hashText = new StringBuilder();
            for (byte byteData : bytesData) {
                hashText.append(Integer
                        .toString((byteData & MAX_BYTE_VALUE_IN_HEX) + HEX_OFFSET, RADIX_HEX)
                        .substring(BEGIN_INDEX_NUMBER_IN_HEX));
            }
            return hashText.toString();
        } catch (NoSuchAlgorithmException exception) {
            LOGGER.error(MESSAGE_HASH_FAILED);
            return password;
        }
    }

    public static boolean checkHash(String plaintext, String hashed) {
        return hashed.equals(getHash(plaintext));
    }
}
