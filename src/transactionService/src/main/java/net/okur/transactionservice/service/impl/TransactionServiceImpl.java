package net.okur.transactionservice.service.impl;

import net.okur.transactionservice.model.Transaction;
import net.okur.transactionservice.repository.TransactionRepository;
import net.okur.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author dogancan.okur
 * 3.12.2022 21:20
 */
@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> findAllTransactionByUserId(Long userId) {
        return transactionRepository.findAllByUserId(userId);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        transaction.setTransactionDateTime(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }
}
