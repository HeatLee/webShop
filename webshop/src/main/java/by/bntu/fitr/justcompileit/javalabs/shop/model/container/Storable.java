package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.exceptions.logic.IndexOutOfBoundsContainerException;

public interface Storable<T> {

    T get(int index) throws IndexOutOfBoundsContainerException;

    T set(int index, T newElement) throws IndexOutOfBoundsContainerException;

    void clear();

    boolean contains(T element);

    boolean delete(T element);

    T delete(int index) throws IndexOutOfBoundsContainerException;

    int size();

    boolean add(T element);

    boolean addAll(T[] elements);

    int indexOf(T element);

    Object[] toArray();

    T[] toArray(T[] array);

}
