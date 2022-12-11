package net.okur.transactionservice.events.api;

import lombok.Data;

/**
 * @author dogancan.okur
 * 11.12.2022 18:30
 */
@Data
public class TransactionEventRequest {
    private String userId;
    private String test;

    @Override
    public String toString() {
        return "TestRequest{" +
                "userId='" + userId + '\'' +
                ", test='" + test + '\'' +
                '}';
    }
}