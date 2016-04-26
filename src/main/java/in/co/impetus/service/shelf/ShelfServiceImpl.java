/**
 * 
 * Copyright Impetus @2000-2014
 * 
 */
package in.co.impetus.service.shelf;

import in.co.impetus.db.dao.ShelfDAO;
import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc

/**
 * The Class ShelfServiceImpl.
 * 
 * @author manish.sharma
 */

@Service("shelfService")
public class ShelfServiceImpl implements ShelfService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ShelfServiceImpl.class);

    /** The shelf dao. */
    @Autowired
    private ShelfDAO shelfDAO;

    /**
     * Sets the shelf dao.
     * 
     * @param shelfDAO
     *            the new shelf dao
     */
    public void setShelfDAO(ShelfDAO shelfDAO) {
        this.shelfDAO = shelfDAO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.shelf.ShelfService#addToShelf(java.lang.String,
     * java.lang.String)
     */
    @Override
    @Transactional()
    public String addToShelf(String bookId, String userId) {
        return shelfDAO.addToShelf(bookId, userId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.service.shelf.ShelfService#showShelf(java.lang.String)
     */
    @Override
    public List<BookSearch> showShelf(String userId) {
        return (List<BookSearch>) shelfDAO.showShelf(userId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.shelf.ShelfService#removeFromShelf(java.lang.String
     * , java.lang.String)
     */
    @Override
    @Transactional
    public String removeFromShelf(String userId, String bookId) {
        LOGGER.info("service" + userId);
        LOGGER.info(bookId);
        return shelfDAO.removeFromShelf(userId, bookId);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.shelf.ShelfService#showRequestedBooks(java.lang
     * .String)
     */
    @Override
    public List<RequestBook> showRequestedBooks(String uid) {
        return shelfDAO.showRequestedBooks(uid);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.shelf.ShelfService#showBooksHolding(java.lang.String
     * )
     */
    @Override
    public List<RequestBook> showBooksHolding(String uid) {
        // TODO Auto-generated method stub

        return shelfDAO.showBooksHolding(uid);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.shelf.ShelfService#getSubscription(java.lang.String
     * )
     */
    @Override
    public List<Subscription> getSubscription(String userId) {
        // TODO Auto-generated method stub
        return shelfDAO.getSubscription(userId);
    }

}
