package ru.gontov.enterprise.dao;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractDAO {

    @NotNull
    public static final String PERSISTENCE_UNIT = "example-persistence-unit"; // из persistence.xml

    @PersistenceContext(unitName = PERSISTENCE_UNIT)
    protected EntityManager entityManager; // интерфейс который непосредственно работает с сущностями; окно в БД
    /* методы:
    persist = insert в SQL
    remove = delete
    merge = select by id + если не был найден в хранилище, то insert, если был, то update
     */

    @Nullable
    public <T> T getEntity(@NotNull final TypedQuery<T> query) {
        final List<T> resultList = query.getResultList();
        if (resultList.isEmpty()) return null;
        return resultList.get(0);
    }
}
