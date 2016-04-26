/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.service.userfunction;

import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.Users;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserFunctionService.
 */
public interface UserFunctionService {

    /**
     * Show recommended books.
     * 
     * @param userName
     *            the user name
     * @return the list
     */
    List<BookSearch> showRecommendedBooks(String userName);

    /**
     * Show profile.
     * 
     * @param userName
     *            the user name
     * @return the users
     */
    Users showProfile(String userName);

    /**
     * Save search criteria.
     * 
     * @param userName
     *            the user name
     * @param searchCriteria
     *            the search criteria
     */
    void saveSearchCriteria(String userName, String searchCriteria);

}
