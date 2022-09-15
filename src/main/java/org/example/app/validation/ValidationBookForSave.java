package org.example.app.validation;

import org.example.web.dto.Book;

public class ValidationBookForSave {
    public boolean check(Book book){
        if(book.getAuthor()!=""){
            return true;
        }
        if(book.getTitle()!=""){
            return true;
        }
        if(book.getSize()!=null){
            return true;
        }
        return false;
    }
}
