package ru.gontov.enterprise.dao;


import ru.gontov.enterprise.entity.Category;

import javax.ejb.Stateless;

import java.util.List;


/**
 * Session бины обладают транзакцией и покрываются контекстом персистентности.
 * Бывают Stateless бины и Stateful
 * <p>
 * Stateless бин - класс, который не может хранить состояние, т.е. не имеет полей.
 * Потому что сервер приложений может создать несколько инстансов этого бина, и будет ли дан тот бин,
 * который мы хотели использовать, сервер не гарантирует
 * Поскольку не содержат состояний, могут масштабированы на разные ноды в рамках кластера,
 * таким образом достигается легкая портируемость и поддерживаемость кода
 * <p>
 * Stateful классы могут хранить состояния. Сервер приложений гарантирует состояние stateful бина в рамках ejb сессии,
 * которая начинается в момент обращения к ejb фреймворку, т.е как тлько мы в первый раз обращаемся к классам ejb
 */
@Stateless
public class CategoryDAO extends AbstractDAO {

    public List<Category> getCategoryList() {
        return entityManager.createQuery("SELECT e FROM Category e ORDER BY e.created DESC", Category.class).getResultList();
    }

    public Category getCategoryById(Long categoryId) {
        if (categoryId == null) return null;
        return entityManager.find(Category.class, categoryId);
    }

    public Category persist(Category category) {
        if (category == null) return null;
        entityManager.persist(category);
        return category;
    }

    public Category merge(Category category) {
        if (category == null) return null;
        return entityManager.merge(category);
    }

    public void removeCategoryById(Long categoryId) {
        Category category = getCategoryById(categoryId);
        if (categoryId == null) return;
        entityManager.remove(category);

    }


}
