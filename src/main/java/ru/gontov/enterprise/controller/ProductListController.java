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

    public Collection<Product> getProductList(){
        return productDAO.getProductList();
    }

    public void removeProductById (String productId) {
        productDAO.removeProductById(productId);
    }
}
