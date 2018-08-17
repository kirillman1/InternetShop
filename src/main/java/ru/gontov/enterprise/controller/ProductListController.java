package ru.gontov.enterprise.controller;

import ru.gontov.enterprise.dao.ProductDAO;
import ru.gontov.enterprise.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Collection;

@ManagedBean
@ViewScoped
public class ProductListController {

    @Inject
    ProductDAO productDAO;

    private Long categoryId;

    public Collection<Product> getProductList(){
        if (categoryId == null) return productDAO.getProductList();
        return productDAO.getListProductByCategoryId(categoryId);
    }

    public void removeProductById (Long productId) {
        productDAO.removeProductById(productId);
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
