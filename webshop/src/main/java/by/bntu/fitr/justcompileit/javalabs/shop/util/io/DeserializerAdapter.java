package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class DeserializerAdapter implements JsonDeserializer {

    private Class<?> implClass;

    public DeserializerAdapter(Class<?> c) {
        implClass = c;
    }

    @Override
    public Object deserialize(JsonElement json, Type typeOfT,
                              JsonDeserializationContext context) throws JsonParseException {
        return context.deserialize(json, implClass);
    }
}
