package net.okur.orderservice.service.impl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.okur.orderservice.model.Order;
import net.okur.orderservice.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author dogancan.okur
 * 5.12.2022 04:32
 */
@Service
@ApiModel(value = "User Api model documentation", description = "Model")
public class OrderServiceImpl implements OrderService {
    @Override
    @ApiModelProperty(value = "Unique id field of user object")
    public Order saveOrder(Order order) {
        return null;
    }
}
