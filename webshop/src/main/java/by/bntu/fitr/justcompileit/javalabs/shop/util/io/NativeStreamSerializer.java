package by.bntu.fitr.justcompileit.javalabs.shop.util.io;

import org.apache.log4j.Logger;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class NativeStreamSerializer<T> implements NativeSerializer<T> {

    private static final Logger LOGGER = Logger.getLogger(NativeStreamSerializer.class);
    private static final String MESSAGE_FILE_NOT_OPENED = " cannot opened";
    private static final String MESSAGE_DATA_IS_WRITTEN = "Data successfully is written";

    public NativeStreamSerializer() {
    }

    @Override
    public void write(T object, String filename) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream(filename)))) {
            stream.writeObject(object);
            LOGGER.info(MESSAGE_DATA_IS_WRITTEN);
        } catch (IOException exception) {
            LOGGER.error(filename + MESSAGE_FILE_NOT_OPENED);
        }
    }
}
