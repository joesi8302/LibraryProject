package com.synergisticIT.Service;

import com.synergisticIT.Domain.Librarian;

import java.util.List;

public interface LibrarianService {
    Librarian createLibrarian(Librarian librarian);
    Librarian getLibrarianById(Integer librarianId);
    List<Librarian> getAllLibrarians();
    void deleteLibrarian(Integer librarianId);

}
