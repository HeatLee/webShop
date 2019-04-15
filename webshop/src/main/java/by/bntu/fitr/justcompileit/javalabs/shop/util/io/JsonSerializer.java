package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonSerializer<T> implements Serializer<T> {

    public static final String ERROR_OPEN_FILE = " cannot opened!";
    public static final String SUCCESSFULLY_WRITE_FILE = " successfully is written.";

    private static final Logger LOG = Logger.getLogger(JsonSerializer.class);

    private String fileName;

    public JsonSerializer(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeObjects(T data) {
        write(data, new Gson());
    }

    @Override
    public void writePolymorphicObjects(T data, Class parent, List<Class> hiers) {
        RuntimeTypeAdapterFactory<?> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory.of(parent);
        for (Class hier : hiers) {
            runtimeTypeAdapterFactory.registerSubtype(hier);
        }
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();
        write(data, gson);
    }

    private void write(T data, Gson gson) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(gson.toJson(data));
            LOG.info(fileName + SUCCESSFULLY_WRITE_FILE);
        } catch (IOException e) {
            LOG.error(fileName + ERROR_OPEN_FILE);
        }
    }
}
