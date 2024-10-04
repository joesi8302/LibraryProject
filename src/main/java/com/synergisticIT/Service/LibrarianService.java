package com.synergisticIT.Service;

import com.synergisticIT.Domain.Author;
import com.synergisticIT.Domain.Librarian;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LibrarianService {
    Librarian createLibrarian(Librarian librarian);
    Librarian getLibrarianById(Integer librarianId);
    List<Librarian> getAllLibrarians();
    void deleteLibrarian(Integer librarianId);

    Page<Librarian> findAllPaginiated(int page, int size);

}
