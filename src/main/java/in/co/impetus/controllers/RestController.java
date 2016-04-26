/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.controllers;

import in.co.impetus.db.model.BookSearch;
import in.co.impetus.service.search.BookSearchService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// TODO: Auto-generated Javadoc
/**
 * The Class RestController.
 */
@Controller
@RequestMapping(value = "searchBookRest")
public class RestController {
    
    /** The book search service. */
    @Autowired
    private BookSearchService bookSearchService;

    /**
     * Gets the book.
     * 
     * @return the book
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<BookSearch> getBook() {

        return bookSearchService.getRecentBooksList();
    }
}
