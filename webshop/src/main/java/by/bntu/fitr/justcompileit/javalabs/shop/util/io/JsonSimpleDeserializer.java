package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Scanner;

public class JsonSimpleDeserializer<T> implements SimpleDeserializer<T> {

    public static final String ERROR_OPEN_FILE = " cannot opened!";
    public static final String SUCCESSFULLY_READ_FILE = " successfully read.";

    private static final Logger log = Logger.getLogger(JsonSimpleDeserializer.class);

    private String fileName;

    public JsonSimpleDeserializer(String fileName) {
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
            log.info(fileName + SUCCESSFULLY_READ_FILE);

        } catch (IOException e) {
            log.error(fileName + ERROR_OPEN_FILE);
        }
        return objects;
    }
}
