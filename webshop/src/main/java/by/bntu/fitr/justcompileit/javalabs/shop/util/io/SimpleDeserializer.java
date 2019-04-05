package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

import java.lang.reflect.Type;

public interface SimpleDeserializer<T> {

    T[] readArray(Type type);
}
