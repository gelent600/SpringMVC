package org.example.app.services;

import java.util.List;

public interface ProjectRepository<T> {
    List retriveAll();
    void store(T book);

    boolean removeItemById(Integer bookIdToRemove);

    boolean removeByRegex(String queryRegex, String queryField);
}
