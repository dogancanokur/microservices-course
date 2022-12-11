package net.okur.transactionservice.events.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author dogancan.okur
 * 11.12.2022 17:45
 */
public class TransactionEvent extends ApplicationEvent {
    public TransactionEvent(Object source) {
        super(source);
    }

}
