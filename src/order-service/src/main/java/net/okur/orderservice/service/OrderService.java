package net.okur.orderservice.service;

import net.okur.orderservice.model.Order;

/**
 * @author dogancan.okur
 * 5.12.2022 04:30
 */
public interface OrderService {

    Order saveOrder(Order order);
}
