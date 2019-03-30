package by.bntu.fitr.justcompileit.javalabs.shop.util;

import java.lang.reflect.Type;

public interface Serializer<T> {

    void writeArray(T[] data);
}
