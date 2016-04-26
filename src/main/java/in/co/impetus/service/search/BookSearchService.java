/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.service.search;

import in.co.impetus.db.model.BookSearch;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface BookSearchService.
 * 
 * @author manish.sharma
 */

public interface BookSearchService {

    /**
     * Searchbooks.
     * 
     * @param search
     *            the search
     * @return the list
     */
    List<BookSearch> searchbooks(String search);

    /**
     * Gets the book by id.
     * 
     * @param bookId
     *            the book id
     * @return the book by id
     */
    BookSearch getBookById(String bookId);

    /**
     * Gets the recent books list.
     * 
     * @return the recent books list
     */
    List<BookSearch> getRecentBooksList();
}
