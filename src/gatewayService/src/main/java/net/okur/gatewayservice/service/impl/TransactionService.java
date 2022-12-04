package net.okur.gatewayservice.service.impl;

import com.google.gson.JsonElement;
import net.okur.gatewayservice.request.ITransactionServiceRequest;
import net.okur.gatewayservice.service.ITransactionService;
import net.okur.gatewayservice.utils.RetrofitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dogancan.okur
 * 5.12.2022 02:22
 */
@Service
public class TransactionService implements ITransactionService {
    private final ITransactionServiceRequest transactionServiceRequest;

    @Autowired
    public TransactionService(ITransactionServiceRequest transactionServiceRequest) {
        this.transactionServiceRequest = transactionServiceRequest;
    }

    @Override
    public JsonElement saveTransaction(JsonElement transaction) {

        return RetrofitUtils.execute(transactionServiceRequest.saveTransaction(transaction));

    }

    @Override
    public void deleteTransaction(Long transactionId) {

        RetrofitUtils.execute(transactionServiceRequest.deleteTransaction(transactionId));

    }

    @Override
    public List<JsonElement> getAllTransactionOfAuthorizedUser(Long userId) {

        return RetrofitUtils.execute(transactionServiceRequest.getAllTransactionOfAuthorizedUser(userId));

    }

}
