package by.bntu.fitr.justcompileit.javalabs.shop.controller;

import by.bntu.fitr.justcompileit.javalabs.shop.config.RegistrationValidator;
import by.bntu.fitr.justcompileit.javalabs.shop.model.container.ArrayStock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Role;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.model.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.EnumSet;

@Controller
public class AuthenticationController {

    private static final Logger LOGGER = Logger.getLogger(AuthenticationController.class);
    private static final String INVALID_REGISTRATION_DATA_MESSAGE = "Invalid registration data.";
    private static final String INVALID_USERNAME_OR_PASSWORD_MESSAGE = "Invalid username or password.";


    @Value("${InvalidData}")
    private String invalidData;

    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationValidator registrationValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        registrationValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            LOGGER.warn(INVALID_REGISTRATION_DATA_MESSAGE);
            return "registration";
        }
        User user = new User(userForm);
        user.setActive(true);
        user.setRoles(EnumSet.of(Role.USER));
        user.setBasket(new ArrayStock(new Product[0]));
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model, String error) {
        if (error != null) {
            LOGGER.warn(INVALID_USERNAME_OR_PASSWORD_MESSAGE);
            model.addAttribute("error", invalidData);
        }
        return "login";
    }

}
