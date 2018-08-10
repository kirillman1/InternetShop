package ru.gontov.enterprise.dao;

import ru.gontov.enterprise.entity.Category;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationScoped
public class CategoryDAO {

    private Map<String, Category> categories = new LinkedHashMap<>();

    @PostConstruct
    private void init(){
        merge(new Category("Example"));
    }

    public Collection<Category> getCategoryList(){
        return categories.values();
    }

    public Category merge(Category category) {
        if (category == null)return null;
        String categoryId = category.getId();
        if (categoryId == null || categoryId.isEmpty())return null;
        categories.put(categoryId, category);
        return category;
    }

    public Category getCategoryById(String categoryId){
        if (categoryId == null || categoryId.isEmpty())return null;
        return categories.get(categoryId);
    }

    public void removeCategoryById(String categoryId){
        if (categoryId == null || categoryId.isEmpty()) return;

    }



}
