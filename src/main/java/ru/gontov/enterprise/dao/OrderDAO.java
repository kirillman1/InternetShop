package ru.gontov.enterprise.dao;

import ru.gontov.enterprise.entity.Order;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OrderDAO extends AbstractDAO {

    public List<Order> getOrderList() {
        return entityManager.createQuery("SELECT e FROM Order e ORDER BY e.created DESC", Order.class).getResultList();
    }

    public Order getOrderById(Long id) {
        if (id == null) return null;
        return entityManager.find(Order.class, id);
    }

    public Order persist(Order order) {
        if (order == null) return null;
        entityManager.persist(order);
        return order;
    }

    public Order merge(Order order) {
        if (order == null) return null;
        return entityManager.merge(order);
    }

    public void removeOrderById(Long id) {
        Order order = getOrderById(id);
        if (id == null) return;
        entityManager.remove(order);
    }
}
