package net.okur.transactionservice.events.api;

import net.okur.transactionservice.events.service.TransactionEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dogancan.okur
 * 11.12.2022 04:38
 */
@RestController
public class TransactionEventApi {

    @Autowired
    private TransactionEventService transactionEventService;

    @PostMapping("/api/test")
    public void testMethod(@RequestBody TransactionEventRequest transactionEventRequest) {
        transactionEventService.publishProductEvent(transactionEventRequest);
        System.out.println("istek isleme alindi. " + transactionEventRequest);
    }
}
