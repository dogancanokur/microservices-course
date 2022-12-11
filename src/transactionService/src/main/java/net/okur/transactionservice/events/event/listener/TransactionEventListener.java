package net.okur.transactionservice.events.event.listener;

import net.okur.transactionservice.events.event.TransactionEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author dogancan.okur
 * 11.12.2022 17:46
 */
@Component
public class TransactionEventListener {
    @EventListener
    public void transactionEventHandler(TransactionEvent transactionEvent) throws InterruptedException {
        Thread.sleep(5000L);
        System.out.println("EventListener -> " + transactionEvent.getSource());

    }
}
