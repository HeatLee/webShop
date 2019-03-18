package by.bntu.fitr.justcompileit.javalabs.shop.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface Stock {

    Product[] toArray(Product[] array);

    int size();

    boolean contains(Product product);

    Product set(int index, Product newProduct);

    boolean add(Product product);

    boolean addAll(Product[] products);

    int indexOf(Product product);

    boolean delete(Product product);

    Product delete(int index);

    void clear();

    Product get(int index);

}
