/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.service.subscriptionplan;

import in.co.impetus.db.model.Plans;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubscriptionPlanService.
 */
public interface SubscriptionPlanService {

    /**
     * Insert row.
     * 
     * @param plans
     *            the plans
     */
    void insertPlans(Plans plans);

    /**
     * Gets the plans list.
     * 
     * @return the plans list
     */
    List<Plans> getPlansList();

    /**
     * Gets the row by id.
     * 
     * @param planId
     *            the plan id
     * @return the row by id
     */
    Plans getPlanById(Integer planId);

    /**
     * Delete row.
     * 
     * @param planId
     *            the plan id
     */
    void deletePlan(Integer planId);
}
