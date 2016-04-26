/**
 * 
 * Copyright Impetus @2000-2014
 * 
 */
package in.co.impetus.service.search;

import in.co.impetus.db.dao.BookSearchDAO;
import in.co.impetus.db.model.BookSearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class BookSearchServiceImpl.
 * 
 * @author yash.khatri
 */

@Service("bookSearchService")
public class BookSearchServiceImpl implements BookSearchService {

    /**
     * Instantiates a new book search service impl.
     */
    public BookSearchServiceImpl() {
    }

    /** The book search dao. */
    @Autowired
    private BookSearchDAO bookSearchDAO;

     /**
     * Sets the booksearch dao.
     * 
     * @param bookSearchDAO
     *            the new booksearch dao
     */
    public void setBooksearchDAO(BookSearchDAO bookSearchDAO) {
        this.bookSearchDAO = bookSearchDAO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.search.BookSearchService#searchbooks(java.lang.
     * String)
     */
    public List<BookSearch> searchbooks(String searchCriteria) {

        List<BookSearch> bookList = bookSearchDAO.searchBooks(searchCriteria);

        return bookList;

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.search.BookSearchService#getBookById(java.lang.
     * String)
     */
    @Override
    public BookSearch getBookById(String bookId) {
        // TODO Auto-generated method stub
        return bookSearchDAO.getBookById(bookId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.service.search.BookSearchService#getRecentBooksList()
     */
    @Override
    public List<BookSearch> getRecentBooksList() {

        return bookSearchDAO.getRecentBooksList();
    }
}
