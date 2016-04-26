/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import in.co.impetus.db.model.BookSearch;

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface PdfGenDAO.
 */
public interface PdfGenDAO {

    /**
     * Gets the reports.
     * 
     * @param author
     *            the author
     * @param category
     *            the category
     * @param from
     *            the from
     * @param to
     *            the to
     * @return the reports
     */
    List<Object[]> getReports(String author, String category, Date from, Date to);

    /**
     * Gets the distinct auth.
     * 
     * @return the distinct auth
     */
    List<BookSearch> getDistinctAuth();

    /**
     * Gets the distinct cat.
     * 
     * @return the distinct cat
     */
    List<BookSearch> getDistinctCat();

}
