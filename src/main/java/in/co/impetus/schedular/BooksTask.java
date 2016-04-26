/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.schedular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import in.co.impetus.service.util.BooksSchedulerManager;

// TODO: Auto-generated Javadoc
/**
 * The Class BooksTask.
 */
public class BooksTask {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BooksTask.class);
    /** The books scheduler manager. */
    @Autowired
    private BooksSchedulerManager booksSchedulerManager;


    /**
     * Sets the books scheduler manager.
     * 
     * @param booksSchedulerManager
     *            the new books scheduler manager
     */
    public void setBooksSchedulerManager(
            BooksSchedulerManager booksSchedulerManager) {
        this.booksSchedulerManager = booksSchedulerManager;
    }

    /**
     * Adds the books.
     */
    public void addBooks() {

        booksSchedulerManager.addBooks();
    }

    /**
     * Delete books.
     */
    public void deleteBooks()

    {

        booksSchedulerManager.deleteBooks();
    }

    /**
     * Prints the message.
     */
    public void printMessage() {
        LOGGER.info("booksTask schedular ~");
    }

}
