package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.util.exceptions.logic.IndexOutOfBoundsStockException;

public interface Stock {

    Product[] toArray();

    Product[] toArray(Product[] products);

    int size();

    boolean contains(Product product);

    Product set(int index, Product newProduct) throws IndexOutOfBoundsStockException;

    boolean add(Product product);

    boolean addAll(Product[] products);

    int indexOf(Product product);

    boolean delete(Product product);

    Product delete(int index) throws IndexOutOfBoundsStockException;

    void clear();

    Product get(int index) throws IndexOutOfBoundsStockException;

}
