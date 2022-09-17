package org.example.app.services;

import org.example.web.dto.Book;
import org.example.web.dto.BookIdToRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private ProjectRepository<Book> bookRepo;

    @Autowired
    public BookService(BookRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public BookService() {
    }

    public List<Book> getAllBooks() {
        return bookRepo.retriveAll();
    }

    public void save(Book book) {
        bookRepo.store(book);
    }

    public boolean removeBookById(String bookIdToRemove) {

        return bookRepo.removeItemById(bookIdToRemove);
    }

    public boolean removeByRegex(String queryRegex,String queryField) {
        return bookRepo.removeByRegex(queryRegex,queryField);
    }
}
