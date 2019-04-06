package by.bntu.fitr.justcompileit.javalabs.shop.model.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.Stock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    boolean exists(Product product);

    boolean append(Product product);

    boolean remove(Product product);

    Product findById(Long id);

    Stock getAll();

}
