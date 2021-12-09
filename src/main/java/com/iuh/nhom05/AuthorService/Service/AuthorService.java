package com.iuh.nhom05.AuthorService.Service;

import com.iuh.nhom05.AuthorService.entities.Author;
import io.github.resilience4j.retry.annotation.Retry;

import java.util.List;

public interface AuthorService {
    public List<Author> findAll();
    public Author findById(int id);
    public void save(Author author);
    public void deleteById(int id);
}
