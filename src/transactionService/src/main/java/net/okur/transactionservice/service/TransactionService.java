package net.okur.transactionservice.service;

import net.okur.transactionservice.model.Transaction;

import java.util.List;

/**
 * @author dogancan.okur
 * 3.12.2022 21:20
 */
public interface TransactionService {
    List<Transaction> getAllTransactions();

    List<Transaction> findAllTransactionByUserId(Long userId);

    Transaction saveTransaction(Transaction transaction);

    void deleteTransaction(Long transactionId);
}
