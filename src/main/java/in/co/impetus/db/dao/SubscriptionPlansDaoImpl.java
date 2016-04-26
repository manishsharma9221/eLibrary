/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import in.co.impetus.db.model.Plans;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class SubscriptionPlansDaoImpl.
 */
@Repository("subscriptionPlansDao")
public class SubscriptionPlansDaoImpl implements SubscriptionPlansDao {

    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(SubscriptionPlansDaoImpl.class);

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.db.dao.SubscriptionPlansDao#insertRow(in.co.impetus.db.
     * model.Plans)
     */
    public void insertPlan(Plans plans) {
        template.saveOrUpdate(plans);
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.SubscriptionPlansDao#getPlansList()
     */
    @Override
    public List<Plans> getPlansList() {
        // TODO Auto-generated method stub

        Session session = sessionFactory.openSession();
        try {
            //

            Criteria criteria = session.createCriteria(Plans.class);

            @SuppressWarnings("unchecked")
            List<Plans> resultRecords = criteria.list();

            return resultRecords;

        } finally {
            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.db.dao.SubscriptionPlansDao#getRowById(java.lang.Integer)
     */
    @Override
    public Plans getPlanById(Integer planId) {
        // TODO Auto-generated method stub
        try {
            return template.get(Plans.class, planId);
        } catch (Exception e) {
            LOGGER.info("Exception in geeting plan by id" + e);
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.db.dao.SubscriptionPlansDao#deleteRow(java.lang.Integer)
     */

    public void deletePlan(Integer planid) {
        // TODO Auto-generated method stub
        Plans plans = new Plans();
        plans.setPlanId(planid);
        template.delete(plans);
    }

}
