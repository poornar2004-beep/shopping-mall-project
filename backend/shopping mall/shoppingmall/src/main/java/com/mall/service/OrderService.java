package com.mall.shoppingmall.service;

import com.mall.shoppingmall.entity.Order;
import com.mall.shoppingmall.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Order addOrder(Order order) {
        return repository.save(order);
    }

    // READ
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    // UPDATE
    public Order updateOrder(Long id, Order updatedOrder) {

        Order order = repository.findById(id).orElseThrow();

        order.setCustomerName(updatedOrder.getCustomerName());
        order.setProductName(updatedOrder.getProductName());
        order.setQuantity(updatedOrder.getQuantity());
        order.setPrice(updatedOrder.getPrice());

        return repository.save(order);
    }

    // DELETE
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}