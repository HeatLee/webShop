package by.bntu.fitr.justcompileit.javalabs.shop.controller;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.model.logic.ShopManager;
import by.bntu.fitr.justcompileit.javalabs.shop.model.service.ProductService;
import by.bntu.fitr.justcompileit.javalabs.shop.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String greet(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                        Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/store")
    public String showStoreShop(Model model) {
        model.addAttribute("products", productService.getAll().toArray());
        return "store";
    }

    @RequestMapping(value = "/products/{productId}")
    public String showProductProfile(@PathVariable String productId, Model model) {
        model.addAttribute("product", productService.findById(Long.parseLong(productId)));
        return "product_profile";
    }

    @GetMapping("/basket")
    public String showUserBasket(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        model.addAttribute("basketProducts", user.getBasket().toArray());
        model.addAttribute("totalPrice", ShopManager.calculateTotalAmount(user));
        return "basket";
    }
}