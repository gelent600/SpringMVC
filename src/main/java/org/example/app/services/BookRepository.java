package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository<T> implements ProjectRepository<Book> {
    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Book> repo = new ArrayList<>();

    @Override
    public List<Book> retriveAll() {

        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        book.setId(book.hashCode());
        logger.info("store new book: " + book);
        repo.add(book);
    }

    @Override
    public boolean removeItemById(String bookIdToRemove) {
        for (Book book : retriveAll()) {
            if (book.getId().equals(bookIdToRemove)) {
                logger.info("remove book complited: " + book);
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeByRegex(String queryRegex, String queryField) {
        switch (queryField) {
            case "id": {
                for (Book book : retriveAll()) {
                    if (book.getId().equals(Integer.parseInt(queryRegex))) {
                        logger.info("remove book complited: " + book);
                        return repo.remove(book);
                    }
                }
                break;
            }
            case "author": {
                for (Book book : retriveAll()) {
                    if (book.getAuthor().equals(queryRegex)) {
                        logger.info("remove book complited: " + book);
                        return repo.remove(book);
                    }
                }
                break;
            }
            case "tittle": {
                for (Book book : retriveAll()) {
                    if (book.getTitle().equals(queryRegex)) {
                        logger.info("remove book complited: " + book);
                        return repo.remove(book);
                    }
                }
                break;
            }
            case "size": {
                for (Book book : retriveAll()) {
                    if (book.getSize().equals(Integer.parseInt(queryRegex))) {
                        logger.info("remove book complited: " + book);
                        return repo.remove(book);
                    }
                }
            }
            break;
        }
        return false;
    }
}
