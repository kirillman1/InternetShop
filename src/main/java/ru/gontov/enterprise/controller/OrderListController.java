package ru.gontov.enterprise.controller;

import ru.gontov.enterprise.dao.OrderDAO;
import ru.gontov.enterprise.entity.Order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Collection;

@ViewScoped
@ManagedBean
public class OrderListController {

    @Inject
    OrderDAO orderDAO;

    public Collection<Order> getOrderList(){
        return orderDAO.getOrderList();
    }

    public void removeOrderById(Long orderId){
        orderDAO.removeOrderById(orderId);
    }
}
