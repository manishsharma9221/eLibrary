/**
 * 
 * Copyright Impetus @2000-2014
 * 
 */
package in.co.impetus.db.dao;

import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;

import java.util.List;

// TODO: Auto-generated Javadoc

/**
 * The Interface ShelfDAO.
 * 
 * @author manish.sharma
 */

public interface ShelfDAO {

    /**
     * Adds the to shelf.
     * 
     * @param bid
     *            the bid
     * @param uid
     *            the uid
     * @return the string
     */
    String addToShelf(String bid, String uid);

    /**
     * Show shelf.
     * 
     * @param uid
     *            the uid
     * @return the list
     */
    List<BookSearch> showShelf(String uid);

    /**
     * Removes the from shelf.
     * 
     * @param uid
     *            the uid
     * @param bid
     *            the bid
     * @return the string
     */
    String removeFromShelf(String uid, String bid);

    /**
     * Show requested books.
     * 
     * @param uid
     *            the uid
     * @return the list
     */
    List<RequestBook> showRequestedBooks(String uid);

    /**
     * Show books holding.
     * 
     * @param uid
     *            the uid
     * @return the list
     */
    List<RequestBook> showBooksHolding(String uid);

    /**
     * Gets the subscription.
     * 
     * @param userId
     *            the user id
     * @return the subscription
     */
    List<Subscription> getSubscription(String userId);

    /**
     * Show recommendation.
     * 
     * @param uid
     *            the uid
     * @return the list
     */
    List<BookSearch> showRecommendation(String uid);

}
