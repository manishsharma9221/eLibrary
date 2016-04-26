/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import in.co.impetus.db.model.BookSearch;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfGenDAOImpl.
 */
@Repository("pdfGenDAO")
public class PdfGenDAOImpl implements PdfGenDAO {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PdfGenDAOImpl.class);

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.PdfGenDAO#getReports(java.util.List,
     * java.util.Date, java.util.Date)
     */
    @Override
    public List<Object[]> getReports(String author, String category,
            Date fromDate, Date toDate) {
        // TODO Auto-generated method stub

        Session session = sessionFactory.openSession();

        LOGGER.info("Author" + author);
        LOGGER.info("Category" + author);
        LOGGER.info("From Date" + fromDate);
        LOGGER.info("To Date" + toDate);

        try {

            String commonQuery ="SELECT b.book_category as category,b.book_author as author,b.book_title as title,COUNT(*)total, SUM(CASE WHEN delivery_status='Cancelled' THEN 1 ELSE 0 END) cancelled,SUM(CASE WHEN return_status='Closed' THEN 1 ELSE 0 END)returned,SUM(CASE WHEN delivery_status='Delivered' THEN 1 ELSE 0 END)delivered FROM request,books b WHERE b_deliveredon BETWEEN '"
                    + fromDate
                    + "' AND '"
                    + toDate;
            
            String query;
            
            String all = "all";

            if (author.equalsIgnoreCase(all)
                    && category.equalsIgnoreCase(all)) {

                query = commonQuery
                        + "'  AND b_id=b.book_id GROUP BY b_id";
            } else if (author.equalsIgnoreCase(all)) {
                query = commonQuery
                        + "'  AND b_id=b.book_id AND book_category='"
                        + category + "' GROUP BY b_id";
            } else if (category.equalsIgnoreCase(all)) {
                query = commonQuery
                        + "'  AND b_id=b.book_id AND book_author='"
                        + author
                        + "'GROUP BY b_id";
            } else {
                query = commonQuery
                        + "'  AND b_id=b.book_id AND book_category='"
                        + category
                        + "' AND book_author='"
                        + author
                        + "'GROUP BY b _id";
            }

            SQLQuery q = session.createSQLQuery(query);

            @SuppressWarnings("unchecked")
            List<Object[]> pdfList = (List<Object[]>) q.list();

            return pdfList;

        } catch (Exception e) {
            LOGGER.info("Exception in DAO ->" + e);
            return null;
        } finally {
            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.PdfGenDAO#getDistinctAuth()
     */
    @Override
    public List<BookSearch> getDistinctAuth() {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
        try {

            Criteria criteria = session.createCriteria(BookSearch.class)
                    .setProjection(
                            Projections.distinct(Projections
                                    .property("bookAuthor")));

            @SuppressWarnings("unchecked")
            List<BookSearch> resultRecords = (List<BookSearch>) criteria.list();
            LOGGER.info("LIST RETREIVED" + resultRecords);
            return resultRecords;

        } catch (Exception e) {
            LOGGER.info("Exception caught in Getting Books for Report" + e);
            return null;
        } finally {
            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.PdfGenDAO#getDistinctCat()
     */
    @Override
    public List<BookSearch> getDistinctCat() {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
        try {

            Criteria criteria = session.createCriteria(BookSearch.class)
                    .setProjection(
                            Projections.distinct(Projections
                                    .property("bookCategory")));

            @SuppressWarnings("unchecked")
            List<BookSearch> resultRecords = (List<BookSearch>) criteria.list();
            LOGGER.info("LIST RETREIVED" + resultRecords);
            return resultRecords;

        } catch (Exception e) {
            LOGGER.info("Exception caught in Getting Distinct Categories " + e);
            return null;
        } finally {
            session.close();
        }

    }

}
