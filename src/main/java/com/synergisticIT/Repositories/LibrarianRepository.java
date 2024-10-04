package com.synergisticIT.Repositories;

import com.synergisticIT.Domain.Book;
import com.synergisticIT.Domain.Librarian;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

    Page<Librarian> findAll(Pageable pageable);
}
