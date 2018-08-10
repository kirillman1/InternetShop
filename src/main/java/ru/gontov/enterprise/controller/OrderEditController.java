package ru.gontov.enterprise.controller;

import ru.gontov.enterprise.dao.OrderDAO;
import ru.gontov.enterprise.entity.Order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class OrderEditController {

    @Inject
    OrderDAO orderDAO;

    private String id;
    private Order order = new Order();

    public void init(){
        Order order = orderDAO.getOrderById(id);
        if (order != null) this.order = order;
    }

    public String save(){
        orderDAO.merge(order);
        return "order-list";
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
