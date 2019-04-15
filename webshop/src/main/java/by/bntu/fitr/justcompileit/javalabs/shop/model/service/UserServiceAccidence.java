package by.bntu.fitr.justcompileit.javalabs.shop.model.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.ArrayStock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.container.Stock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.container.UserArrayList;
import by.bntu.fitr.justcompileit.javalabs.shop.model.container.UserList;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.util.ProductTypes;
import by.bntu.fitr.justcompileit.javalabs.shop.util.io.JsonDeserializer;
import by.bntu.fitr.justcompileit.javalabs.shop.util.io.JsonSerializer;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceAccidence implements UserService {

    public static final String USERS_FILE_NAME = "dataSource/users.json";

    private UserList database;

    public UserServiceAccidence() {
        this.database = new UserArrayList(new JsonDeserializer<User>(USERS_FILE_NAME).readArrayNestedObjects(
                User[].class, Stock.class, ArrayStock.class, Product.class,
                new ProductTypes().getProductTypes()));
    }

    public UserServiceAccidence(UserList database) {
        this.database = database;
    }

    public UserList getDatabase() {
        return database;
    }

    public void setDatabase(UserList database) {
        this.database = database;
    }

    public boolean exists(User user) {
        return findByUsername(user.getUsername()) != null;
    }

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

    public boolean save(User user) {
        boolean result = false;
        if (!exists(user) && database.add(user)) {
            update();
            result = true;
        }
        return result;
    }

    public boolean remove(User user) {
        boolean result = false;
        if (exists(user) && database.delete(user)) {
            update();
            result = true;
        }
        return result;
    }

    public void update() {
        new JsonSerializer<User[]>(USERS_FILE_NAME).writePolymorphicObjects(
                database.toArray(), Product.class, new ProductTypes().getProductTypes());
    }

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