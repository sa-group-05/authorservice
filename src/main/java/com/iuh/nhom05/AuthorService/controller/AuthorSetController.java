package com.iuh.nhom05.AuthorService.controller;

import com.iuh.nhom05.AuthorService.entities.Author;
import com.iuh.nhom05.AuthorService.repository.AuthorSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/redis/set/authors")
public class AuthorSetController {
    @Autowired
    private AuthorSetRepository authorSetRepository;

    @PostMapping
    public Author saveAuthor(@RequestBody Author author) {
        authorSetRepository.saveAuthor(author);
        return author;
    }

    @GetMapping
    public Set<Author> findAll() {
        return authorSetRepository.findAll();
    }

//    @GetMapping("/{id}")
//    public Author getAuthorById(@PathVariable("id") Integer id) {
//        return authorSetRepository.findById(id);
//    }

    @PutMapping
    public void update(@RequestBody Author author) {
        authorSetRepository.update(author);
    }

//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable("id") Integer id) {
//        authorSetRepository.deleteById(id);
//    }
}
