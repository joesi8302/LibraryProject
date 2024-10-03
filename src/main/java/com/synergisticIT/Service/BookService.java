package com.synergisticIT.Service;

import com.synergisticIT.Domain.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    Book getBookById(Integer bookId);
    List<Book> getAllBooks();
    void deleteBook(Integer bookId);

}
