package by.bntu.fitr.justcompileit.javalabs.shop.model.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.Stock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Fruit;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Vegetable;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Stock getAll();

    boolean append(Product product);

    boolean exists(Product product);

    boolean remove(Product product);

    Product findById(Long id);

    Product[] getFruits();

    Product[] getVegetables();
}
