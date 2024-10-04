package com.synergisticIT.Service.Implementation;

import com.synergisticIT.Domain.Author;
import com.synergisticIT.Repositories.AuthorRepository;
import com.synergisticIT.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(Integer authorId) {
        return authorRepository.findById(authorId).orElse(null);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void deleteAuthor(Integer authorId) {
        Author foundAuthor = getAuthorById( authorId);
        if(foundAuthor !=null){
            authorRepository.delete(foundAuthor);
        }
    }

    @Override
    public Page<Author> findAllPaginiated(int page, int size) {
        return authorRepository.findAll(PageRequest.of(page, size));
    }

}
