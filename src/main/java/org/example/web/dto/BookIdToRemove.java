package org.example.web.dto;

import javax.validation.constraints.NotEmpty;

public class BookIdToRemove {
    @NotEmpty
    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    @Override
    public String toString() {
        return "BookIdToRemove{" +
                "id='" + id + '\'' +
                '}';
    }
}
