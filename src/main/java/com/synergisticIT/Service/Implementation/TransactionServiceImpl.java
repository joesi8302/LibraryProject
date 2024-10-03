package com.synergisticIT.Service.Implementation;

import com.synergisticIT.Domain.Transaction;
import com.synergisticIT.Repositories.TransactionRepository;
import com.synergisticIT.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(Integer transactionId) {
        return transactionRepository.findById(transactionId).orElse(null);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public void deleteTransaction(Integer transactionId) {
        Transaction foundTransaction = getTransactionById(transactionId);
        if(foundTransaction != null){
            transactionRepository.delete(foundTransaction);
        }
    }

    @Override
    public Transaction borrowBook(Integer memberId, Integer bookId) {
        return null;
    }

    @Override
    public Transaction returnBook(Integer memberId, Integer bookId) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionsForMember(Integer memberId) {
        return null;
    }
}
