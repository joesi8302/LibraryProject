package com.synergisticIT.Controllers.RESTControllers;

import com.synergisticIT.Domain.Author;
import com.synergisticIT.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorRESTController {
    @Autowired
    AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        Author savedAuthor = authorService.addAuthor(author);

        return new ResponseEntity<>(savedAuthor, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Integer id){
        Author author = authorService.getAuthorById(id);
        if(author != null){
            return new ResponseEntity<>(author, HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authorList =  authorService.getAllAuthors();
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirlines(@PathVariable Integer id){
        Author author = authorService.getAuthorById(id);
        if(author != null){
            authorService.deleteAuthor(id);
            return new ResponseEntity<>("Author deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Author of id " + id+ " was not found", HttpStatus.NOT_FOUND);
        }
    }
}
