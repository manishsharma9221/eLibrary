/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.service.registration;

import in.co.impetus.db.model.Users;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface RegisterService.
 */
public interface RegisterService {

    /**
     * Insert row.
     * 
     * @param users
     *            the users
     */
    void insertUser(Users users);

    /**
     * Gets the users list.
     * 
     * @return the users list
     */
    List<Users> getUsersList();

    /**
     * Gets the row by id.
     * 
     * @param userName
     *            the user name
     * @return the row by id
     */
    Users getUserById(String userName);

    /**
     * Delete row.
     * 
     * @param userName
     *            the user name
     */
    void deleteUser(String userName);

    /**
     * Insert subscription.
     * 
     * @param userName
     *            the user name
     * @param planId
     *            the plan id
     */
    void insertSubscription(String userName, int planId);

    /**
     * Update user.
     * 
     * @param users
     *            the users
     */
    void updateUser(Users users);

    /**
     * Upgrade subscription.
     * 
     * @param userName
     *            the user name
     * @param planId
     *            the plan id
     * @return the string
     */
    String upgradeSubscription(String userName, int planId);

    /**
     * Check availability.
     * 
     * @param userName
     *            the user name
     * @return the boolean
     */
    Boolean checkAvailability(String userName);

}
