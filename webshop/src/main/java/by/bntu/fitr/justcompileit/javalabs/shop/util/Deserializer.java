package by.bntu.fitr.justcompileit.javalabs.shop.util;

import java.lang.reflect.Type;

public interface Deserializer<T> {

    T[] readArray(Type type);
}
