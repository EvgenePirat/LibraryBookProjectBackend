package com.example.backend.Booksbackend.controller;

import com.example.backend.Booksbackend.entity.Author;
import com.example.backend.Booksbackend.entity.Category;
import com.example.backend.Booksbackend.entity.Quote;
import com.example.backend.Booksbackend.repository.AuthorRepository;
import com.example.backend.Booksbackend.repository.CategoryRepository;
import com.example.backend.Booksbackend.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(path = "/admin")
@CrossOrigin("http://localhost:3000/")
public class OperationAdmin {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    QuoteRepository quoteRepository;

    @PostMapping("/save_new_author")
    public ResponseEntity saveNewAuthor(@RequestBody Author author){
        authorRepository.save(author);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/save_new_category")
    public ResponseEntity saveNewCategory(@RequestBody Category category){
        categoryRepository.save(category);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/get_all_authors")
    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }
    @GetMapping("/get_all_category")
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    @PostMapping("/save_new_quote")
    public void saveNewQuote(@RequestBody Quote quote){
        quoteRepository.save(quote);
    }

    @GetMapping("/get_all_quotes")
    public List<Quote> getAllQuotes(){
        return quoteRepository.findAll();
    }
}
