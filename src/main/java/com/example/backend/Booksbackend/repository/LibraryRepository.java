package com.example.backend.Booksbackend.repository;

import com.example.backend.Booksbackend.entity.LibraryUser;
import com.example.backend.Booksbackend.entity.LibraryUserKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryUser, LibraryUserKey> {
}
