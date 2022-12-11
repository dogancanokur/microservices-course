package net.okur.productservice.events.service;

import net.okur.productservice.events.api.ProductEventRequest;
import net.okur.productservice.events.event.ProductEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author dogancan.okur
 * 11.12.2022 17:44
 */

@Service
public class ProductEventService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void publishProductEvent(ProductEventRequest productEventRequest) {
        applicationEventPublisher.publishEvent(new ProductEvent(productEventRequest));
    }
}
