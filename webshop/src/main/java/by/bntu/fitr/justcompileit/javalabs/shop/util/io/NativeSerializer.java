package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

public interface NativeSerializer<T> {

    void write(T object, String filename);

}
