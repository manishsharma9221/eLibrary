/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.service.request;

import static in.co.impetus.constants.Constants.ALREADY_REQUESTED;
import static in.co.impetus.constants.Constants.CANCELLED_SUCCESS;
import static in.co.impetus.constants.Constants.FAILURE;
import static in.co.impetus.constants.Constants.IMPENDING_EXPIRY;
import static in.co.impetus.constants.Constants.PLAN_EXPIRED;
import static in.co.impetus.constants.Constants.REQUESTED_SUCCESSFULLY;
import static in.co.impetus.constants.Constants.UPGRADE_PLAN;
import in.co.impetus.db.dao.BookSearchDAO;
import in.co.impetus.db.dao.RequestDAO;
import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestServiceImpl.
 */
@Service("requestService")
public class RequestServiceImpl implements RequestService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(RequestServiceImpl.class);

    private static final int SEVEN =7;

    /** The request dao. */
    @Autowired
    private RequestDAO requestDAO;

    /** The book search dao. */
    @Autowired
    private BookSearchDAO bookSearchDAO;


    /**
     * Sets the request dao.
     * 
     * @param requestDAO
     *            the new request dao
     */
    public void setRequestDAO(RequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    /**
     * Sets the book search dao.
     * 
     * @param bookSearchDAO
     *            the new book search dao
     */
    public void setBookSearchDAO(BookSearchDAO bookSearchDAO) {
        this.bookSearchDAO = bookSearchDAO;
    }




    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.request.RequestService#requestBook(java.lang.String
     * , java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public String requestBook(String userId, String bookId, String dt,
            String deliveryAddress) {

        int requestedBooks = requestDAO.countRequestedBooks(userId);
        LOGGER.info("in service requested Books"
                + Integer.toString(requestedBooks));

        int holdingBooks = requestDAO.countHoldingBooks(userId);
        LOGGER.info("in Service holding books" + Integer.toString(holdingBooks));

        Subscription subscription = requestDAO.checkSubscription(userId);

        int maxBooks = 0;
        Date endDate = new Date();
        boolean impendingExpiry =true;

        if (subscription != null) {
            maxBooks = subscription.getMaxBooks();
            endDate = subscription.getEndDate();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE,SEVEN );
            Date newDate = calendar.getTime();
            LOGGER.info("newDate is "+newDate);
          /*  if(endDate.compareTo(newDate)<0)
            {
                impendingExpiry =false;   
            }*/

        }

        int total = requestedBooks + holdingBooks;

        BookSearch book = bookSearchDAO.getBookById(bookId);

        Integer bookAvailablity = book.getBookAvailablity();

        List<RequestBook> rB1 = requestDAO
                .checkIfAlreadyRequested(userId, book);

        Boolean alreadyRequested = true;
        /* Book Requested Earlier */
        if (rB1 != null) {
            for (RequestBook rB : rB1) {

                if (rB.getDeliveryStatus().equalsIgnoreCase("Pending")) {
                    /* Delivery Status Pending */
                    alreadyRequested = false;
                } else {

                    if (rB.getDeliveryStatus().equalsIgnoreCase("Delivered")) {
                        /* Delivery Status Delivered */

                        if (rB.getReturnStatus() != null) {
                            /* Return Request Generated */

                            if (rB.getReturnStatus().equalsIgnoreCase(
                                    "Return Requested ")) {
                                /* Return Pending */

                                alreadyRequested = false;
                            } else {

                                if (rB.getReturnStatus().equalsIgnoreCase(
                                        "Cancelled ")) {
                                    /* Return Cancelled */
                                    alreadyRequested = false;
                                }

                            }
                        } else {
                            /*    * Return Requested Not generated yet: User is
                             * holding book.
                             */
                            alreadyRequested = false;
                        }

                    }

                }

            }
        }

        if (subscription != null) {

            if(impendingExpiry)         {

                if (bookAvailablity > 0) {
                    /* Checking Availability */
                    if (alreadyRequested) {
                        
                        if (total < maxBooks) {
                            /* checking if max books reached */
                            String requestResult = requestDAO.requestBook(userId,
                                    bookId, deliveryAddress);
                            if (requestResult.equals(REQUESTED_SUCCESSFULLY)) {
                                bookAvailablity = bookAvailablity - 1;
                                /* Decreasing Book quantity */
                                book.setBookAvailablity(bookAvailablity);
                                requestDAO.changeAvailablity(book);

                                return requestResult;
                            } else {
                                if (requestResult.equals(ALREADY_REQUESTED)) {
                                    return ALREADY_REQUESTED;
                                }
                            }
                        } else {
                            return UPGRADE_PLAN;
                        }
                    } else {
                        return ALREADY_REQUESTED;
                    }
                } else {
                    return FAILURE;
                }

            }else
            {
                LOGGER.info("impendingExpiry");
                return IMPENDING_EXPIRY;
            }
        }else {
            return PLAN_EXPIRED;
        }
        
        
        return FAILURE;

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.request.RequestService#cancelDeliveryRequest(int)
     */
    @Override
    @Transactional
    public String cancelDeliveryRequest(int requestId) {
        // TODO Auto-generated method stub

        RequestBook requestedBook = requestDAO.getBookByRequestId(requestId);
        BookSearch book = requestedBook.getBookSearch();

        int bookAvailablity = book.getBookAvailablity();
        bookAvailablity = bookAvailablity + 1;
        book.setBookAvailablity(bookAvailablity);

        String cancelResult = requestDAO.cancelDeliveryRequest(requestedBook);

        if (cancelResult == CANCELLED_SUCCESS) {
            requestDAO.changeAvailablity(book);
        }

        return cancelResult;
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.service.request.RequestService#returnBookRequest(int,
     * java.lang.String)
     */
    @Override
    @Transactional
    public String returnBookRequest(int requestId, String returnAddress) {
        // TODO Auto-generated method stub

        return requestDAO.returnBookRequest(requestId, returnAddress);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.request.RequestService#cancelReturnRequest(int)
     */
    @Override
    @Transactional
    public String cancelReturnRequest(int requestId) {
        // TODO Auto-generated method stub

        return requestDAO.cancelReturnRequest(requestId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.request.RequestService#checkSubscription(java.lang
     * .String)
     */
    @Override
    public Subscription checkSubscription(String userName) {
        // TODO Auto-generated method stub
        return requestDAO.checkSubscription(userName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.request.RequestService#getRequestedBookByBookId
     * (java.lang.String, in.co.impetus.db.model.BookSearch)
     */
    @Override
    public RequestBook getRequestedBookByBookId(String userName, BookSearch book) {
        // TODO Auto-generated method stub
        return requestDAO.getRequestedBook(userName, book);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.request.RequestService#getRequestedBookByReqId(int)
     */
    @Override
    public RequestBook getRequestedBookByReqId(int requestId) {
        // TODO Auto-generated method stub
        return requestDAO.getBookByRequestId(requestId);
    }

}
