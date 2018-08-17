package ru.gontov.enterprise.controller;

import ru.gontov.enterprise.dao.CategoryDAO;
import ru.gontov.enterprise.dao.ProductDAO;
import ru.gontov.enterprise.entity.Order;
import ru.gontov.enterprise.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class ProductEditController {

    @Inject
    private ProductDAO productDAO;

    @Inject
    private CategoryDAO categoryDAO;

    private Long id;
    private Long categoryId;
    private Product product = new Product();

    public void init(){
        Product product = productDAO.getProductById(id);
        if (product != null) this.product = product;
    }

    public String save(){
        if (categoryId != null) product.setCategory(categoryDAO.getCategoryById(categoryId));
        productDAO.merge(product);
        return "product-list";
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
