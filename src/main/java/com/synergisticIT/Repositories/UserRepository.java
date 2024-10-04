package com.synergisticIT.Repositories;

import com.synergisticIT.Domain.Notification;
import com.synergisticIT.Domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findAll(Pageable pageable);

    User findByEmail(String email);
}
