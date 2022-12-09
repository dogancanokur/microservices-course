package net.okur.orderservice.service.impl;

import net.okur.orderservice.model.Cart;
import net.okur.orderservice.service.CartService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author dogancan.okur
 * 5.12.2022 04:31
 */
@Service
public class CartServiceImpl implements CartService {
    @Override
    public Set<Cart> getAllCartByOrderId(Long orderId) {
        return null;
    }
}
