package org.example.app.services;

import org.example.web.dto.BookIdToRemove;

import java.util.List;

public interface ProjectRepository<T> {
    List retriveAll();
    void store(T book);

    boolean removeItemById(String bookIdToRemove);

    boolean removeByRegex(String queryRegex, String queryField);
}
