package com.synergisticIT.Repositories;

import com.synergisticIT.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
