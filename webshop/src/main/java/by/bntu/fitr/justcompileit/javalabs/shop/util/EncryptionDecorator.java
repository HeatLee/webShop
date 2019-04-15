//package by.bntu.fitr.justcompileit.javalabs.shop.util;
//
//import by.bntu.fitr.justcompileit.javalabs.shop.util.exceptions.crypto.CryptoException;
//import by.bntu.fitr.justcompileit.javalabs.shop.util.io.JsonDeserializer;
//
//import java.io.File;
//import java.lang.reflect.Type;
//
//
//public class EncryptionDecorator extends JsonDeserializer {
//
//    public static final String ALGORITHM = "AES";
//    public static final String TRANSFORMATION = "AES";
//
//    public EncryptionDecorator(String fileName) {
//        super(fileName);
//    }
//
//    private void doCrypto(String key, File inputFile, File outputFile) throws CryptoException {
//
//    }
//
//    @Override
//    public Object[] readArray(Type type, Class interfaceName, Class interfaceImplName) {
//        return super.readArray(type, interfaceName, interfaceImplName);
//    }
//}