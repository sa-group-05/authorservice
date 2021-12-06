package com.iuh.nhom05.AuthorService.repository;

import com.iuh.nhom05.AuthorService.entities.Author;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorListRepository {
    private ListOperations listOperations;
    private RedisTemplate redisTemplate;

    public AuthorListRepository(RedisTemplate redisTemplate) {
        this.listOperations = redisTemplate.opsForList();
        this.redisTemplate = redisTemplate;
    }

    public void saveAuthor(Author author) {
        listOperations.rightPush("AUTHOR_LIST", author);
    }

    public List<Author> findAll() {
        return listOperations.range("AUTHOR_LIST", 0, -1);
    }

    public Author findById(Integer id) {
        List<Author> authors = findAll();
        for (Author author : authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public void update(Author author) {
        saveAuthor(author);
    }

    public void deleteById(Integer id) {
        listOperations.remove("AUTHOR_LIST", 1, findById(id));
    }
}
