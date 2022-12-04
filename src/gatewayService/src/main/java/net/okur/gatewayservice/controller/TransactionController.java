package net.okur.gatewayservice.controller;

import com.google.gson.JsonElement;
import net.okur.gatewayservice.security.UserPrincipal;
import net.okur.gatewayservice.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * @author dogancan.okur
 * 5.12.2022 02:25
 */
@RestController
@RequestMapping("gateway/transaction")
public class TransactionController {

    private final ITransactionService transactionService;

    @Autowired
    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;

    }


    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody JsonElement transaction) {

        return ResponseEntity.ok(transactionService.saveTransaction(transaction));

    }

    @GetMapping
    public ResponseEntity<?> getAllProduct(@AuthenticationPrincipal UserPrincipal userPrincipal) {

        return ResponseEntity.ok(transactionService.getAllTransactionOfAuthorizedUser(userPrincipal.getId()));

    }

    @DeleteMapping("{transactionId}")
    public ResponseEntity<?> saveProduct(@PathVariable Long transactionId) {

        transactionService.deleteTransaction(transactionId);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
