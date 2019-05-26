package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.util.exceptions.logic.IndexOutOfBoundsStockException;

import java.io.Serializable;

public interface Stock extends Serializable {

    Product get(int index) throws IndexOutOfBoundsStockException;

    Product set(int index, Product newProduct) throws IndexOutOfBoundsStockException;

    boolean add(Product product);

    boolean addAll(Product[] products);

    boolean contains(Product product);

    void clear();

    Product delete(int index) throws IndexOutOfBoundsStockException;

    boolean delete(Product product);

    int size();

    int indexOf(Product product);

    Product[] toArray();

    Product[] toArray(Product[] products);

}
