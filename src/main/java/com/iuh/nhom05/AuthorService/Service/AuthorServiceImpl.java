package com.iuh.nhom05.AuthorService.Service;

import com.iuh.nhom05.AuthorService.entities.Author;
import com.iuh.nhom05.AuthorService.repository.AuthorRepository;
<<<<<<< HEAD
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
=======
import io.github.resilience4j.retry.annotation.Retry;
>>>>>>> retry
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorRepository authorRepository;

    @Retry(name = "basic")
    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @RateLimiter(name = "basic")
    @Override
    public Author findById(int id) {
        Optional<Author> rs = authorRepository.findById(id);
        Author author = null;
        if (rs.isPresent()) {
            author = rs.get();
        }
        return author;
    }

<<<<<<< HEAD
    @RateLimiter(name = "timeout")
=======
    @Retry(name = "throwingException")
>>>>>>> retry
    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }
}
