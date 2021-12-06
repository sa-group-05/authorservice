package com.iuh.nhom05.AuthorService.controller;

import com.iuh.nhom05.AuthorService.Service.AuthorService;
import com.iuh.nhom05.AuthorService.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorRestController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public List<Author> findAll(){
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable int id){
        return authorService.findById(id);
    }

    @PostMapping("")
    public void save(@RequestBody Author author) {
        authorService.save(author);
    }

    @PutMapping("")
    public void update(@RequestBody Author author) {
        authorService.save(author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        authorService.deleteById(id);
    }
}
