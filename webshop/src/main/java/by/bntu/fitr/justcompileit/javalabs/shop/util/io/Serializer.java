package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

public interface Serializer<T> {

    void writeObjects(T data);

    void writePolymorphicObjects(T data, Class parent, Class[] heirs);

}
