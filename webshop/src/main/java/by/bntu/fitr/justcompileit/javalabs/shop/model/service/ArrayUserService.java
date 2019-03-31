package by.bntu.fitr.justcompileit.javalabs.shop.model.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.util.JsonDeserializer;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArrayUserService implements UserService {

    private static final String USERS_FILE_NAME = "dataSource/users.json";

    private static final int OFFSET = 1;
    private static final int BEGIN_VALUE = 0;
    private static final int NUMBER_FOR_CODE = 31;

    private User[] service;
    private int size;

    public ArrayUserService() {
        service = new JsonDeserializer<User>(USERS_FILE_NAME).readArray(User[].class);
        size = this.service.length;
    }

    public ArrayUserService(User[] service) {
        this.service = service;
        this.size = service.length;
    }

    public int size() {
        return size;
    }

    public User[] findAll() {
        return service;
    }

    public boolean isExist(User user) {
        return findByUsername(user.getUsername()) != null;
    }

    public boolean save(User user) {
        if (user != null) {
            User[] newService = new User[size + OFFSET];
            System.arraycopy(service, BEGIN_VALUE, newService, BEGIN_VALUE, size);
            newService[size] = user;
            service = new User[newService.length];
            System.arraycopy(newService, BEGIN_VALUE, service, BEGIN_VALUE, newService.length);
            size = newService.length;
            return true;
        }
        return false;
    }

    public User remove(User user) {
        User userDeleted = findByUsername(user.getUsername());
        if (userDeleted != null) {
            User[] newService = new User[size - OFFSET];
            for (int i = 0; i < size; i++) {
                if (!service[i].getUsername().equals(user.getUsername()) && i < newService.length) {
                    newService[i] = service[i];
                }
            }
            service = new User[newService.length];
            System.arraycopy(newService, BEGIN_VALUE, service, BEGIN_VALUE, newService.length);
            size = newService.length;
        }
        return userDeleted;
    }

    public User findByUsername(String username) {
        User user = null;
        for (User user1 : service) {
            if (user1.getUsername().equals(username)) {
                user = user1;
                break;
            }
        }
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayUserService that = (ArrayUserService) o;
        return size == that.size &&
                Arrays.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        int result = OFFSET;
        for (User user : service) {
            result = NUMBER_FOR_CODE * result + (user == null ? BEGIN_VALUE : user.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(service);
    }
}