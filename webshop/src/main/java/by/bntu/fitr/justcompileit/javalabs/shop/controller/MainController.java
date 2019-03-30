package by.bntu.fitr.justcompileit.javalabs.shop.controller;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.Stock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import by.bntu.fitr.justcompileit.javalabs.shop.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class MainController{

    @Autowired
    private UserService userService;

    @Autowired
    private Stock stock;

    @GetMapping("/")
    public String greet(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                        Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/store")
    public String showUserList(Model model) {
        model.addAttribute("products", stock.getAll());
        return "store";
    }

    @GetMapping("/basket")
    public String showUserBasket(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("basketProducts",user.getUsername());
        return "basket";
    }

    @RequestMapping("/products/{productId}")
    public String showProductProfile(@PathVariable String productId, Model model){
        Product product = null;
        for(Product productSearch: stock.getAll()){
            if(productSearch.getId()==Integer.parseInt(productId)){
                product=productSearch;
                break;
            }
        }
        model.addAttribute("product",product);
        return "product_profile";
    }

}