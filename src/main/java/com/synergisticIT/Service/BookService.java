package com.synergisticIT.Service;

import com.synergisticIT.Domain.Author;
import com.synergisticIT.Domain.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    Book getBookById(Integer bookId);
    List<Book> getAllBooks();
    void deleteBook(Integer bookId);

    Page<Book> findAllPaginiated(int page, int size);

}
