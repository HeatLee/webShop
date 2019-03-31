package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.exceptions.logic.IndexOutOfBoundsContainerException;

import java.util.Arrays;

public class StorageShop<T> implements Storable<T> {

    public static final String INDEX_OF_BOUND_EXCEPTION_DESCRIPTION = "Out of bound container!";

    public static final int BEGIN_VALUE = 0;
    public static final int OFFSET = 1;
    public static final int DEFAULT_INDEX = -1;
    public static final int HASH_NUM = 31;

    private Object[] repository;
    private int size;

    public StorageShop() {
        repository = new Object[BEGIN_VALUE];
        size = BEGIN_VALUE;
    }

    public StorageShop(T[] repository) {
        this.repository = Arrays.copyOf(repository, repository.length);
        this.size = repository.length;
    }

    public T get(int indexElement) throws IndexOutOfBoundsContainerException {
        if (indexElement < BEGIN_VALUE || indexElement > size) {
            throw new IndexOutOfBoundsContainerException(INDEX_OF_BOUND_EXCEPTION_DESCRIPTION);
        }
        return (T) repository[indexElement];
    }

    public T set(int index, T newElement) throws IndexOutOfBoundsContainerException {
        if (index < BEGIN_VALUE || index > size) {
            throw new IndexOutOfBoundsContainerException(INDEX_OF_BOUND_EXCEPTION_DESCRIPTION);
        }
        T element = (T) repository[index];
        repository[index] = newElement;
        return element;
    }

    public boolean add(T element) {
        if (element != null) {
            Object[] newRepository = new Object[size + OFFSET];
            System.arraycopy(repository, BEGIN_VALUE, newRepository, BEGIN_VALUE, size);
            newRepository[size] = element;
            repository = new Object[newRepository.length];
            System.arraycopy(newRepository, BEGIN_VALUE, repository, BEGIN_VALUE, newRepository.length);
            size++;
            return true;
        }
        return false;
    }

    public boolean addAll(T[] array) {
        Object[] newRepository = new Object[size + array.length];
        System.arraycopy(repository, BEGIN_VALUE, newRepository, BEGIN_VALUE, size);
        System.arraycopy(array, BEGIN_VALUE, newRepository, size, array.length);
        repository = new Object[newRepository.length];
        System.arraycopy(newRepository, BEGIN_VALUE, repository, BEGIN_VALUE, newRepository.length);
        size = newRepository.length;
        return array.length != BEGIN_VALUE;
    }

    private void belongRange(int index) throws IndexOutOfBoundsContainerException {
        if (index < BEGIN_VALUE || index > size) {
            throw new IndexOutOfBoundsContainerException(INDEX_OF_BOUND_EXCEPTION_DESCRIPTION);
        }
    }

    public boolean contains(T element) {
        return indexOf(element) > DEFAULT_INDEX;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            repository[i] = null;
        }
        size = BEGIN_VALUE;
    }

    public boolean delete(T element) {
        int indexElement = indexOf(element);
        if (indexElement > DEFAULT_INDEX) {
            Object[] newRepository = new Object[size - OFFSET];
            System.arraycopy(repository, BEGIN_VALUE, newRepository, BEGIN_VALUE, indexElement);
            System.arraycopy(repository, indexElement + OFFSET, newRepository, indexElement,
                    size - indexElement - OFFSET);
            repository = new Object[newRepository.length];
            System.arraycopy(newRepository, BEGIN_VALUE, repository, BEGIN_VALUE, newRepository.length);
            size--;
            return true;
        }
        return false;
    }

    public T delete(int indexElement) throws IndexOutOfBoundsContainerException {
        belongRange(indexElement);
        T elementDeleted = get(indexElement);
        Object[] newRepository = new Object[size - OFFSET];
        System.arraycopy(repository, BEGIN_VALUE, newRepository, BEGIN_VALUE, indexElement);
        System.arraycopy(repository, indexElement + OFFSET, newRepository, indexElement,
                size - indexElement - OFFSET);
        repository = new Object[newRepository.length];
        System.arraycopy(newRepository, BEGIN_VALUE, repository, BEGIN_VALUE, newRepository.length);
        size--;
        return elementDeleted;
    }

    public int size() {
        return size;
    }


    public int indexOf(T element) {
        int indexElement = DEFAULT_INDEX;
        for (int i = 0; i < size; i++) {
            if ((T) repository[i] == element) {
                indexElement = i;
            }
        }
        return indexElement;
    }

    public Object[] toArray() {
        return Arrays.copyOf(repository, size);
    }

    public T[] toArray(T[] array) {
        if (array.length < size) {
            return (T[]) Arrays.copyOf(repository, size, array.getClass());
        }
        System.arraycopy(repository, BEGIN_VALUE, array, BEGIN_VALUE, size);
        if (array.length > size) {
            array[size] = null;
        }
        return array;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        StorageShop<?> that = (StorageShop<?>) object;
        return Arrays.equals(repository, that.repository);
    }

    @Override
    public int hashCode() {
        int result = OFFSET;
        for (T element : (T[]) repository) {
            result = HASH_NUM * result + (element == null ? BEGIN_VALUE : element.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(repository);
    }

}