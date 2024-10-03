package com.synergisticIT.Service;

import com.synergisticIT.Domain.Member;
import com.synergisticIT.Domain.Transaction;

import java.util.List;

public interface TransactionService {


    Transaction addTransaction(Transaction transaction);
    Transaction getTransactionById(Integer transactionId);
    List<Transaction> getAllTransactions();
    void deleteTransaction(Integer transactionId);

    Transaction borrowBook(Integer memberId, Integer bookId);
    Transaction returnBook(Integer memberId, Integer bookId);
    List<Transaction> getAllTransactionsForMember(Integer memberId);

}
