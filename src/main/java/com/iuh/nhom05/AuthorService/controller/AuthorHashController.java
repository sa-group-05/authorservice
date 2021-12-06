package com.iuh.nhom05.AuthorService.controller;

import com.iuh.nhom05.AuthorService.entities.Author;
import com.iuh.nhom05.AuthorService.repository.AuthorHashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/redis/hash/authors")
public class AuthorHashController {
    @Autowired
    private AuthorHashRepository authorHashRepository;

    @PostMapping
    public Author saveAuthor(@RequestBody Author author) {
        authorHashRepository.saveAuthor(author);
        return author;
    }

    @GetMapping
    public Map<Integer, Author> findAll() {
        return authorHashRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable("id") Integer id) {
        return authorHashRepository.findById(id);
    }

    @PutMapping
    public void update(@RequestBody Author author) {
        authorHashRepository.update(author);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        authorHashRepository.deleteById(id);
    }
}
