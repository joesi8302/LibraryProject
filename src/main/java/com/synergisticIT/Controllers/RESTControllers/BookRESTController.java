package com.synergisticIT.Controllers.RESTControllers;

import com.synergisticIT.Domain.Book;
import com.synergisticIT.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookRESTController {

    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book savedBook = bookService.addBook(book);

        return new ResponseEntity<>(savedBook, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id){
        Book book = bookService.getBookById(id);
        if(book != null){
            return new ResponseEntity<>(book, HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> bookList =  bookService.getAllBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirlines(@PathVariable Integer id){
        Book book = bookService.getBookById(id);
        if(book != null){
            bookService.deleteBook(id);
            return new ResponseEntity<>("Book deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Book of id " + id+ " was not found", HttpStatus.NOT_FOUND);
        }
    }
}
