package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class JsonSerializer<T> implements Serializer<T> {

    public static final String ERROR_OPEN_FILE = " cannot opened!";
    public static final String SUCCESSFULLY_WRITE_FILE = " successfully is written.";

    private static final Logger LOG = Logger.getLogger(JsonSerializer.class);

    private String fileName;

    public JsonSerializer(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeObjects(T[] data) {
        writeArrray(data, new Gson());
    }

    @Override
    public void writePolymorphicObjects(T[] data, Class parent, Class[] heirs) {
        RuntimeTypeAdapterFactory<?> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory.of(parent);
        for (Class hier : heirs) {
            runtimeTypeAdapterFactory.registerSubtype(hier);
        }
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();
        writeArrray(data, gson);
    }

    private void writeArrray(T[] data, Gson gson) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(gson.toJson(data));
            LOG.info(fileName + SUCCESSFULLY_WRITE_FILE);
        } catch (IOException e) {
            LOG.error(fileName + ERROR_OPEN_FILE);
        }
    }
}
