package com.iuh.nhom05.AuthorService.repository;

import com.iuh.nhom05.AuthorService.entities.Author;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AuthorHashRepository {
    private static final String KEY = "authors";

    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public AuthorHashRepository(RedisTemplate redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }

    public void saveAuthor(Author author) {
        hashOperations.putIfAbsent(KEY, author.getId(), author);
    }

    public Map<Integer, Author> findAll() {
        return hashOperations.entries(KEY);
    }

    public Author findById(Integer id) {
        return (Author) hashOperations.get(KEY, id);
    }

    public void update(Author author) {
        hashOperations.put(KEY, author.getId(), author);
    }

    public void deleteById(Integer id) {
        hashOperations.delete(KEY, (Object) id);
    }
}
