package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.example.app.services.BookService;
import org.example.app.validation.ValidationBookForSave;
import org.example.web.dto.Book;
import org.example.web.dto.BookIdToRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/books")
public class BookShelfController {
    private Logger logger = Logger.getLogger(BookShelfController.class);

    private BookService bookService = new BookService();
    private ValidationBookForSave validation = new ValidationBookForSave();

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/shelf")
    public ModelAndView books(Model model) {
        logger.info("Got book_shelf.html");
        model.addAttribute("book", new Book());
        model.addAttribute("bookIdToRemove", new BookIdToRemove());
        model.addAttribute("bookList", bookService.getAllBooks());

        return new ModelAndView("book_shelf");
    }

    @PostMapping(value = "/save")
    public String booksSave(@Valid Book book, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            if (validation.check(book)) {
                bookService.save(book);
                logger.info("current repository size:" + bookService.getAllBooks().size());

            }
            return "redirect:/books/shelf";
        }else {
            model.addAttribute("book", book);
            model.addAttribute("bookIdToRemove", new BookIdToRemove());
            model.addAttribute("bookList", bookService.getAllBooks());
            return "book_shelf";
        }

    }


    @PostMapping("/remove")
    public String removeBook(@Valid BookIdToRemove bookIdToRemove, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("book", new Book());
            model.addAttribute("bookList", bookService.getAllBooks());
            return "book_shelf";
        } else {
            return "redirect:/books/shelf";
        }
    }

    @PostMapping(value = "/removeByRegex")
    public String booksRemoveByRegex(@RequestParam(value = "queryRegex") String queryRegex, @RequestParam(value = "queryField") String queryField) {
        if (bookService.removeByRegex(queryRegex, queryField)) {
            logger.info("current repository size:" + bookService.getAllBooks().size());
        }
        return "redirect:/books/shelf";
    }
}
