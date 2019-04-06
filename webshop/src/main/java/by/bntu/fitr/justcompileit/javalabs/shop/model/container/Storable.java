package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.util.exceptions.logic.IndexOutOfBoundsContainerException;

public interface Storable<T> {

    Object[] toArray();

    T[] toArray(T[] array);

    boolean contains(T element);

    T set(int index, T newElement) throws IndexOutOfBoundsContainerException;

    int size();

    boolean add(T element);

    boolean addAll(T[] elements);

    int indexOf(T element);

    boolean delete(T element);

    T delete(int index) throws IndexOutOfBoundsContainerException;

    void clear();

    T get(int index) throws IndexOutOfBoundsContainerException;

}
