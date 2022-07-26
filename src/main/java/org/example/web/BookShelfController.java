package org.example.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/books")
public class BookShelfController {
    private Logger logger=Logger.getLogger(BookShelfController.class);

    @GetMapping(value = "/shelf")
    public ModelAndView books() {
        logger.info("Got book_shelf.html");
        return new ModelAndView("book_shelf");
    }
}
