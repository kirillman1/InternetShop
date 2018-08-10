package ru.gontov.enterprise.controller;

import ru.gontov.enterprise.dao.CategoryDAO;
import ru.gontov.enterprise.entity.Category;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Collection;

@ViewScoped
@ManagedBean
public class CategoryListController {

    @Inject
    CategoryDAO categoryDAO;

    public Collection<Category> getCategoryList(){
        return categoryDAO.getCategoryList();
    }

    public void removeCategoryById(String categoryId){
        categoryDAO.removeCategoryById(categoryId);
    }
}
