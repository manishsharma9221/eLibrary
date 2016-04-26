/**
 * 
 * Copyright Impetus @2000-2014
 * 
 */
package in.co.impetus.db.dao;

import static in.co.impetus.constants.Constants.ADDED_SUCCESSFULLY;
import static in.co.impetus.constants.Constants.BOOK_ALREADY_IN_YOUR_SHELF;
import static in.co.impetus.constants.Constants.REMOVE_FAILURE;
import static in.co.impetus.constants.Constants.SUCCESS;
import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.BookShelf;
import in.co.impetus.db.model.Recommendation;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc

/**
 * The Class ShelfDAOImpl.
 * 
 * @author manish.sharma
 */

@Repository("shelfDAO")
public class ShelfDAOImpl implements ShelfDAO {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ShelfDAOImpl.class);

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /** The Constant FIVE. */
    private static final int FIVE=5;
    
    /** The Constant UNCHECKED. */
    private static final String UNCHECKED ="unchecked";
    
    /** The Constant USERNAME. */
    private static final String USERNAME = "userName";

    // Add to Shelf ************************************************************
    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.ShelfDAO#addToShelf(java.lang.String,
     * java.lang.String)
     */
    @Override
    public String addToShelf(String bid, String uid) {

        Session session = sessionFactory.getCurrentSession();
        try {
            String userId = uid;
            String bookId = bid;

            BookShelf shelf = new BookShelf();
            shelf.setBookId(bookId);
            shelf.setUserName(userId);

            session.save(shelf);

            return ADDED_SUCCESSFULLY;

        } catch (Exception e) {
            return BOOK_ALREADY_IN_YOUR_SHELF;
        } finally {
            session.setFlushMode(FlushMode.MANUAL);
        }
    }

    // Add to Shelf Ends
    // ********************************************************

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.ShelfDAO#showShelf(java.lang.String) This
     * Method is used for calling those books from the database which are
     * specific to user's personal shelf.
     */
    @SuppressWarnings(UNCHECKED)
    // Show Shelf
    // ***************************************************************
    @Override
    public List<BookSearch> showShelf(String uid) {

        Session session = sessionFactory.openSession();
        LOGGER.info("Hi" + uid);

        try {

            Criteria criteria = session.createCriteria(BookShelf.class);

            Criterion rest1 = Restrictions.eq(USERNAME, uid);

            criteria.add(rest1);
            criteria.addOrder(Order.desc("id"));

            List<BookShelf> resultRecords = criteria.list();

            @SuppressWarnings("rawtypes")
            ArrayList arrayList = new ArrayList();

            @SuppressWarnings("rawtypes")
            Iterator it = resultRecords.iterator();
            while (it.hasNext()) {

                BookShelf bookShelf = (BookShelf) it.next();

                Criteria criteria1 = session.createCriteria(BookSearch.class);
                criteria1.add(Restrictions.eq("bookId", bookShelf.getBookId()));

                List<BookSearch> bookRecord = criteria1.list();

                arrayList.add(bookRecord);

            }

            return arrayList;
        } finally {
            session.close();
        }

    }

    // Show Shelf Ends
    // **********************************************************

    // Delete Book
    // **************************************************************
    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.ShelfDAO#removeFromShelf(java.lang.String,
     * java.lang.String) This Method is used for Deleting the books from the
     * user's personal shelf.
     */
    @Override
    public String removeFromShelf(String uid, String bid) {

        Session session = sessionFactory.getCurrentSession();
        String userId = uid;
        String bookId = bid;

        try {
            String hql = "DELETE FROM BookShelf WHERE  userName = :uid and"
                    + " bookId = :bid";
            Query query = session.createQuery(hql);
            query.setParameter("uid", userId);
            query.setParameter("bid", bookId);

            query.executeUpdate();

            return SUCCESS;
        } catch (Exception e) {
            return REMOVE_FAILURE;
        }

    }

    // Delete Book Ends
    // *********************************************************

    // Show Requested Books
    // ***************************************************************

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.ShelfDAO#showRequestedBooks(java.lang.String)
     * This method is used for calling all those books from the books table
     * which are requested by user.
     */
    @Override
    public List<RequestBook> showRequestedBooks(String uid) {

        Session session = sessionFactory.openSession();
        LOGGER.info("Hi" + uid);

        try {

            Criteria criteria = session.createCriteria(RequestBook.class);

            Criterion rest1 = Restrictions.eq(USERNAME, uid);

            criteria.add(rest1);
            criteria.addOrder(Order.desc("requestId"));

            @SuppressWarnings({ UNCHECKED })
            List<RequestBook> resultRecords = criteria.list();

            return resultRecords;
        } catch (Exception e) {
            LOGGER.info("Exception in Showing Requested books" + e);
            return null;
        } finally {
            session.close();
        }

    }

    // Show Requested Books Ends
    // ************************************************

    // Show Holding Books
    // *******************************************************
    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.ShelfDAO#showBooksHolding(java.lang.String)
     * This method is used for calling all those books from the books table
     * which are delivered to the user. That is the user are holding these books
     */
    @Override
    public List<RequestBook> showBooksHolding(String uid) {

        LOGGER.info("Hi" + uid);
        Session session = sessionFactory.openSession();
        try {

            Criteria criteria = session.createCriteria(RequestBook.class);

            Criterion rest1 = Restrictions.eq(USERNAME, uid);
            Criterion rest2 = Restrictions.eq("deliveryStatus", "Delivered");

            criteria.add(Restrictions.and(rest1, rest2));
            criteria.addOrder(Order.desc("requestId"));

            @SuppressWarnings(UNCHECKED)
            List<RequestBook> resultRecords = criteria.list();

            return resultRecords;

        } catch (Exception e) {
            LOGGER.info("Exception in Holding Books Dao" + e);
            return null;
        } finally {
            session.close();
        }

    }

    // Show Requested Books Ends
    // ************************************************

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.ShelfDAO#getSubscription(java.lang.String)
     */
    @Override
    public List<Subscription> getSubscription(String userId) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
        try {

            Criteria criteria = session.createCriteria(Subscription.class);

            Criterion rest1 = Restrictions.eq(USERNAME, userId);

            criteria.add(Restrictions.and(rest1));

            criteria.addOrder(Order.desc("subscriptionId"));

            @SuppressWarnings(UNCHECKED)
            List<Subscription> resultRecords = (List<Subscription>) criteria
            .list();

            return resultRecords;

        } catch (Exception e) {
            LOGGER.info("Exception in Getting Subscription History" + e);
            return null;
        } finally {
            session.close();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.ShelfDAO#showRecommendation(java.lang.String)
     */
    @SuppressWarnings(UNCHECKED)
    @Override
    public List<BookSearch> showRecommendation(String uid) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
        String searchCriteria = getMaxOccuringString(uid);

        try {
            Criteria criteria = session.createCriteria(BookSearch.class);

            Criterion rest1 = Restrictions.like("bookTitle", "%"
                    + searchCriteria + "%");
            Criterion rest2 = Restrictions.like("bookAuthor", "%"
                    + searchCriteria + "%");
            Criterion rest3 = Restrictions.like("bookCategory", "%"
                    + searchCriteria + "%");

            criteria.add(Restrictions.or(rest1, rest2, rest3));

            criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
            
            criteria.setMaxResults(FIVE);

            return criteria.list();
        } catch (Exception e) {
            LOGGER.info("Exception in Getting Recommended Books" + e);
            return null;
        } finally {
            session.close();
        }

    }

    /**
     * Gets the max occuring string.
     * 
     * @param userName
     *            the user name
     * @return the max occuring string
     */
    @SuppressWarnings(UNCHECKED)
    public String getMaxOccuringString(String userName) {
        Session session = sessionFactory.openSession();

        try {
            Criterion rest1 = Restrictions.eq(USERNAME, userName);

            Criteria criteria = session
                    .createCriteria(Recommendation.class)
                    .add(rest1)
                    .setProjection(
                            Projections
                            .projectionList()
                            .add(Projections
                                    .groupProperty("searchCriteria"))
                                    .add(Projections.rowCount(),
                                            "searchCriteria"))
                                            .addOrder(Order.desc("searchCriteria")).setMaxResults(1);

            for (Object[] result : (List<Object[]>) criteria.list()) {

                return result[0].toString();

            }
            return null;

        } catch (Exception e) {
            LOGGER.info("Exception in Getting MaxOccuring String " + e);
            return null;
        } finally {
            session.close();
        }

    }

}
