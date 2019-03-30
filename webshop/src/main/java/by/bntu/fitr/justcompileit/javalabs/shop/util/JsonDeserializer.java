package by.bntu.fitr.justcompileit.javalabs.shop.util;

import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Scanner;

public class JsonDeserializer<T> implements Deserializer<T> {

    private static final Logger log = Logger.getLogger(JsonDeserializer.class);
    private static final String ERROR_OPEN_FILE = " cannot opened!";
    private static final String SUCCESSFULY_READ_FILE = " successfuly read.";

    private String fileName;

    public JsonDeserializer(String fileName) {
        this.fileName = fileName;
    }

    public T[] readArray(Type type) {
        StringBuilder data = new StringBuilder();
        T[] objects = (T[]) new Object[0];
        try (FileReader fileReader = new FileReader(fileName)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine());
            }
            objects = new Gson().fromJson(data.toString(), type);
            log.info(fileName + SUCCESSFULY_READ_FILE);
        } catch (IOException e) {
            log.error(fileName + ERROR_OPEN_FILE);
        }
        return objects;
    }
}
