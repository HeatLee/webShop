package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.util.exceptions.logic.IndexOutOfBoundsStockException;

import java.util.Arrays;

public class ArrayStock implements Stock {

    private static final int BEGIN_VALUE = 0;
    private static final int OFFSET = 1;
    private static final int DEFAULT_INDEX = -1;
    private static final int NUMBER_FOR_CODE = 31;
    private static final String EXCEPTION_DESCRIBE = "Out of bound stock!";

    private Product[] ambry;
    private int size;

    public ArrayStock() {
        this.ambry = new Product[0];
        this.size = this.ambry.length;
    }

    public ArrayStock(Product[] products) {
        this.ambry = Arrays.copyOf(products, products.length);
        this.size = products.length;
    }

    public Product[] toArray() {
        return Arrays.copyOf(ambry, size);
    }

    public Product[] toArray(Product[] products) {
        if (products.length < size) {
            return (Product[]) Arrays.copyOf(ambry, size, products.getClass());
        }
        System.arraycopy(ambry, BEGIN_VALUE, products, BEGIN_VALUE, size);
        if (products.length > size) {
            products[size] = null;
        }
        return products;
    }

    private void belongRange(int index) throws IndexOutOfBoundsStockException {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsStockException(EXCEPTION_DESCRIBE);
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(Product product) {
        return indexOf(product) > DEFAULT_INDEX;
    }

    public Product set(int index, Product newProduct) throws IndexOutOfBoundsStockException {
        belongRange(index);
        Product product = ambry[index];
        ambry[index] = newProduct;
        return product;
    }

    public boolean add(Product product) {
        if (product != null) {
            Product[] newAmbry = new Product[size + OFFSET];
            System.arraycopy(ambry, BEGIN_VALUE, newAmbry, BEGIN_VALUE, size);
            newAmbry[size] = product;
            ambry = new Product[newAmbry.length];
            System.arraycopy(newAmbry, BEGIN_VALUE, ambry, BEGIN_VALUE, newAmbry.length);
            size = newAmbry.length;
            return true;
        }
        return false;
    }

    public boolean addAll(Product[] products) {
        Product[] newAmbry = new Product[size + products.length];
        System.arraycopy(ambry, BEGIN_VALUE, newAmbry, BEGIN_VALUE, size);
        System.arraycopy(products, BEGIN_VALUE, newAmbry, size, products.length);
        ambry = new Product[newAmbry.length];
        System.arraycopy(newAmbry, BEGIN_VALUE, ambry, BEGIN_VALUE, newAmbry.length);
        size = newAmbry.length;
        return products.length != BEGIN_VALUE;
    }

    public int indexOf(Product product) {
        int indexProduct = DEFAULT_INDEX;
        for (int i = 0; i < size; i++) {
            if (ambry[i] == product) {
                indexProduct = i;
            }
        }
        return indexProduct;
    }

    private void deleteMain(int indexProduct) {
        Product[] newAmbry = new Product[size - OFFSET];
        System.arraycopy(ambry, BEGIN_VALUE, newAmbry, BEGIN_VALUE, indexProduct);
        System.arraycopy(ambry, indexProduct + OFFSET, newAmbry, indexProduct,
                size - indexProduct - OFFSET);
        ambry = new Product[newAmbry.length];
        System.arraycopy(newAmbry, BEGIN_VALUE, ambry, BEGIN_VALUE, newAmbry.length);
        size = newAmbry.length;
    }

    public boolean delete(Product product) {
        int indexProduct = indexOf(product);
        if (indexProduct > DEFAULT_INDEX) {
            deleteMain(indexProduct);
            return true;
        }
        return false;
    }

    public Product delete(int indexProduct) throws IndexOutOfBoundsStockException {
        belongRange(indexProduct);
        Product productDeleted = get(indexProduct);
        deleteMain(indexProduct);
        return productDeleted;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            ambry[i] = null;
        }
        size = BEGIN_VALUE;
    }

    public Product get(int indexProduct) throws IndexOutOfBoundsStockException {
        belongRange(indexProduct);
        Product product = ambry[indexProduct];
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayStock stock = (ArrayStock) o;
        return size == stock.size &&
                Arrays.equals(ambry, stock.ambry);
    }

    @Override
    public int hashCode() {
        int result = OFFSET;
        for (Product product : ambry) {
            result = NUMBER_FOR_CODE * result + (product == null ? BEGIN_VALUE : product.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(ambry);
    }


}

