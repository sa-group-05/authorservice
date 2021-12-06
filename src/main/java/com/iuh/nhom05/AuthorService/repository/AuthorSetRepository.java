package com.iuh.nhom05.AuthorService.repository;

import com.iuh.nhom05.AuthorService.entities.Author;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class AuthorSetRepository {
    private static final String KEY = "AUTHOR_SET";

    private SetOperations setOperations;
    private RedisTemplate redisTemplate;

    public AuthorSetRepository(RedisTemplate redisTemplate) {
        this.setOperations = redisTemplate.opsForSet();
        this.redisTemplate = redisTemplate;
    }

    public void saveAuthor(Author author) {
        setOperations.add(KEY, author);
    }

    public Set<Author> findAll() {
        return setOperations.members(KEY);
    }

    public void update(Author author) {
        saveAuthor(author);
    }
}
