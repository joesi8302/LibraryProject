package com.synergisticIT.Repositories;

import com.synergisticIT.Domain.Notification;
import com.synergisticIT.Domain.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Page<Transaction> findAll(Pageable pageable);
}
