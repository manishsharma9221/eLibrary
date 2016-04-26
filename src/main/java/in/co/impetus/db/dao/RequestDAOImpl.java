/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import static in.co.impetus.constants.Constants.ALREADY_CANCELLED;
import static in.co.impetus.constants.Constants.ALREADY_DELIVERED;
import static in.co.impetus.constants.Constants.ALREADY_REQUESTED;
import static in.co.impetus.constants.Constants.CANCELLED_SUCCESS;
import static in.co.impetus.constants.Constants.FAILURE;
import static in.co.impetus.constants.Constants.REQUESTED_SUCCESSFULLY;
import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestDAOImpl.
 */
@Repository("requestDAO")
public class RequestDAOImpl implements RequestDAO {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(RequestDAOImpl.class);

    /** The session factory. */
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    /** The Constant REQUESTID. */
    private static final String REQUESTID ="requestId";
    
    /** The Constant USERNAME. */
    private static final String USERNAME = "userName";


    /* (non-Javadoc)
     * @see in.co.impetus.db.dao.RequestDAO#countRequestedBooks(java.lang.String)
     */
    @Override
    public Integer countRequestedBooks(String uid) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(RequestBook.class);

            Criterion rest1 = Restrictions.eq(USERNAME, uid);

            Criterion rest2 = Restrictions.eq("deliveryStatus", "Pending");

            criteria.add(Restrictions.and(rest1, rest2));

            int requestedBooks = criteria.list().size();

            return requestedBooks;

        } catch (Exception e) {

            LOGGER.info("Exception in Counting Books " + e);
            return 0;

        }

        finally {

            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.RequestDAO#countHoldingBooks(java.lang.String)
     */
    @Override
    public Integer countHoldingBooks(String uid) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
        String delivered = "Delivered";
        String closed = "Closed";

        try {
            Criteria criteria = session.createCriteria(RequestBook.class);

            Criterion rest1 = Restrictions.eq(USERNAME, uid);

            Criterion rest2 = Restrictions.eq("deliveryStatus", delivered);

            Criterion rest3 = Restrictions.ne("returnStatus", closed);

            criteria.add(Restrictions.and(rest1, rest2, rest3));

            int holdingBooks = criteria.list().size();

            return holdingBooks;

        } catch (Exception e) {

            LOGGER.info("Exception in Counting Books " + e);
            return 0;

        }

        finally {

            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.RequestDAO#checkSubscription(java.lang.String)
     */
    @Override
    public Subscription checkSubscription(String uid) {
        // TODO Auto-generated method stub

        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(Subscription.class);

            LOGGER.info("user Id reached " + uid);
            Criterion rest1 = Restrictions.eq(USERNAME, uid);
            Criterion rest2 = Restrictions.eq("isActive", true);

            criteria.add(Restrictions.and(rest1, rest2));

            Subscription subscription = (Subscription) criteria.uniqueResult();
            LOGGER.info("Subscription received " + subscription);
            return subscription;
        } catch (Exception e) {

            LOGGER.info("Exception in checking Subscription " + e);
            return null;

        }

        finally {

            session.close();
        }

    }

    // Cancel Delivery
    // Request***************************************************
    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.ShelfDAO#cancelDeliveryRequest(int,
     * java.lang.String) This method is used to set the Delivery status as
     * Cancel when the user cancels any bookDelivery Request
     */
    @Override
    public String cancelDeliveryRequest(RequestBook rB) {
        // TODO Auto-generated method stub
      

        Session session = sessionFactory.getCurrentSession();

        Date date = new Date(new java.util.Date().getTime());

        try {
            
            LOGGER.info("in cancel deli" + rB.getDeliveryStatus());

            String checkDeliveryStatus = rB.getDeliveryStatus();
            if (checkDeliveryStatus.equals("Delivered")) {
                return ALREADY_DELIVERED;
            } else {
                if (checkDeliveryStatus.equals("Cancelled")) {
                    return ALREADY_CANCELLED;
                } else {
                    rB.setDeliveryStatus("Cancelled");
                    rB.setDelReqCancelDate(date);

                    session.saveOrUpdate(rB);
                    LOGGER.info("Session saved successfully ??");
                    return CANCELLED_SUCCESS;
                }
            }
        } catch (Exception e) {
            LOGGER.info("Exception in Cancelling Delivery Request" + e);
            return FAILURE;

        } 
    }

    // Cancel Delivery Request
    // Ends**********************************************

    // Return Book Request
    // ******************************************************
    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.ShelfDAO#returnBookRequest(int,
     * java.lang.String) This method is used for setting the status of
     * returnBookStatus to Pending which was earlier NuLL
     */
    @Override
    public String returnBookRequest(int requestId, String returnAddress) {
        // TODO Auto-generated method stub
        LOGGER.info("In returnBookRequest DAO: Request Id Reached" + requestId);

        Session session = sessionFactory.getCurrentSession();
        Date date = new Date(new java.util.Date().getTime());
        try {
            Criteria criteria = session.createCriteria(RequestBook.class);

            Criterion rest1 = Restrictions.eq(REQUESTID, requestId);

            criteria.add(rest1);

            RequestBook rB = (RequestBook) criteria.uniqueResult();
            rB.setReturnStatus("Return Requested ");
            rB.setReturnRequestDate(date);
            rB.setReturnAddress(returnAddress);
            session.save(rB);

            return REQUESTED_SUCCESSFULLY;
        } catch (Exception e) {
            LOGGER.info("Exception in Return Request" + e);
            return FAILURE;

        }

    }

    // Return Book Request Ends
    // *************************************************

    // Cancel Return Book Request
    // ***********************************************
    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.ShelfDAO#returnBookRequest(int,
     * java.lang.String) This method is used for setting the status of
     * returnBookStatus to Pending which was earlier NuLL
     */
    @Override
    public String cancelReturnRequest(int requestId) {
        // TODO Auto-generated method stub
        LOGGER.info("In returnBookRequest DAO: Request Id Reached" + requestId);

        Session session = sessionFactory.getCurrentSession();
        try {
            Criteria criteria = session.createCriteria(RequestBook.class);

            Criterion rest1 = Restrictions.eq(REQUESTID, requestId);

            criteria.add(rest1);

            RequestBook rB = (RequestBook) criteria.uniqueResult();

            Date date = new Date(new java.util.Date().getTime());

            String checkReturnStatus = rB.getReturnStatus();
            if (checkReturnStatus.equals("Return Requested ")) {
                rB.setReturnStatus("Cancelled ");
                rB.setRetReqCancelDate(date);
                session.save(rB);

                return CANCELLED_SUCCESS;
            } else {
                return "Cannot Cancel";
            }
        } catch (Exception e) {
            LOGGER.info("Exception in Cancelling Return Request" + e);
            return FAILURE;

        }
    }

    // cancelReturnRequest Ends
    // *************************************************

    // Request Book
    // *************************************************************
    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.ShelfDAO#requestBook(java.lang.String,
     * java.lang.String, java.lang.String) This method is used for adding the
     * books to the request table for individual user. and setting the parameter
     * for requestBookStatus as pending The Status will be set Delivered by the
     * admin when the admin will process this request.
     */
    @Override
    public String requestBook(String uid, String bid, String deliveryAddress) {

        Session session = sessionFactory.getCurrentSession();

        try {
            String userId = uid;
            String bookId = bid;

            LOGGER.info(bookId);
            LOGGER.info(userId);

            Date date = new Date(new java.util.Date().getTime());

            RequestBook requestBook = new RequestBook();

            BookSearch bookSearch = new BookSearch();
            bookSearch.setBookId(bookId);

            requestBook.setBookSearch(bookSearch);
            requestBook.setUserName(userId);
            requestBook.setDeliveryRequestDate(date);
            requestBook.setDeliveryStatus("Pending");
            requestBook.setDeliveryAddress(deliveryAddress);

            LOGGER.info("in request book Dao");
            LOGGER.info("in dao request book"
                    + requestBook.getBookSearch().getBookId());
            LOGGER.info(requestBook.getUserName());

            session.save(requestBook);

            return REQUESTED_SUCCESSFULLY;
        } catch (Exception e) {
            LOGGER.info("Exception in dao already requested");
            return ALREADY_REQUESTED;
        }

    }

    // Request Book Ends
    // ********************************************************

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.db.dao.RequestDAO#changeAvailablity(in.co.impetus.db.model
     * .BookSearch)
     */
    @Override
    public Boolean changeAvailablity(BookSearch booksearch) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();

        try {

            session.saveOrUpdate(booksearch);

            return true;
        } catch (Exception e) {
            LOGGER.info("Exception in changing availablity of books " +e);
            return false;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.RequestDAO#getBookByRequestId(int)
     */
    @Override
    public RequestBook getBookByRequestId(int requestId) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();

        try {

            Criteria criteria = session.createCriteria(RequestBook.class);

            Criterion rest1 = Restrictions.eq(REQUESTID, requestId);

            criteria.add(rest1);

            RequestBook resultRecords = (RequestBook) criteria.uniqueResult();

            return resultRecords;
        } catch (Exception e) {
            LOGGER.info("Exception in Showing Requested books" + e);
            return null;
        } finally {
            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.db.dao.RequestDAO#checkIfAlreadyRequested(java.lang.String,
     * in.co.impetus.db.model.BookSearch)
     */
    @Override
    public List<RequestBook> checkIfAlreadyRequested(String uid, BookSearch book) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();

        try {

            Criteria criteria = session.createCriteria(RequestBook.class);

            Criterion rest1 = Restrictions.eq(USERNAME, uid);
            Criterion rest2 = Restrictions.eq("bookSearch", book);

            criteria.add(Restrictions.and(rest1, rest2));

            @SuppressWarnings({ "unchecked" })
            List<RequestBook> resultRecords = (List<RequestBook>) criteria
            .list();

            return resultRecords;
        } catch (Exception e) {
            LOGGER.info("Exception in Checking If Requested books" + e);
            return null;
        } finally {
            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.RequestDAO#getRequestedBook(java.lang.String,
     * in.co.impetus.db.model.BookSearch)
     */
    @Override
    public RequestBook getRequestedBook(String uid, BookSearch book) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();

        try {

            Criteria criteria = session.createCriteria(RequestBook.class);

            Criterion rest1 = Restrictions.eq(USERNAME, uid);
            Criterion rest2 = Restrictions.eq("bookSearch", book);
            Criterion rest3 = Restrictions.eq("deliveryStatus", "Pending");

            criteria.add(Restrictions.and(rest1, rest2, rest3));

            RequestBook resultRecords = (RequestBook) criteria.uniqueResult();

            return resultRecords;
        } catch (Exception e) {
            LOGGER.info("Exception in Checking If Requested books" + e);
            return null;
        } finally {
            session.close();
        }

    }

}
