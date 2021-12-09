package com.iuh.nhom05.AuthorService.controller;

import com.iuh.nhom05.AuthorService.entities.Author;
import com.iuh.nhom05.AuthorService.repository.AuthorListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/redis/list/authors")
public class AuthorListController {
    @Autowired
    private AuthorListRepository authorListRepository;

    @PostMapping
    public Author saveAuthor(@RequestBody Author author) {
        authorListRepository.saveAuthor(author);
        return author;
    }

    @GetMapping
    public List<Author> findAll() {
        return authorListRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable("id") Integer id) {
        return authorListRepository.findById(id);
    }

    @PutMapping
    public void update(@RequestBody Author author) {
        authorListRepository.update(author);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        authorListRepository.deleteById(id);
    }
}
