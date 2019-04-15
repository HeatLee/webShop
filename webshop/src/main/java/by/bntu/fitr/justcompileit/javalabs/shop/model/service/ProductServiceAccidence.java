package by.bntu.fitr.justcompileit.javalabs.shop.model.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.container.ArrayStock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.container.Stock;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Product;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.Fruit;
import by.bntu.fitr.justcompileit.javalabs.shop.util.ProductTypes;
import by.bntu.fitr.justcompileit.javalabs.shop.util.io.JsonDeserializer;
import by.bntu.fitr.justcompileit.javalabs.shop.util.io.JsonSerializer;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductServiceAccidence implements ProductService {

    public static final String PRODUCT_COLLECTION = "ProductServiceAccidence serves products:\n";
    public static final String PRODUCTS_FILE_NAME = "dataSource/products.json";

    private Stock stock;

    public ProductServiceAccidence() {
        stock = new ArrayStock(new JsonDeserializer<Product>(PRODUCTS_FILE_NAME).readArrayPolymorphicObjects(
                Product[].class, Product.class, new ProductTypes().getProductTypes()));
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

    @Override
    public Stock getAll() {
        return getStock();
    }

    public Product[] getFruits() {
        Stock fruits = new ArrayStock();
        for (Product product : stock.toArray()) {
            if (product instanceof Fruit) {
                fruits.add(product);
            }
        }
        return fruits.toArray();
    }

    private void update() {
        new JsonSerializer<Product[]>(PRODUCTS_FILE_NAME).writePolymorphicObjects(stock.toArray(),
                Product.class, new ProductTypes().getProductTypes());
    }

    public boolean append(Product product) {
        boolean result = false;
        if (!exists(product) && stock.add(product)) {
            update();
            result = true;
        }
        return false;
    }

    @Override
    public boolean exists(Product product) {
        return findById(product.getId()) != null;
    }

    @Override
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

    @Override
    public boolean remove(Product product) {
        boolean result = false;
        if (exists(product) && stock.delete(product)) {
            update();
            result = true;
        }
        return result;
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
        StringBuilder info = new StringBuilder(PRODUCT_COLLECTION);
        for (Product product : stock.toArray()) {
            info.append(product).append("\n");
        }
        return info.toString();
    }
}
