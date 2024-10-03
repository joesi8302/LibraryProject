package com.synergisticIT.Repositories;

import com.synergisticIT.Domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
