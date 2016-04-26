/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import in.co.impetus.db.model.Plans;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubscriptionPlansDao.
 */
public interface SubscriptionPlansDao

{

    /**
     * Insert row.
     * 
     * @param plans
     *            the plans
     */
    void insertPlan(Plans plans);

    /**
     * Gets the plans list.
     * 
     * @return the plans list
     */
    List<Plans> getPlansList();

    /**
     * Gets the row by id.
     * 
     * @param id
     *            the id
     * @return the row by id
     */
    Plans getPlanById(Integer id);

    /**
     * Delete row.
     * 
     * @param id
     *            the id
     */
    void deletePlan(Integer id);

}
