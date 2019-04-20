package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

public interface Deserializer<T> {

    T[] readArraySimpleObjects(Class<T[]> mainClass);

    T[] readArrayNestedObjects(Class<T[]> mainClass, Class interfaceName, Class interfaceImplName,
                               Class parent, Class[] heirs);

    T[] readArrayPolymorphicObjects(Class<T[]> mainClass, Class parent, Class[] heirs);

}
