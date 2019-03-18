package by.bntu.fitr.justcompileit.javalabs.shop.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean isExist(User user);

    int size();

    boolean save(User user);

    User remove(User user);

    User findByUsername(String username);

    User[] findAll();

}
