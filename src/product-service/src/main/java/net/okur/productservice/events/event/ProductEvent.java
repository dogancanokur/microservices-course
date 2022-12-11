package net.okur.productservice.events.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author dogancan.okur
 * 11.12.2022 17:45
 */
public class ProductEvent extends ApplicationEvent {
    public ProductEvent(Object source) {
        super(source);
    }

}
