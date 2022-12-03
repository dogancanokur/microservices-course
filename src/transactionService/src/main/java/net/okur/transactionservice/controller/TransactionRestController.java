package net.okur.transactionservice.controller;

import net.okur.transactionservice.model.Transaction;
import net.okur.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dogancan.okur
 * 3.12.2022 21:20
 */
@RestController
@RequestMapping("api/v1/transaction") // pre-path
public class TransactionRestController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllTransactions() {
        List<Transaction> transactionList = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactionList);
    }

    @PostMapping("/")
    public ResponseEntity<?> saveTransaction(@RequestBody Transaction transaction) {

        return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }

    @DeleteMapping("{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long transactionId) {
        transactionService.deleteTransaction(transactionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("{userId}")
    public ResponseEntity<?> getTransactionsByUserId(@PathVariable Long userId) {
        List<Transaction> transactionList = transactionService.findAllTransactionByUserId(userId);
        return ResponseEntity.ok(transactionList);
    }

}
