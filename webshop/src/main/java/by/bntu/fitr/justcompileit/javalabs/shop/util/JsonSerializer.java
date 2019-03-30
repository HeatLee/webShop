package by.bntu.fitr.justcompileit.javalabs.shop.util;

import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

@EnableAutoConfiguration
public class JsonSerializer<T> implements Serializer<T> {

    private static final Logger log = Logger.getLogger(JsonSerializer.class);
    private static final String ERROR_OPEN_FILE = " cannot opened!";
    private static final String SUCCESSFULY_WRITE_FILE = " successfuly is written.";

    private String fileName;

    public JsonSerializer(String fileName) {
        this.fileName = fileName;
    }

    public void writeArray(T[] data) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(new Gson().toJson(data));
            log.info(fileName + SUCCESSFULY_WRITE_FILE);
        } catch (IOException e) {
            log.error(fileName + ERROR_OPEN_FILE);
        }
    }
}
