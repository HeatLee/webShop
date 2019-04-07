package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.util.exceptions.logic.IndexOutOfBoundsContainerException;

public interface Storable<T> {

    T get(int index) throws IndexOutOfBoundsContainerException;

    T set(int index, T newElement) throws IndexOutOfBoundsContainerException;

    boolean add(T element);

    boolean addAll(T[] elements);

    boolean contains(T element);

    void clear();

    boolean delete(T element);

    T delete(int index) throws IndexOutOfBoundsContainerException;

    int size();

    int indexOf(T element);

    Object[] toArray();

    T[] toArray(T[] array);

}