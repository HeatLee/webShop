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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
                              @PathVariable String productId, Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        Product productAdded = productService.findById(Long.parseLong(productId));
        if (!user.getBasket().contains(productAdded)) {
            user.getBasket().add(productAdded);
            userService.update();
        }
        model.addAttribute("product", productAdded);
        return "product_profile";
    }

}
