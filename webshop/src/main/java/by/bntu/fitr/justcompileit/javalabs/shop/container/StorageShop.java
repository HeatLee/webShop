package by.bntu.fitr.justcompileit.javalabs.shop.container;

import java.util.Arrays;

public class StorageShop<T> implements Storable<T> {

    private static final int BEGIN_VALUE = 0;
    private static final int OFFSET = 1;
    private static final int DEFAULT_INDEX = -1;
    private static final int NUMBER_FOR_CODE = 31;

    private Object[] repository;
    private int size;

    public StorageShop() {
        this.repository = new Object[0];
        this.size = 0;
    }

    public StorageShop(T[] repository) {
        this.repository = Arrays.copyOf(repository, repository.length);
        this.size = repository.length;
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

    private void belongRange(int index) {
        if (index < BEGIN_VALUE && index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(T element) {
        return indexOf(element) > DEFAULT_INDEX;
    }

    public T set(int index, T newElement) {
        belongRange(index);
        Object element = repository[index];
        repository[index] = newElement;
        return (T) element;
    }

    public boolean add(T element) {
        if (element != null) {
            Object[] newRepository = new Object[size + OFFSET];
            System.arraycopy(repository, BEGIN_VALUE, newRepository, BEGIN_VALUE, size);
            newRepository[size] = element;
            repository = new Object[newRepository.length];
            System.arraycopy(newRepository, BEGIN_VALUE, repository, BEGIN_VALUE, newRepository.length);
            size = newRepository.length;
            return true;
        }
        return false;
    }

    public boolean addAll(T[] array) {
        ;
        Object[] newRepository = new Object[size + array.length];
        System.arraycopy(repository, BEGIN_VALUE, newRepository, BEGIN_VALUE, size);
        System.arraycopy(array, BEGIN_VALUE, newRepository, size, array.length);
        repository = new Object[newRepository.length];
        System.arraycopy(newRepository, BEGIN_VALUE, repository, BEGIN_VALUE, newRepository.length);
        size = newRepository.length;
        return array.length != BEGIN_VALUE;
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

    public boolean delete(T element) {
        int indexElement = indexOf(element);
        if (indexElement > DEFAULT_INDEX) {
            Object[] newRepository = new Object[size - OFFSET];
            System.arraycopy(repository, BEGIN_VALUE, newRepository, BEGIN_VALUE, indexElement);
            System.arraycopy(repository, indexElement + OFFSET, newRepository, indexElement,
                    size - indexElement - OFFSET);
            repository = new Object[newRepository.length];
            System.arraycopy(newRepository, BEGIN_VALUE, repository, BEGIN_VALUE, newRepository.length);
            size = newRepository.length;
            return true;
        }
        return false;
    }

    public T delete(int indexElement) {
        belongRange(indexElement);
        T elementDeleted = get(indexElement);
        Object[] newRepository = new Object[size - OFFSET];
        System.arraycopy(repository, BEGIN_VALUE, newRepository, BEGIN_VALUE, indexElement);
        System.arraycopy(repository, indexElement + OFFSET, newRepository, indexElement,
                size - indexElement - OFFSET);
        repository = new Object[newRepository.length];
        System.arraycopy(newRepository, BEGIN_VALUE, repository, BEGIN_VALUE, newRepository.length);
        size = newRepository.length;
        return elementDeleted;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            repository[i] = null;
        }
        size = BEGIN_VALUE;
    }

    public T get(int indexElement) {
        belongRange(indexElement);
        Object element = repository[indexElement];
        return (T) element;
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
            result = NUMBER_FOR_CODE * result + (element == null ? BEGIN_VALUE : element.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(repository);
    }


}
