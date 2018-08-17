package ru.gontov.enterprise.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gontov.enterprise.entity.Product;

import javax.ejb.Stateless;
import java.util.Collections;
import java.util.List;

@Stateless
public class ProductDAO extends AbstractDAO {

    public List<Product> getProductList (){
        return entityManager.createQuery("SELECT e FROM Product e ORDER BY e.created DESC", Product.class).getResultList();
    }

    public Product getProductById(Long id){
        if (id == null) return null;
        return entityManager.find(Product.class, id);
    }

    @NotNull
    public List<Product> getListProductByCategoryId(@Nullable final Long categoryId) {
        if (categoryId == null) return Collections.emptyList();
        return entityManager.createQuery("SELECT e FROM Product e WHERE e.category.id = :categoryId ORDER BY e.created", Product.class)
                .setParameter("categoryId", categoryId).getResultList();
    }

    @NotNull
    public List<Product> getListProductByOrderId(@Nullable final Long orderId) {
        if (orderId == null) return Collections.emptyList();
        return entityManager.createQuery("SELECT e FROM Product e WHERE e.order.id = :orderId ORDER BY e.created", Product.class)
                .setParameter("orderId", orderId).getResultList();
    }

    public Product persist (Product product){
        if (product == null) return null;
        entityManager.persist(product);
        return product;
    }

    public Product merge(Product product) {
        if (product == null)return null;
        return entityManager.merge(product);
    }

    public void removeProductById(Long id){
        Product product = getProductById(id);
        if (id == null) return;
        entityManager.remove(product);
    }
}
