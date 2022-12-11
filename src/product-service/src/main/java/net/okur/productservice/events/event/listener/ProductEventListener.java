package net.okur.productservice.events.event.listener;

import net.okur.productservice.events.event.ProductEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author dogancan.okur
 * 11.12.2022 17:46
 */
@Component
public class ProductEventListener {
    @EventListener
    public void productEventHandler(ProductEvent productEvent) throws InterruptedException {
        Thread.sleep(5000L);
        System.out.println("EventListener -> " + productEvent.getSource());

    }
}
