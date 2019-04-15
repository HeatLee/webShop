package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

import java.util.List;

public interface Deserializer<T> {

    T[] readArraySimpleObjects(Class<T[]> mainClass);

    T[] readArrayNestedObjects(Class<T[]> mainClass, Class interfaceName, Class interfaceImplName,
                               Class parent, List<Class> hiers);

    T[] readArrayPolimorphicObjects(Class<T[]> mainClass, Class parent, List<Class> hiers);

}
