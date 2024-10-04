package com.synergisticIT.Controllers.RESTControllers;

import com.synergisticIT.Domain.Librarian;
import com.synergisticIT.Service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarian")
public class LibrarianRESTController {

    @Autowired
    LibrarianService librarianService;

    @PostMapping
    public ResponseEntity<Librarian> createLibrarian(@RequestBody Librarian librarian){
        Librarian savedLibrarian = librarianService.createLibrarian(librarian);

        return new ResponseEntity<>(savedLibrarian, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Librarian> getLibrarianById(@PathVariable Integer id){
        Librarian librarian = librarianService.getLibrarianById(id);
        if(librarian != null){
            return new ResponseEntity<>(librarian, HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Librarian>> getAllLibrarians(){
        List<Librarian> librarianList =  librarianService.getAllLibrarians();
        return new ResponseEntity<>(librarianList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirlines(@PathVariable Integer id){
        Librarian librarian = librarianService.getLibrarianById(id);
        if(librarian != null){
            librarianService.deleteLibrarian(id);
            return new ResponseEntity<>("Librarian deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Librarian of id " + id+ " was not found", HttpStatus.NOT_FOUND);
        }
    }
}
