package by.bntu.fitr.justcompileit.javalabs.shop.model.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User[] getAll();

    int size();

    boolean isExist(User user);

    User findByUsername(String username);

    User remove(User user);

    boolean save(User user);

}
