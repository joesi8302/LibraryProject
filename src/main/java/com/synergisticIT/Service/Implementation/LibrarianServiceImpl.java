package com.synergisticIT.Service.Implementation;

import com.synergisticIT.Domain.Author;
import com.synergisticIT.Domain.Librarian;
import com.synergisticIT.Repositories.LibrarianRepository;
import com.synergisticIT.Service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianServiceImpl implements LibrarianService {
    @Autowired
    LibrarianRepository librarianRepository;

    @Override
    public Librarian createLibrarian(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    @Override
    public Librarian getLibrarianById(Integer librarianId) {
        return librarianRepository.findById(librarianId).orElse(null);
    }

    @Override
    public List<Librarian> getAllLibrarians() {
        return librarianRepository.findAll();
    }

    @Override
    public void deleteLibrarian(Integer librarianId) {
        Librarian foundLibrarian = getLibrarianById(librarianId);
        if(foundLibrarian != null){
            librarianRepository.delete(foundLibrarian);
        }
    }

    @Override
    public Page<Librarian> findAllPaginiated(int page, int size) {
        return librarianRepository.findAll(PageRequest.of(page, size));
    }


}
