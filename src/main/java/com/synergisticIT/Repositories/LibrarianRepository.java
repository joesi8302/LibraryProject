package com.synergisticIT.Repositories;

import com.synergisticIT.Domain.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
}
