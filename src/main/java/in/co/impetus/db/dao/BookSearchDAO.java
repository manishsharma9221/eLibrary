/**
 * 
 * Copyright Impetus @2000-2014
 * 
 */

package in.co.impetus.db.dao;

import in.co.impetus.db.model.BookSearch;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface BookSearchDAO.
 *
 * @author manish.sharma
 */
/**
 * 
 * This interface deals with Books table has a method for searching the books
 * requested by the user.
 * */
public interface BookSearchDAO {

    /**
     * Search books.
     * 
     * @param searchCriteria
     *            the search criteria
     * @return the list
     */
    List<BookSearch> searchBooks(String searchCriteria);

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
