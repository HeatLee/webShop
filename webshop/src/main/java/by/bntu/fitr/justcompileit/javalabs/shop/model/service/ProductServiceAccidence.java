package by.bntu.fitr.justcompileit.javalabs.shop.model.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.ArrayStock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.container.Stock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.util.io.JsonSerializer;
import by.bntu.fitr.justcompileit.javalabs.shop.util.io.JsonSimpleDeserializer;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductServiceAccidence implements ProductService {

    private static final String PRODUCTS_FILE_NAME = "dataSource/products.json";

    private Stock stock;

    public ProductServiceAccidence() {
        stock = new ArrayStock(new JsonSimpleDeserializer<Product>(PRODUCTS_FILE_NAME).readArray(Product[].class));
    }

    public ProductServiceAccidence(Stock stock) {
        this.stock = stock;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public boolean exists(Product product) {
        return (findById(product.getId()) == null) ? false : true;
    }

    public Product findById(Long id) {
        Product product = null;
        for (Product productSearch : stock.toArray()) {
            if (productSearch.getId() == id) {
                product = productSearch;
                break;
            }
        }
        return product;
    }

    public boolean append(Product product) {
        boolean result = false;
        if (!exists(product) && stock.add(product)) {
            new JsonSerializer<Product>(PRODUCTS_FILE_NAME).writeArray(stock.toArray());
            result = true;
        }
        return false;
    }

    public boolean remove(Product product) {
        boolean result = false;
        if (exists(product) && stock.delete(product)) {
            new JsonSerializer<Product>(PRODUCTS_FILE_NAME).writeArray(stock.toArray());
            result = true;
        }
        return false;
    }

    public Stock getAll() {
        return getStock();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductServiceAccidence that = (ProductServiceAccidence) o;
        return stock.equals(that.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stock);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("ProductServiceAccidence serves products:\n");
        for (Product product : stock.toArray()) {
            info.append(product).append("\n");
        }
        return info.toString();
    }
}
