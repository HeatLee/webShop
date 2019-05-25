package by.bntu.fitr.justcompileit.javalabs.shop.model.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.ArrayStock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.container.Stock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.container.UserArrayList;
import by.bntu.fitr.justcompileit.javalabs.shop.model.container.UserList;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.ShopType;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.util.MD5Hash;
import by.bntu.fitr.justcompileit.javalabs.shop.util.io.Deserializer;
import by.bntu.fitr.justcompileit.javalabs.shop.util.io.JsonDeserializer;
import by.bntu.fitr.justcompileit.javalabs.shop.util.io.JsonSerializer;

import by.bntu.fitr.justcompileit.javalabs.shop.util.io.Serializer;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceAccidence implements UserService {

    public static final String USERS_FILE_NAME = "dataSource/users.json";

    private UserList database;

    private static final Serializer<User> serializer = new JsonSerializer<>(USERS_FILE_NAME);
    private static final Deserializer<User> deserializer = new JsonDeserializer<>(USERS_FILE_NAME);

    public UserServiceAccidence() {
        this.database = new UserArrayList(deserializer.readArrayNestedObjects(
                User[].class, Stock.class, ArrayStock.class, Product.class,
                ShopType.PRODUCT.getTypes()));
    }

    public UserServiceAccidence(UserList database) {
        this.database = database;
    }

    public void setDatabase(UserList database) {
        this.database = database;
    }

    public UserList getDatabase() {
        return database;
    }

    @Override
    public boolean exists(User user) {
        return findByUsername(user.getUsername()) != null;
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        for (User userSearch : database.toArray()) {
            if (userSearch.getUsername().equals(username)) {
                user = userSearch;
                break;
            }
        }
        return user;
    }

    @Override
    public boolean save(User user) {
        boolean result = false;
        if (!exists(user) && database.add(user)) {
            user.setPassword(MD5Hash.getHash(user.getPassword()));
            update();
            result = true;
        }
        return result;
    }

    @Override
    public boolean remove(User user) {
        boolean result = false;
        if (exists(user) && database.delete(user)) {
            update();
            result = true;
        }
        return result;
    }

    @Override
    public void update() {
        serializer.writePolymorphicObjects(
                database.toArray(), Product.class, ShopType.PRODUCT.getTypes());
    }

    @Override
    public UserList findAll() {
        return getDatabase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserServiceAccidence that = (UserServiceAccidence) o;
        return database.equals(that.database);
    }

    @Override
    public int hashCode() {
        return Objects.hash(database);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("UserServiceAccidence serves users:\n");
        for (User user : database.toArray()) {
            info.append(user).append("\n");
        }
        return info.toString();
    }
}