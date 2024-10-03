package com.synergisticIT.Repositories;

import com.synergisticIT.Domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
