/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.service.util;

import org.springframework.transaction.annotation.Transactional;

import in.co.impetus.db.dao.BooksSchedulerDAOInterface;
import in.co.impetus.service.util.BooksSchedulerManager;

// TODO: Auto-generated Javadoc
/**
 * The Class BooksSchedulerManagerImpl.
 */
public class BooksSchedulerManagerImpl implements BooksSchedulerManager {

    /** The books scheduler dao. */
    private BooksSchedulerDAOInterface booksSchedulerDAO;

    /**
     * Sets the books scheduler dao.
     * 
     * @param booksSchedulerDAO
     *            the new books scheduler dao
     */
    public void setBooksSchedulerDAO(
            BooksSchedulerDAOInterface booksSchedulerDAO) {
        this.booksSchedulerDAO = booksSchedulerDAO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.service.util.BooksSchedulerManager#addBooks()
     */
    @Override
    @Transactional
    public void addBooks() {
        booksSchedulerDAO.addBooks();

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.service.util.BooksSchedulerManager#deleteBooks()
     */
    @Override
    @Transactional
    public void deleteBooks() {
        booksSchedulerDAO.deleteBooks();

    }

}
