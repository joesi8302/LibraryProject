package com.synergisticIT.Repositories;

import com.synergisticIT.Domain.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Page<Author> findAll(Pageable pageable);
}
