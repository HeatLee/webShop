package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.FileWriter;
import java.io.IOException;

@EnableAutoConfiguration
public class JsonSerializer<T> implements Serializer<T> {

    public static final String ERROR_OPEN_FILE = " cannot opened!";
    public static final String SUCCESSFULLY_WRITE_FILE = " successfully is written.";

    private static final Logger log = Logger.getLogger(JsonSerializer.class);

    private String fileName;

    public JsonSerializer(String fileName) {
        this.fileName = fileName;
    }

    public void writeArray(T[] data) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(new Gson().toJson(data));
            log.info(fileName + SUCCESSFULLY_WRITE_FILE);
        } catch (IOException e) {
            log.error(fileName + ERROR_OPEN_FILE);
        }
    }
}
