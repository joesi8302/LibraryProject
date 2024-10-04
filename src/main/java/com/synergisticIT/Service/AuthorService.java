package com.synergisticIT.Service;

import com.synergisticIT.Domain.Author;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AuthorService {
    Author addAuthor(Author author);
    Author getAuthorById(Integer authorId);
    List<Author> getAllAuthors();
    void deleteAuthor(Integer authorId);

    Page<Author> findAllPaginiated(int page, int size);

}
