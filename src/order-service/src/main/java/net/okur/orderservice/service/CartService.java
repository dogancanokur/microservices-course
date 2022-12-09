package net.okur.orderservice.service;

import net.okur.orderservice.model.Cart;

import java.util.Set;

/**
 * @author dogancan.okur
 * 5.12.2022 04:30
 */
public interface CartService {

    Set<Cart> getAllCartByOrderId(Long orderId);
}
