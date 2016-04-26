/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class BooksSchedulerDAOImpl.
 */
@Repository
public class BooksSchedulerDAOImpl implements BooksSchedulerDAOInterface

{

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BooksSchedulerDAOImpl.class);

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /** The create temp table. */
    @Autowired
    private CreateTempTable createTempTable;

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.BooksSchedulerDAOInterface#addBooks()
     */
    @Override
    public void addBooks() {

        Session session = sessionFactory.getCurrentSession();
        try {
            createTempTable.createTable();

            SQLQuery query = session.createSQLQuery("CALL add_books()");
            query.executeUpdate();

        } catch (Exception e) {
            LOGGER.error("Exception in Calling Procedures" + e);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.BooksSchedulerDAOInterface#deleteBooks()
     */
    @Override
    public void deleteBooks() {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        try {
            createTempTable.createDeleteTable();

            SQLQuery query = session.createSQLQuery("CALL delete_books()");
            query.executeUpdate();

        } catch (Exception e) {
            LOGGER.error("Exception in Calling Procedures" + e);

        }

    }

}
