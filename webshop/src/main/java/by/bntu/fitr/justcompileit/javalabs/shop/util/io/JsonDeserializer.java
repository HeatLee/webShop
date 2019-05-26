package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JsonDeserializer<T> implements Deserializer<T> {


    public static final String ERROR_OPEN_FILE = " cannot opened";
    public static final String SUCCESSFULLY_READ_FILE = " successfully read";

    private static final Logger LOGGER = Logger.getLogger(JsonDeserializer.class);

    private String fileName;

    public JsonDeserializer(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public T[] readArraySimpleObjects(Class<T[]> mainClass) {
        return readArray(mainClass, new Gson());
    }

    @Override
    public T[] readArrayNestedObjects(Class<T[]> mainClass, Class interfaceName, Class interfaceImplName,
                                      Class parent, Class[] heirs) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(interfaceName, new DeserializerAdapter(interfaceImplName));
        gsonBuilder.registerTypeAdapterFactory(formRuntimeTypeAdapterFactory(parent, heirs));
        return readArray(mainClass, gsonBuilder.create());
    }

    @Override
    public T[] readArrayPolymorphicObjects(Class<T[]> mainClass, Class parent, Class[] heirs) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(formRuntimeTypeAdapterFactory(parent, heirs));
        return readArray(mainClass, gsonBuilder.create());
    }

    private T[] readArray(Class<T[]> mainClass, Gson gson) {
        StringBuilder data = new StringBuilder();
        T[] objects = (T[]) new Object[0];
        try (FileReader fileReader = new FileReader(fileName)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine());
            }
            objects = gson.fromJson(data.toString(), mainClass);
            LOGGER.info(fileName + SUCCESSFULLY_READ_FILE);
        } catch (IOException e) {
            LOGGER.error(fileName + ERROR_OPEN_FILE);
        }
        return objects;
    }

    private RuntimeTypeAdapterFactory<?> formRuntimeTypeAdapterFactory(Class parent, Class[] heirs) {
        RuntimeTypeAdapterFactory<?> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory.of(parent);
        for (Class hier : heirs) {
            runtimeTypeAdapterFactory.registerSubtype(hier);
        }
        return runtimeTypeAdapterFactory;
    }
}
