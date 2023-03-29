package com.example.backend.Booksbackend.service;

import com.example.backend.Booksbackend.entity.Book;
import com.example.backend.Booksbackend.entity.LibraryUser;
import com.example.backend.Booksbackend.entity.LibraryUserKey;
import com.example.backend.Booksbackend.entity.User;
import com.example.backend.Booksbackend.repository.BookRepository;
import com.example.backend.Booksbackend.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    BookRepository bookRepository;
    public List<Book> getAllBooksForUser(User user){
        List<LibraryUser> collectionBooks = user.getLibraryBooksSet();
        List<Long> idAllBookUser = collectionBooks.stream().map(LibraryUser::getId).map(LibraryUserKey::getBookId).toList();
        List<Book> bookListForUser = new ArrayList<>();
        for(int i=0; i < idAllBookUser.size(); i++){
            bookListForUser.add(bookRepository.findById(idAllBookUser.get(i)).get());
        }
        return bookListForUser;
    }

    public boolean deletedBookOutputLibrary(Long bookId,Long userId){
        LibraryUserKey libraryUserKey = new LibraryUserKey(userId,bookId);
        libraryRepository.deleteById(libraryUserKey);
        return true;
    }

}
