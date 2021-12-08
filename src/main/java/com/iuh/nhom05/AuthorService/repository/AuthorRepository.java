package com.iuh.nhom05.AuthorService.repository;

import com.iuh.nhom05.AuthorService.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
