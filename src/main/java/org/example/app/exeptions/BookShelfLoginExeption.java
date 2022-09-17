package org.example.app.exeptions;

public class BookShelfLoginExeption extends Exception {
    private final String message;
    public BookShelfLoginExeption(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
