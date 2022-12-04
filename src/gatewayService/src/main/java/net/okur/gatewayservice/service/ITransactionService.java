package net.okur.gatewayservice.service;

import com.google.gson.JsonElement;

import java.util.List;

/**
 * @author dogancan.okur
 * 5.12.2022 02:22
 */
public interface ITransactionService {
    JsonElement saveTransaction(JsonElement transaction);

    void deleteTransaction(Long transactionId);

    List<JsonElement> getAllTransactionOfAuthorizedUser(Long userId);


}
