package com.synergisticIT.Repositories;

import com.synergisticIT.Domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
