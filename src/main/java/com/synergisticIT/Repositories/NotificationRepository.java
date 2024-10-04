package com.synergisticIT.Repositories;

import com.synergisticIT.Domain.Member;
import com.synergisticIT.Domain.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    Page<Notification> findAll(Pageable pageable);
}
