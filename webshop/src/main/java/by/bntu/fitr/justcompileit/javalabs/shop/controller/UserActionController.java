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
import org.springframework.web.bind.annotation.*;

@Controller
public class UserActionController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/delete-product-{productId}")
    public String deleteProductInBasket(@AuthenticationPrincipal UserDetails userDetails,
                                        @PathVariable String productId, Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        Product productDeleted = productService.findById(Long.parseLong(productId));
        user.getBasket().delete(productDeleted);
        userService.update();
        model.addAttribute("basketProducts", user.getBasket().toArray());
        model.addAttribute("totalPrice", ShopManager.calculateTotalAmount(user));
        return "redirect:/basket";
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.POST)
    public String addToBasket(@AuthenticationPrincipal UserDetails userDetails,
                              @PathVariable String productId, @RequestParam double weight, Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        Product productAdded = productService.findById(Long.parseLong(productId)).copy();
        productAdded.setWeight(weight);
        user.getBasket().add(productAdded);
        userService.update();
        model.addAttribute("product", productAdded);
        return "product_profile_in_basket";
    }

    @PostMapping("/basket")
    public String buyProducts(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        boolean buyResult = ShopManager.buyPurchase(user);
        userService.update();
        model.addAttribute("basketProducts", user.getBasket().toArray());
        model.addAttribute("totalPrice", ShopManager.calculateTotalAmount(user));
        model.addAttribute("buyResult", buyResult);
        return "basket";
    }

    @GetMapping("/user_profile")
    public String showUserProfile(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        model.addAttribute("user", user);
        return "user_profile";
    }

    @PostMapping("/user_profile")
    public String replenishMoney(@AuthenticationPrincipal UserDetails userDetails, @RequestParam double money,
                                 Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        user.setMoney(user.getMoney() + money);
        userService.update();
        model.addAttribute("user", user);
        return "user_profile";
    }

}
