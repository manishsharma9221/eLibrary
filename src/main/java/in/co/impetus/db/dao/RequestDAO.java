/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;

import java.util.List;

// TODO: Auto-generated Javadoc

/**
 * The Interface RequestDAO.
 * 
 * @author manish.sharma
 */
public interface RequestDAO {

    /**
     * Count requested books.
     * 
     * @param uid
     *            the uid
     * @return This interface is used for extracting all the data from the
     *         database which is necessary to check whether the request can be
     *         made or not.
     */
    Integer countRequestedBooks(String uid);

    /**
     * Count holding books.
     * 
     * @param uid
     *            the uid
     * @return the integer
     */
    Integer countHoldingBooks(String uid);

    /**
     * Check subscription.
     * 
     * @param userId
     *            the user id
     * @return the subscription
     */
    Subscription checkSubscription(String userId);

    /**
     * Request book.
     * 
     * @param uid
     *            the uid
     * @param bid
     *            the bid
     * @param deliveryAddress
     *            the delivery address
     * @return the string
     */
    String requestBook(String uid, String bid, String deliveryAddress);

    /**
     * Cancel delivery request.
     *
     * @param requestBook the request book
     * @return the string
     */
    String cancelDeliveryRequest(RequestBook requestBook);

    /**
     * Return book request.
     * 
     * @param requestId
     *            the request id
     * @param returnAddress
     *            the return address
     * @return the string
     */
    String returnBookRequest(int requestId, String returnAddress);

    /**
     * Cancel return request.
     * 
     * @param requestId
     *            the request id
     * @return the string
     */
    String cancelReturnRequest(int requestId);

    /**
     * Change availablity.
     * 
     * @param booksearch
     *            the booksearch
     * @return the boolean
     */
    Boolean changeAvailablity(BookSearch booksearch);

    /**
     * Gets the book by request id.
     * 
     * @param requestId
     *            the request id
     * @return the book by request id
     */
    RequestBook getBookByRequestId(int requestId);

    /**
     * Check if already requested.
     * 
     * @param uid
     *            the uid
     * @param book
     *            the book
     * @return the list
     */
    List<RequestBook> checkIfAlreadyRequested(String uid, BookSearch book);

    /**
     * Gets the requested book.
     * 
     * @param uid
     *            the uid
     * @param book
     *            the book
     * @return the requested book
     */
    RequestBook getRequestedBook(String uid, BookSearch book);

}
