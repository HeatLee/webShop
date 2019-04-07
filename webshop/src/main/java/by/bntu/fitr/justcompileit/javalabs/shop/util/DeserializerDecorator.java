package by.bntu.fitr.justcompileit.javalabs.shop.util;

import by.bntu.fitr.justcompileit.javalabs.shop.util.io.Deserializer;

import java.lang.reflect.Type;

public class DeserializerDecorator implements Deserializer {

    private Deserializer wrapper;

    public DeserializerDecorator(Deserializer wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public Object[] readArray(Type type, Class interfaceName, Class interfaceImplName) {
        return new Object[0];
    }
}
