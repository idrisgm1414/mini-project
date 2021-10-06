package com.project.mini.service;

import com.project.mini.service.wrapper.OrderWrapper;

import java.util.List;

public interface OrderService {

    OrderWrapper createOrder(OrderWrapper orderWrapper);

    OrderWrapper changeQuantityByRegisterId(OrderWrapper orderWrapper);

    public List<OrderWrapper> getAllByCustomerName(OrderWrapper orderWrapper);
}
