package by.bntu.fitr.justcompileit.javalabs.shop.model.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean save(User user);

    int size();

    User findByUsername(String username);

    User[] findAll();

    boolean isExist(User user);

    User remove(User user);

}
