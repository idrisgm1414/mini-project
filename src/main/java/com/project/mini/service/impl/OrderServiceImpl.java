package com.project.mini.service.impl;

import com.project.mini.model.Order;
import com.project.mini.repository.OrderRepository;
import com.project.mini.service.OrderService;
import com.project.mini.service.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    @Transactional
    public OrderWrapper createOrder(OrderWrapper orderWrapper) {
        orderWrapper.setRegistrationId(UUID.randomUUID().toString());
        orderWrapper.setOrderDate(new Date());
        return entityToWrapper(orderRepository.save(wrapperToEntity(orderWrapper))) ;
    }

    @Override
    @Transactional
    public OrderWrapper changeQuantityByRegisterId(OrderWrapper orderWrapper) {
        Order order = orderRepository.getOrderByRegistrationId(orderWrapper.getRegistrationId());
        System.out.println("INI ORDER REGISTER ID == " + orderWrapper.getRegistrationId());
        System.out.println("INI ORDER QUANTITY ID == " + orderWrapper.getQuantity());

        order.setQuantity(orderWrapper.getQuantity());
        return entityToWrapper(orderRepository.save(order));
    }

    @Override
    @Transactional
    public List<OrderWrapper> getAllByCustomerName(OrderWrapper orderWrapper) {
        List<Order> orders = orderRepository.getAllOrderByCustomerName(orderWrapper.getCustomerName());
        List<OrderWrapper> orderWrapperResult = new ArrayList<>();
        for (Order order: orders) {
            orderWrapperResult.add(entityToWrapper(order));
        }
        return orderWrapperResult;
    }

    Order wrapperToEntity(OrderWrapper orderWrapper) {
        Order order = new Order();
        order.setItemName(orderWrapper.getItemName());
        order.setDescription(orderWrapper.getDescription());
        order.setQuantity(orderWrapper.getQuantity());
        order.setCustomerName(orderWrapper.getCustomerName());
        order.setCustomerAddress(orderWrapper.getCustomerAddress());
        order.setRegistrationId(orderWrapper.getRegistrationId());
        order.setOrderDate(orderWrapper.getOrderDate());
        return order;
    }

    OrderWrapper entityToWrapper(Order order) {
        OrderWrapper orderWrapper = new OrderWrapper();
        orderWrapper.setRegistrationId(order.getRegistrationId());
        orderWrapper.setItemName(order.getItemName());
        orderWrapper.setDescription(order.getDescription());
        orderWrapper.setQuantity(order.getQuantity());
        orderWrapper.setCustomerName(order.getCustomerName());
        orderWrapper.setCustomerAddress(order.getCustomerAddress());
        orderWrapper.setOrderDate(order.getOrderDate());
        return orderWrapper;
    }

}
