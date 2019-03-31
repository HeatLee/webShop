package by.bntu.fitr.justcompileit.javalabs.shop.model.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.util.JsonDeserializer;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArrayUserService implements UserService {

    public static final String USERS_FILE_NAME = "dataSource/users.json";

    public static final int OFFSET = 1;
    public static final int BEGIN_VALUE = 0;
    public static final int NUMBER_FOR_CODE = 31;

    private User[] users;
    private int size;

    public ArrayUserService() {
        users = new JsonDeserializer<User>(USERS_FILE_NAME).readArray(User[].class);
        size = this.users.length;
    }

    public ArrayUserService(User[] users) {
        this.users = users;
        this.size = users.length;
    }

    public User[] getAll() {
        return users;
    }

    public int size() {
        return size;
    }

    public boolean isExist(User user) {
        return findByUsername(user.getUsername()) != null;
    }

    public boolean save(User user) {
        if (user != null) {
            User[] newService = new User[size + OFFSET];
            System.arraycopy(users, BEGIN_VALUE, newService, BEGIN_VALUE, size);
            newService[size] = user;
            users = new User[newService.length];
            System.arraycopy(newService, BEGIN_VALUE, users, BEGIN_VALUE, newService.length);
            size = newService.length;
            return true;
        }
        return false;
    }

    public User findByUsername(String username) {
        User user = null;
        for (User user1 : users) {
            if (user1.getUsername().equals(username)) {
                user = user1;
                break;
            }
        }
        return user;
    }

    public User remove(User user) {
        User userDeleted = findByUsername(user.getUsername());
        if (userDeleted != null) {
            User[] newService = new User[size - OFFSET];
            for (int i = 0; i < size; i++) {
                if (!users[i].getUsername().equals(user.getUsername()) && i < newService.length) {
                    newService[i] = users[i];
                }
            }
            users = new User[newService.length];
            System.arraycopy(newService, BEGIN_VALUE, users, BEGIN_VALUE, newService.length);
            size = newService.length;
        }
        return userDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayUserService that = (ArrayUserService) o;
        return size == that.size &&
                Arrays.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        int result = OFFSET;
        for (User user : users) {
            result = NUMBER_FOR_CODE * result + (user == null ? BEGIN_VALUE : user.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(users);
    }
}