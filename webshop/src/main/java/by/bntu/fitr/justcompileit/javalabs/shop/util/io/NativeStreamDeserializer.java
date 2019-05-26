package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class NativeStreamDeserializer<T> implements NativeDeserializer<T> {


    private static final Logger LOGGER = Logger.getLogger(NativeStreamDeserializer.class);
    private static final String MESSAGE_DATA_IS_WRITTEN = "Data successfully is read";

    public NativeStreamDeserializer() {
    }

    @Override
    public T read(String filename) {
        T object = null;
        try (ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream(filename)))) {
            object = (T) stream.readObject();
            LOGGER.info(MESSAGE_DATA_IS_WRITTEN);
        } catch (IOException | ClassNotFoundException exception) {
            LOGGER.error(exception);
        }
        return object;
    }
}
