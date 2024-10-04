package com.synergisticIT.Repositories;

import com.synergisticIT.Domain.Notification;
import com.synergisticIT.Domain.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    Page<Publisher> findAll(Pageable pageable);
}
