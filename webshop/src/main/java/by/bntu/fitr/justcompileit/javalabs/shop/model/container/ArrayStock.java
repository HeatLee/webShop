package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.util.exceptions.logic.IndexOutOfBoundsStockException;

import java.util.Arrays;

public class ArrayStock implements Stock {

    private static final long serialVersionUID = 1001L;

    public static final int OFFSET = 1;
    public static final int HASH_NUM = 31;
    public static final int BEGIN_VALUE = 0;
    public static final int DEFAULT_INDEX = -1;

    public static final String EXCEPTION_DESCRIPTION = "Out of bound stock!";

    private Product[] stock;
    private int size;

    public ArrayStock() {
        this.stock = new Product[BEGIN_VALUE];
    }

    public ArrayStock(Product... products) {
        stock = Arrays.copyOf(products, products.length);
        size = products.length;
    }

    public ArrayStock(ArrayStock stock) {
        this.stock = new Product[stock.size];
        System.arraycopy(stock.stock, BEGIN_VALUE, this.stock, BEGIN_VALUE, stock.size);
        size = stock.size;
    }

    public Product get(int indexProduct) throws IndexOutOfBoundsStockException {
        belongRange(indexProduct);
        return stock[indexProduct];
    }

    public Product set(int index, Product newProduct) throws IndexOutOfBoundsStockException {
        belongRange(index);
        Product product = stock[index];
        stock[index] = newProduct;
        return product;
    }

    public boolean add(Product product) {
        if (product != null) {
            Product[] newStock = new Product[size + OFFSET];
            System.arraycopy(stock, BEGIN_VALUE, newStock, BEGIN_VALUE, size);
            newStock[size] = product;
            stock = new Product[newStock.length];
            System.arraycopy(newStock, BEGIN_VALUE, stock, BEGIN_VALUE, newStock.length);
            size++;
            return true;
        }
        return false;
    }

    public boolean addAll(Product[] products) {
        Product[] newStock = new Product[size + products.length];
        System.arraycopy(stock, BEGIN_VALUE, newStock, BEGIN_VALUE, size);
        System.arraycopy(products, BEGIN_VALUE, newStock, size, products.length);
        stock = new Product[newStock.length];
        System.arraycopy(newStock, BEGIN_VALUE, stock, BEGIN_VALUE, newStock.length);
        size = newStock.length;
        return products.length != BEGIN_VALUE;
    }

    private void belongRange(int index) throws IndexOutOfBoundsStockException {
        if (index < BEGIN_VALUE || index > size) {
            throw new IndexOutOfBoundsStockException(EXCEPTION_DESCRIPTION + " Index: " + index + ", Size: " + size);
        }
        if (size == BEGIN_VALUE) {
            throw new IndexOutOfBoundsStockException(EXCEPTION_DESCRIPTION);
        }
    }

    public boolean contains(Product product) {
        return indexOf(product) > DEFAULT_INDEX;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            stock[i] = null;
        }
        stock = new Product[BEGIN_VALUE];
        size = BEGIN_VALUE;
    }

    public Product delete(int indexProduct) throws IndexOutOfBoundsStockException {
        belongRange(indexProduct);
        Product productDeleted = get(indexProduct);
        deleteMain(indexProduct);
        return productDeleted;
    }

    public boolean delete(Product product) {
        int indexProduct = indexOf(product);
        if (indexProduct > DEFAULT_INDEX) {
            deleteMain(indexProduct);
            return true;
        }
        return false;
    }

    private void deleteMain(int indexProduct) {
        Product[] newStock = new Product[size - OFFSET];
        System.arraycopy(stock, BEGIN_VALUE, newStock, BEGIN_VALUE, indexProduct);
        System.arraycopy(stock, indexProduct + OFFSET, newStock, indexProduct,
                size - indexProduct - OFFSET);
        stock = new Product[newStock.length];
        System.arraycopy(newStock, BEGIN_VALUE, stock, BEGIN_VALUE, newStock.length);
        size--;
    }

    public int indexOf(Product product) {
        int indexProduct = DEFAULT_INDEX;

        if (product == null) {
            for (int i = 0; i < size; i++) {
                if (stock[i] == null) {
                    indexProduct = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (product.getId() == stock[i].getId()) {
                    indexProduct = i;
                    break;
                }
            }
        }
        return indexProduct;
    }

    public int size() {
        return size;
    }

    public Product[] toArray() {
        return Arrays.copyOf(stock, size);
    }

    public Product[] toArray(Product[] products) {
        if (products.length < size) {
            return Arrays.copyOf(stock, size, products.getClass());
        }
        System.arraycopy(stock, BEGIN_VALUE, products, BEGIN_VALUE, size);
        if (products.length > size) {
            products[size] = null;
        }
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayStock that = (ArrayStock) o;
        return size == that.size &&
                Arrays.equals(stock, that.stock);
    }

    @Override
    public int hashCode() {
        int result = OFFSET;
        for (Product product : stock) {
            result = HASH_NUM * result + (product == null ? BEGIN_VALUE : product.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(stock);
    }

}