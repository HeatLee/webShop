package by.bntu.fitr.justcompileit.javalabs.shop.util;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Orange;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Pear;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.Pineapple;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.products.fruits.apple.Apple;

import java.util.ArrayList;
import java.util.List;

public class ProductTypes {

    private List<Class> productTypes;

    public ProductTypes() {
        productTypes = new ArrayList<>();
        productTypes.add(Orange.class);
        productTypes.add(Apple.class);
        productTypes.add(Pineapple.class);
        productTypes.add(Pear.class);
    }

    public List<Class> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<Class> productTypes) {
        this.productTypes = productTypes;
    }
}
