package by.bntu.fitr.justcompileit.javalabs.shop.controller;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.model.logic.ShopManager;
import by.bntu.fitr.justcompileit.javalabs.shop.model.service.ProductService;
import by.bntu.fitr.justcompileit.javalabs.shop.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;


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

    @GetMapping("/fruits")
    public String showFruits(Model model) {
        model.addAttribute("products", productService.getFruits());
        return "fruits";
    }

    @GetMapping("/vegetables")
    public String showVegetables(Model model) {
        model.addAttribute("products",productService.getVegetables());
        return "vegetables";
    }

    @RequestMapping(value = "/products/{productId}")
    public String showProductProfile(@AuthenticationPrincipal UserDetails userDetails,
                                     @PathVariable String productId, Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        Product product = productService.findById(Long.parseLong(productId));
        model.addAttribute("product", product);
        return user.getBasket().contains(product) ? "product_profile_in_basket" : "product_profile";
    }

    @GetMapping("/basket")
    public String showUserBasket(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        model.addAttribute("basketProducts", user.getBasket().toArray());
        model.addAttribute("totalPrice", ShopManager.calculateTotalAmount(user));
        return "basket";
    }
}