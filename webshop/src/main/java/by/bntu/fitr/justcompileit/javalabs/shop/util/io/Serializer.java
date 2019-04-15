package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

import java.util.List;

public interface Serializer<T> {

    void writeObjects(T data);

    void writePolymorphicObjects(T data, Class parent, List<Class> hiers);

}
