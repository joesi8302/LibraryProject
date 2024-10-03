package com.synergisticIT.Repositories;

import com.synergisticIT.Domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
