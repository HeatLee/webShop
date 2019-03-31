package by.bntu.fitr.justcompileit.javalabs.shop.controller;


import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Role;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.model.service.UserService;
import by.bntu.fitr.justcompileit.javalabs.shop.util.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.EnumSet;
import java.util.Map;

@Controller
public class RegistrationController {

    private static final String USERS_FILE_NAME = "dataSource/users.json";

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = userService.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(EnumSet.of(Role.USER));
        userService.save(user);
        new JsonSerializer<User>(USERS_FILE_NAME).writeArray(userService.getAll());

        return "redirect:/login";
    }
}
