package com.synergisticIT.Service.Implementation;

import com.synergisticIT.Domain.Book;
import com.synergisticIT.Repositories.BookRepository;
import com.synergisticIT.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Integer bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(Integer bookId) {
        Book foundBook = getBookById(bookId);
        if(foundBook !=null){
            bookRepository.delete(foundBook);
        }
    }
}
