/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import java.util.List;

import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.Plans;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdminFunctionDao.
 */
public interface AdminFunctionDao {

    /**
     * Insert row.
     * 
     * @param books
     *            the books
     * @return the string
     */
    String insertBook(BookSearch books);

    /**
     * Gets the row by id.
     * 
     * @param id
     *            the id
     * @return the row by id
     */
    BookSearch getBookById(String id);

    /**
     * Delete row.
     * 
     * @param id
     *            the id
     * @return the string
     */
    String deleteBook(String id);

    /**
     * Show active delivery requests.
     * 
     * @return the list
     */
    List<RequestBook> showActiveDeliveryRequests();

    /**
     * Show active return requests.
     * 
     * @return the list
     */
    List<RequestBook> showActiveReturnRequests();

    /**
     * Accept delivery request.
     * 
     * @param requestId
     *            the request id
     * @param action
     *            the action
     * @return the string
     */
    String acceptDeliveryRequest(int requestId, String action);

    /**
     * Accept return request.
     *
     * @param requestBook the request book
     * @return the string
     */
    String acceptReturnRequest(RequestBook requestBook);

    /**
     * View active users.
     * 
     * @return the list
     */
    List<Subscription> viewActiveUsers();

    /**
     * Adds the or update subscriptions.
     * 
     * @param plans
     *            the plans
     * @return the string
     */
    String addOrUpdateSubscriptions(List<Plans> plans);

    /**
     * Delete subscriptions.
     * 
     * @param plans
     *            the plans
     * @return the string
     */
    String deleteSubscriptions(List<Plans> plans);
    
    List<BookSearch> getAllBooks(int start, int pageSize,  String search,
            int columnNum, String sortOrder);
    int getTotalRecordsOfBooks();

}
