/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.service.planreminder;

import java.util.List;

import in.co.impetus.db.dao.PlanReminderDAO;
import in.co.impetus.db.model.Subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanReminderServiceImpl.
 */
@Service("planReminderService")
public class PlanReminderServiceImpl implements PlanReminderService {

    /** The plan reminder dao. */
    @Autowired
    private PlanReminderDAO planReminderDAO;

   
    /**
     * Sets the plan reminder dao.
     * 
     * @param planReminderDAO
     *            the new plan reminder dao
     */
    public void setPlanReminderDAO(PlanReminderDAO planReminderDAO) {
        this.planReminderDAO = planReminderDAO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.planreminder.PlanReminderService#getUsersByMonth()
     */
    @Override
    public List<Subscription> getUsersByMonth() {
        // TODO Auto-generated method stub

        return planReminderDAO.getUsersByMonth();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.planreminder.PlanReminderService#getUsersByWeek()
     */
    @Override
    public List<Subscription> getUsersByWeek() {
        // TODO Auto-generated method stub
        return planReminderDAO.getUsersByWeek();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.planreminder.PlanReminderService#getUsersByDays()
     */
    @Override
    public List<Subscription> getUsersByDays() {
        // TODO Auto-generated method stub
        return planReminderDAO.getUsersByDays();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.planreminder.PlanReminderService#getUserSubscriptions
     * ()
     */
    @Override
    public List<Subscription> getUserSubscriptions() {
        // TODO Auto-generated method stub
        return planReminderDAO.getUserSubscriptions();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.planreminder.PlanReminderService#updateSubscription
     * (in.co.impetus.db.model.Subscription)
     */
    @Override
    @Transactional
    public void updateSubscription(Subscription subscription) {
        // TODO Auto-generated method stub
        planReminderDAO.updateSubscription(subscription);

    }

}
