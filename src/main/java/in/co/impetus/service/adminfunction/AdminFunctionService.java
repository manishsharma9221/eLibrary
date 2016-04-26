/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.service.adminfunction;

import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdminFunctionService.
 */
public interface AdminFunctionService {

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
     * @param bookId
     *            the book id
     * @return the row by id
     */
    BookSearch getBookById(String bookId);

    /**
     * Delete row.
     *
     * @param bookId            the book id
     * @return the string
     */
    String deleteBook(String bookId);

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
     * @param bookId
     *            the book id
     * @return the string
     */
    String acceptDeliveryRequest(int requestId, String action, String bookId);

    /**
     * Accept return request.
     * 
     * @param requestId
     *            the request id
     * @param bookId
     *            the book id
     * @return the string
     */
    String acceptReturnRequest(int requestId, String bookId);

    /**
     * View active users.
     * 
     * @return the list
     */
    List<Subscription> viewActiveUsers();

    /**
     * Gets the all books.
     *
     * @param start the start
     * @param pageSize the page size
     * @param search the search
     * @param columnNum the column num
     * @param sortOrder the sort order
     * @return the all books
     */
    List<BookSearch> getAllBooks(int start, int pageSize, String search,
            int columnNum, String sortOrder);

    /**
     * Gets the total records of books.
     *
     * @return the total records of books
     */
    int getTotalRecordsOfBooks();


}
