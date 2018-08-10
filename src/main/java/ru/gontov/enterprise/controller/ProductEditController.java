package ru.gontov.enterprise.controller;

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
    ProductDAO productDAO;

    private String id;
    private Product product = new Product();

    public void init(){
        Product product = productDAO.getProductById(id);
        if (product != null) this.product = product;
    }

    public String save(){
        productDAO.merge(product);
        return "order-list";
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
