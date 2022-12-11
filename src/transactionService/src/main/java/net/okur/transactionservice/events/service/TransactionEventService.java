package net.okur.transactionservice.events.service;

import net.okur.transactionservice.events.api.TransactionEventRequest;
import net.okur.transactionservice.events.event.TransactionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author dogancan.okur
 * 11.12.2022 17:44
 */

@Service
public class TransactionEventService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void publishProductEvent(TransactionEventRequest transactionEventRequest) {
        applicationEventPublisher.publishEvent(new TransactionEvent(transactionEventRequest));
    }
}
