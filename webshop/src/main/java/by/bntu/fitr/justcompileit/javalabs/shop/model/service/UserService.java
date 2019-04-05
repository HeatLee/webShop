package by.bntu.fitr.justcompileit.javalabs.shop.model.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.UserList;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean exists(User user);

    boolean save(User user);

    boolean remove(User user);

    void update();

    User findByUsername(String username);

    UserList findAll();
}
