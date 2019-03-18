package by.bntu.fitr.justcompileit.javalabs.shop.container;

public interface Storable<T> {

    Object[] toArray();

    T[] toArray(T[] array);

    int size();

    boolean contains(T elemnt);

    T set(int index, T newElement);

    boolean add(T element);

    boolean addAll(T[] elements);

    int indexOf(T element);

    boolean delete(T element);

    T delete(int index);

    void clear();

    T get(int index);

}
