/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import java.util.List;

import in.co.impetus.db.model.Subscription;

// TODO: Auto-generated Javadoc
/**
 * The Interface PlanReminderDAO.
 */
public interface PlanReminderDAO {

    /**
     * Gets the users by month.
     * 
     * @return the users by month
     */
    List<Subscription> getUsersByMonth();

    /**
     * Gets the users by week.
     * 
     * @return the users by week
     */
    List<Subscription> getUsersByWeek();

    /**
     * Gets the users by days.
     * 
     * @return the users by days
     */
    List<Subscription> getUsersByDays();

    /**
     * Gets the user subscriptions.
     * 
     * @return the user subscriptions
     */
    List<Subscription> getUserSubscriptions();

    /**
     * Update subscription.
     * 
     * @param subscription
     *            the subscription
     */
    void updateSubscription(Subscription subscription);

}
