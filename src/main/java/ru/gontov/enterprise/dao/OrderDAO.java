package ru.gontov.enterprise.dao;

import ru.gontov.enterprise.entity.Order;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationScoped
public class OrderDAO {

    private Map<String, Order> orders = new LinkedHashMap<>();

    @PostConstruct
    private void init(){
        merge(new Order());
    }

    public Collection<Order> getOrderList(){
        return orders.values();
    }

    public Order merge(Order order){
        if (order == null) return null;
        String orderId = order.getId();
        if (orderId == null || orderId.isEmpty()) return null;
        orders.put(orderId, order);
        return order;
    }

    public Order getOrderById(String orderId){
        if (orderId == null || orderId.isEmpty()) return null;
        return orders.get(orderId);
    }

    public void removeOrderById(String orderId){
        if (orderId == null || orderId.isEmpty() || !orders.containsKey(orderId)) return;
        orders.remove(orderId);
    }
}
