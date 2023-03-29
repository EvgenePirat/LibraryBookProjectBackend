package com.example.backend.Booksbackend.controller;

import com.example.backend.Booksbackend.entity.*;
import com.example.backend.Booksbackend.repository.AuthorRepository;
import com.example.backend.Booksbackend.repository.BookRepository;
import com.example.backend.Booksbackend.repository.LibraryRepository;
import com.example.backend.Booksbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
@CrossOrigin("http://localhost:3000/")
public class WorkingWithManePage {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    UserService userService;

    @GetMapping("/get_all")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @PostMapping("/save_book")
    public ResponseEntity saveNewBook(@RequestBody Book book){
        bookRepository.save(book);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("get_all_author")
    public List<Author> getAllAuthorWithPhoto(){
        List<Author> authorList = authorRepository.findAll();
        return authorList.stream().filter(author -> author.getUrlImage() != null).toList();
    }

    @PostMapping("/add_book_in_library")
    public ResponseEntity addBookInLibraryUser(@RequestBody LibraryUserKey libraryUserKey){
        return userService.addBookInLibraryUser(libraryUserKey) == true ? new ResponseEntity(HttpStatus.CREATED) : new ResponseEntity(HttpStatus.CONFLICT);
    }
}
