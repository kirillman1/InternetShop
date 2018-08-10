package ru.gontov.enterprise.dao;

import ru.gontov.enterprise.entity.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationScoped
public class ProductDAO {

    private Map<String, Product> products = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        merge(new Product("Example"));
    }

    public Collection<Product> getProductList() {
        return products.values();
    }

    public Product getProductById(String productId) {
        if (productId == null || productId.isEmpty()) return null;
        return products.get(productId);
    }

    public Product merge(Product product) {
        if (product == null) return null;
        String productId = product.getId();
        if (productId == null || productId.isEmpty()) return null;
        products.put(productId, product);
        return product;
    }

    public void removeProductById(String productId) {
        if (productId == null || productId.isEmpty()) return;
        if (!products.containsKey(productId)) return;
        products.remove(productId);
    }

}
