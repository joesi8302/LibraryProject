package com.synergisticIT.Controllers.RESTControllers;

import com.synergisticIT.Domain.Transaction;
import com.synergisticIT.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionRESTController {

    @Autowired
    TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
        Transaction savedTransaction = transactionService.addTransaction(transaction);

        return new ResponseEntity<>(savedTransaction, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Integer id){
        Transaction transaction = transactionService.getTransactionById(id);
        if(transaction != null){
            return new ResponseEntity<>(transaction, HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        List<Transaction> transactionList =  transactionService.getAllTransactions();
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirlines(@PathVariable Integer id){
        Transaction transaction = transactionService.getTransactionById(id);
        if(transaction != null){
            transactionService.deleteTransaction(id);
            return new ResponseEntity<>("Transaction deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Transaction of id " + id+ " was not found", HttpStatus.NOT_FOUND);
        }
    }
}
