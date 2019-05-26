package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

public interface NativeDeserializer<T> {

    T read(String filename);
}
