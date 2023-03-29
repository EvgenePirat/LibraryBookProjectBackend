package com.example.backend.Booksbackend.controller;

import com.example.backend.Booksbackend.entity.Book;
import com.example.backend.Booksbackend.entity.LibraryUserKey;
import com.example.backend.Booksbackend.entity.User;
import com.example.backend.Booksbackend.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/library")
@CrossOrigin("http://localhost:3000/")
public class LibraryController {
    @Autowired
    LibraryService libraryService;
    @PostMapping("/get_collection_book")
    public @ResponseBody List<Book> getBooksForUser(@RequestBody User user){
        return libraryService.getAllBooksForUser(user);
    }

    @DeleteMapping(value = "/deleted_book/{bookId}/{userId}")
    public ResponseEntity deletedBookOutputLibrary(@PathVariable Long bookId, @PathVariable Long userId){
        System.out.println(bookId);
        System.out.println(userId);
        return libraryService.deletedBookOutputLibrary(bookId,userId) == true ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
