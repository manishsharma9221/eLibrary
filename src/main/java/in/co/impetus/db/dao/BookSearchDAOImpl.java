/**
 * 
 * Copyright Impetus @2000-2014
 * 
 */

package in.co.impetus.db.dao;

import in.co.impetus.db.model.BookSearch;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class BookSearchDAOImpl.
 *
 * @author manish.sharma
 */

/**
 * 
 * This is an Implementation Class of BookSearchDAO Interface
 * 
 */
@Repository("bookSearchDAO")
public class BookSearchDAOImpl implements BookSearchDAO {

    /** The Constant FIVE. */
    private static final int FIVE=5;
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BookSearchDAOImpl.class);

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    // Searching Requested Books From Books
    // Table********************************
    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.BookSearchDAO#searchBooks(java.lang.String)
     */
    @Override
    public List<BookSearch> searchBooks(String searchCriteria) {
        Session session = sessionFactory.openSession();
        try {
            //
            LOGGER.info("inside booksearch impl..:" + searchCriteria);

            Criteria criteria = session.createCriteria(BookSearch.class);

            Criterion title = Restrictions.like("bookTitle", searchCriteria,
                    MatchMode.ANYWHERE).ignoreCase();

            Criterion author = Restrictions.like("bookAuthor", searchCriteria,
                    MatchMode.ANYWHERE).ignoreCase();

            Criterion category = Restrictions.like("bookCategory",
                    searchCriteria, MatchMode.ANYWHERE).ignoreCase();

            criteria.add(Restrictions.or(title, author, category));

            @SuppressWarnings("unchecked")
            List<BookSearch> resultRecords = criteria.list();

            return resultRecords;

        } finally {
            session.close();
        }

    }

    // Searching Ends
    // ***********************************************************

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.BookSearchDAO#getBookById(java.lang.String)
     */
    @Override
    public BookSearch getBookById(String bookId) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
        try {
            //

            Criteria criteria = session.createCriteria(BookSearch.class);

            Criterion rest1 = Restrictions.eq("bookId", bookId);

            criteria.add(rest1);

            BookSearch resultRecords = (BookSearch) criteria.uniqueResult();

            return resultRecords;

        } finally {
            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.BookSearchDAO#getRecentBooksList()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<BookSearch> getRecentBooksList() {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
        try {
            Query query = session
                    .createQuery("from BookSearch b order by b.sno desc");

            query.setFirstResult(0);
          
            query.setMaxResults(FIVE);
            return (List<BookSearch>) query.list();
        } catch (Exception e) {
            LOGGER.info("Exception in recent books " + e);
            return null;

        } finally {
            session.close();
        }

    }

}
