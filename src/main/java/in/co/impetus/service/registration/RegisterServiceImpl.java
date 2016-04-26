/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.service.registration;

import in.co.impetus.db.dao.RegisterDao;
import in.co.impetus.db.dao.RequestDAO;
import in.co.impetus.db.model.Plans;
import in.co.impetus.db.model.Subscription;
import in.co.impetus.db.model.Users;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import in.co.impetus.db.model.Roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static in.co.impetus.constants.Constants.*;

// TODO: Auto-generated Javadoc

/**
 * The Class RegisterServiceImpl.
 */
@Repository
public class RegisterServiceImpl implements RegisterService {

    /** The register dao. */
    @Autowired
    private RegisterDao registerDao;

    /** The request dao. */
    @Autowired
    private RequestDAO requestDAO;

    /** The calendar. */
    private Calendar calendar = Calendar.getInstance();



    /**
     * Sets the register dao.
     * 
     * @param registerDao
     *            the new register dao
     */
    public void setRegisterDao(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }



    /**
     * Sets the request dao.
     * 
     * @param requestDAO
     *            the new request dao
     */
    public void setRequestDAO(RequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.registration.RegisterService#insertRow(in.co.impetus
     * .db.model.Users)
     */
    @Transactional
    public void insertUser(Users users) {
        users.setEnabled(true);
        registerDao.insertUser(users);

        insertSubscription(users.getUserName(), users.getPlanId());
        String userName = users.getUserName();
        insertRoles(userName);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.registration.RegisterService#updateUser(in.co.impetus
     * .db.model.Users)
     */
    @Transactional
    public void updateUser(Users users) {
        users.setEnabled(true);
        registerDao.insertUser(users);

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.service.registration.RegisterService#getUsersList()
     */
    public List<Users> getUsersList() {
        return registerDao.getUsersList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.registration.RegisterService#getRowById(java.lang
     * .String)
     */
    @Override
    public Users getUserById(String userName) {
        return registerDao.getUserById(userName);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.registration.RegisterService#deleteRow(java.lang
     * .String)
     */
    @Override
    @Transactional
    public void deleteUser(String userName) {
        registerDao.deleteUser(userName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.registration.RegisterService#insertSubscription
     * (java.lang.String, int)
     */
    @Override
    @Transactional
    public void insertSubscription(String userName, int planId) {
        // TODO Auto-generated method stub

        Plans plan = registerDao.getPlanById(planId);

        Subscription subscription = new Subscription();

        Date startDate = new Date();

        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, plan.getMaxDays());
        Date endDate = calendar.getTime();

        subscription.setPlan(planId);
        subscription.setUserName(userName);
        subscription.setStartDate(startDate);
        subscription.setEndDate(endDate);
        subscription.setMaxBooks(plan.getMaxBooks());
        subscription.setMaxDays(plan.getMaxDays());
        subscription.setPlanName(plan.getPlanName());
        subscription.setPrice(plan.getPrice());
        subscription.setIsActive(true);

        registerDao.insertSubscription(subscription);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.registration.RegisterService#upgradeSubscription
     * (java.lang.String, int)
     */
    @Override
    @Transactional
    public String upgradeSubscription(String userName, int planId) {
        // TODO Auto-generated method stub

        Subscription oldsubs = requestDAO.checkSubscription(userName);
        boolean flag = true;
      
            int requestedBooks = requestDAO.countRequestedBooks(userName);
            int holdingBooks = requestDAO.countHoldingBooks(userName);

            int total = requestedBooks + holdingBooks;
            if (total != 0) {
                flag = false;
            }
      

        if (flag) {
            Plans plan = registerDao.getPlanById(planId);
            Subscription subscription = new Subscription();

            Date startDate = new Date();

            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, plan.getMaxDays());
            Date endDate = calendar.getTime();

            subscription.setPlan(planId);
            subscription.setUserName(userName);
            subscription.setStartDate(startDate);
            subscription.setEndDate(endDate);
            subscription.setMaxBooks(plan.getMaxBooks());
            subscription.setMaxDays(plan.getMaxDays());
            subscription.setPlanName(plan.getPlanName());
            subscription.setPrice(plan.getPrice());
            subscription.setIsActive(true);

            if (oldsubs != null) {
                oldsubs.setIsActive(false);
                registerDao.insertSubscription(oldsubs);
            }
            registerDao.insertSubscription(subscription);
            return PLAN_UPGRADED;
        } else {
            return PLAN_FAILURE;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.registration.RegisterService#checkAvailability(
     * java.lang.String)
     */
    @Override
    public Boolean checkAvailability(String userName) {
        // TODO Auto-generated method stub
        return registerDao.checkAvailability(userName);
    }

    /**
     * Insert roles.
     * 
     * @param userName
     *            the user name
     */
    @Transactional
    public void insertRoles(String userName) {
        Roles roles = new Roles();
        roles.setRoleId("ROLE_USER");
        roles.setUserName(userName);
        registerDao.insertRoles(roles);

    }
}
