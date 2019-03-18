package by.bntu.fitr.justcompileit.javalabs.shop.controller;

import by.bntu.fitr.justcompileit.javalabs.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController{

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String greet(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                        Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/main")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "main";
    }
}