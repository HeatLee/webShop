package by.bntu.fitr.justcompileit.javalabs.shop.model.container;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.exceptions.logic.IndexOutOfBoundsContainerException;
import by.bntu.fitr.justcompileit.javalabs.shop.util.JsonDeserializer;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class ArrayStock implements Stock {

    private static final int OFFSET = 1;
    private static final int BEGIN_VALUE = 0;
    private static final int DEFAULT_INDEX = -1;
    private static final int NUMBER_FOR_CODE = 31;

    private static final String EXCEPTION_DESCRIPTION = "Out of bound container!";
    private static final String PRODUCTS_SOURCE_FILE = "dataSource/products.json";

    private Product[] productStock;
    private int size;

    public ArrayStock() {
        productStock = new JsonDeserializer<Product>(PRODUCTS_SOURCE_FILE).readArray(Product[].class);
        size = BEGIN_VALUE;
    }

    public ArrayStock(Product[] products) {
        productStock = Arrays.copyOf(products, products.length);
        size = products.length;
    }

    public Product get(int indexProduct) throws IndexOutOfBoundsContainerException {
        if (indexProduct < BEGIN_VALUE || indexProduct > size) {
            throw new IndexOutOfBoundsContainerException(EXCEPTION_DESCRIPTION);
        }
        return productStock[indexProduct];
    }

    public Product[] getAll() {
        return productStock;
    }

    public boolean add(Product product) {
        if (product != null) {
            Product[] newProductStock = new Product[size + OFFSET];
            System.arraycopy(productStock, BEGIN_VALUE, newProductStock, BEGIN_VALUE, size);
            newProductStock[size] = product;
            productStock = new Product[newProductStock.length];
            System.arraycopy(newProductStock, BEGIN_VALUE, productStock, BEGIN_VALUE, newProductStock.length);
            size++;
            return true;
        }
        return false;
    }

    public boolean addAll(Product[] products) {
        Product[] newProductStock = new Product[size + products.length];
        System.arraycopy(productStock, BEGIN_VALUE, newProductStock, BEGIN_VALUE, size);
        System.arraycopy(products, BEGIN_VALUE, newProductStock, size, products.length);
        productStock = new Product[newProductStock.length];
        System.arraycopy(newProductStock, BEGIN_VALUE, productStock, BEGIN_VALUE, newProductStock.length);
        size = newProductStock.length;
        return products.length != BEGIN_VALUE;
    }

    private void belongRange(int index) throws IndexOutOfBoundsContainerException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsContainerException(EXCEPTION_DESCRIPTION);
        }
    }

    public boolean contains(Product product) {
        return indexOf(product) > DEFAULT_INDEX;
    }

    private void deleteMain(int indexProduct) {
        Product[] newProductStock = new Product[size - OFFSET];
        System.arraycopy(productStock, BEGIN_VALUE, newProductStock, BEGIN_VALUE, indexProduct);
        System.arraycopy(productStock, indexProduct + OFFSET, newProductStock, indexProduct,
                size - indexProduct - OFFSET);
        productStock = new Product[newProductStock.length];
        System.arraycopy(newProductStock, BEGIN_VALUE, productStock, BEGIN_VALUE, newProductStock.length);
        size--;
    }

    public boolean delete(Product product) {
        int indexProduct = indexOf(product);
        if (indexProduct > DEFAULT_INDEX) {
            deleteMain(indexProduct);
            return true;
        }
        return false;
    }

    public Product delete(int indexProduct) throws IndexOutOfBoundsContainerException {
        belongRange(indexProduct);
        Product productDeleted = get(indexProduct);
        deleteMain(indexProduct);
        return productDeleted;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            productStock[i] = null;
        }
        productStock = null;
        size = BEGIN_VALUE;
    }

    public int size() {
        return size;
    }

    public int indexOf(Product product) {
        int indexElement = DEFAULT_INDEX;
        for (int i = 0; i < size; i++) {
            if (productStock[i] == product) {
                indexElement = i;
            }
        }
        return indexElement;
    }

    public Product set(int index, Product newProduct) throws IndexOutOfBoundsContainerException {
        belongRange(index);
        Product product = productStock[index];
        productStock[index] = newProduct;
        return product;
    }

    public Product[] toArray(Product[] products) {
        if (products.length < size) {
            return Arrays.copyOf(productStock, size, products.getClass());
        }
        System.arraycopy(productStock, BEGIN_VALUE, products, BEGIN_VALUE, size);
        if (products.length > size) {
            products[size] = null;
        }
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayStock stock = (ArrayStock) o;
        return size == stock.size() &&
                Arrays.equals(productStock, stock.productStock);
    }

    @Override
    public int hashCode() {
        int result = OFFSET;
        for (Product product : productStock) {
            result = NUMBER_FOR_CODE * result + (product == null ? BEGIN_VALUE : product.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(productStock);
    }

}