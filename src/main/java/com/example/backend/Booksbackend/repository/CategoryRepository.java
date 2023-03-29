package com.example.backend.Booksbackend.repository;

import com.example.backend.Booksbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
