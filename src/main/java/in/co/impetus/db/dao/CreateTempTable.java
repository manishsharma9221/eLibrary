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
//@Transactional(readOnly = false)
/**
 * The Class CreateTempTable.
 */
@Repository
public class CreateTempTable {

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CreateTempTable.class);

    /**
     * Creates the table.
     */
    public void createTable() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            String create = "CREATE TABLE temp_table (book_title varchar(2000),book_author varchar(2000),book_category varchar(2000),book_description varchar(5000),book_publisher varchar(2000),book_availablity int(10),book_image varchar(1000),book_id varchar(2000))";
            SQLQuery query = session.createSQLQuery(create);
            query.executeUpdate();
            session.getTransaction().commit();

            session.beginTransaction();
            String csvDataRead = " LOAD DATA  INFILE '" + "d://bookbiz.csv"
                    + "' INTO TABLE temp_table "
                    + " FIELDS TERMINATED BY \',\' ENCLOSED BY \'\"'"
                    + " LINES TERMINATED BY \'\\r\\n\'";
            query = session.createSQLQuery(csvDataRead);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.info("Exception in Adding Books Via Schedular");
        } finally {
            session.close();
        }

    }

    /**
     * Creates the delete table.
     */
    public void createDeleteTable() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            String create = "CREATE TABLE temp_delete (book_title varchar(20),book_author varchar(20))";
            SQLQuery query = session.createSQLQuery(create);
            query.executeUpdate();
            session.getTransaction().commit();

            session.beginTransaction();
            String csvDataRead = " LOAD DATA  INFILE '"
                    + "D://bookForDelete.csv" + "' INTO TABLE temp_delete "
                    + " FIELDS TERMINATED BY \',\' ENCLOSED BY \'\"'"
                    + " LINES TERMINATED BY \'\\r\\n\'";
            query = session.createSQLQuery(csvDataRead);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.info("Exception in Deleting Via Schedular" + e);

        } finally {

            session.close();
        }
    }

}
