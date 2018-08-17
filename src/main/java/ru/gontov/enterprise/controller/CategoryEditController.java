package ru.gontov.enterprise.controller;

import ru.gontov.enterprise.dao.CategoryDAO;
import ru.gontov.enterprise.entity.Category;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class CategoryEditController {

    @Inject
    private CategoryDAO categoryDAO;

    private Long id;
    private Category category = new Category();

    public void init() {
        Category category = categoryDAO.getCategoryById(id);

        //чтобы контроллер мог и редактировать и создавать новую категорию
        if (category != null) this.category = category;
    }

    public String save() {
        categoryDAO.merge(category);
        return "category-list";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
