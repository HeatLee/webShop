package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.exceptions.logic.IndexOutOfBoundsContainerException;
import org.springframework.stereotype.Repository;

@Repository
public interface Stock {

    Product get(int index) throws IndexOutOfBoundsContainerException;

    Product[] getAll();

    Product set(int index, Product newProduct) throws IndexOutOfBoundsContainerException;

    boolean add(Product product);

    boolean addAll(Product[] products);

    void clear();

    boolean delete(Product product);

    Product delete(int index) throws IndexOutOfBoundsContainerException;

    int size();

    int indexOf(Product product);

    boolean isContains(Product product);

    Product[] toArray(Product[] array);

}
