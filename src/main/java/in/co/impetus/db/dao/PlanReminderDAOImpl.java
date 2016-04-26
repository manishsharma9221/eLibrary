/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import in.co.impetus.db.model.Subscription;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanReminderDAOImpl.
 */
@Repository("planRemainderDAO")
public class PlanReminderDAOImpl implements PlanReminderDAO {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PlanReminderDAOImpl.class);

    /** The calendar. */
    private Calendar calendar = Calendar.getInstance();

    /** The session factory. */
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    
    /** The Constant THIRTY. */
    private static final int THIRTY=30;
    
    /** The Constant SEVEN. */
    private static final int SEVEN=7;
    
    /** The Constant UNCHECKED. */
    private static final String UNCHECKED ="unchecked";
    
    /** The Constant ENDDATE. */
    private static final String ENDDATE ="endDate";
    
    /** The Constant DATEFORMAT. */
    private static final String DATEFORMAT ="yyyy-MM-dd";



    /* (non-Javadoc)
     * @see in.co.impetus.db.dao.PlanReminderDAO#getUsersByMonth()
     */
    @Override
    public List<Subscription> getUsersByMonth() {
        // TODO Auto-generated method stub

        calendar.setTime(new Date());
       
        calendar.add(Calendar.DATE, THIRTY);
        Date endDate = calendar.getTime();
        Date newEndDate = null;

        DateFormat outputDateFormat = new SimpleDateFormat(DATEFORMAT,
                Locale.ENGLISH);
        outputDateFormat.setTimeZone(TimeZone.getDefault());

        String dateString1 = outputDateFormat.format(endDate);
        try {
            newEndDate = new java.sql.Date(outputDateFormat.parse(dateString1)
                    .getTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            LOGGER.error("Exception in parsing Date in getUsersByMonth" + e);
        }

        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(Subscription.class);

            Criterion endDateRest = Restrictions.eq(ENDDATE, newEndDate);

            criteria.add(endDateRest);

            @SuppressWarnings(UNCHECKED)
            List<Subscription> result = criteria.list();
            LOGGER.info("result:-" + result);

            return result;
        } catch (Exception e) {
            LOGGER.info("Exception caught in getting users by month in dao");
            return null;
        } finally {
            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.PlanReminderDAO#getUsersByWeek()
     */
    @Override
    public List<Subscription> getUsersByWeek() {

        calendar.setTime(new Date());
        
        calendar.add(Calendar.DATE, SEVEN);
        Date endDate = calendar.getTime();
        Date newEndDate = null;

        DateFormat outputDateFormat = new SimpleDateFormat(DATEFORMAT,
                Locale.ENGLISH);
        outputDateFormat.setTimeZone(TimeZone.getDefault());

        String dateString1 = outputDateFormat.format(endDate);
        try {
            newEndDate = new java.sql.Date(outputDateFormat.parse(dateString1)
                    .getTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            LOGGER.error("Exception in parsing in getUsersByWeek" + e);
        }

        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(Subscription.class);

            Criterion endDateRest = Restrictions.eq(ENDDATE, newEndDate);

            criteria.add(endDateRest);

            @SuppressWarnings(UNCHECKED)
            List<Subscription> result = criteria.list();
            LOGGER.info("result:-" + result);
            return result;
        } catch (Exception e) {
            LOGGER.info("Exception caught in getting users by week " + e);
            return null;
        } finally {
            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.PlanReminderDAO#getUsersByDays()
     */
    @Override
    public List<Subscription> getUsersByDays() {
        // TODO Auto-generated method stub
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 1);
        Date endDate = calendar.getTime();
        Date newEndDate = null;

        DateFormat outputDateFormat = new SimpleDateFormat(DATEFORMAT,
                Locale.ENGLISH);
        outputDateFormat.setTimeZone(TimeZone.getDefault());

        String dateString1 = outputDateFormat.format(endDate);
        try {
            newEndDate = new java.sql.Date(outputDateFormat.parse(dateString1)
                    .getTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            LOGGER.error("Exception in parsing in getUsersByDays" + e);
        }

        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(Subscription.class);

            Criterion endDateRest = Restrictions.eq(ENDDATE, newEndDate);

            criteria.add(endDateRest);

            @SuppressWarnings(UNCHECKED)
            List<Subscription> result = criteria.list();

            LOGGER.info("List ->" + result);
            return result;
        } catch (Exception e) {
            LOGGER.info("Exception caught in getting users by days " + e);
            return null;
        } finally {
            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.PlanReminderDAO#getUserSubscriptions()
     */
    @SuppressWarnings(UNCHECKED)
    @Override
    public List<Subscription> getUserSubscriptions() {
        calendar.setTime(new Date());
        Date endDate = calendar.getTime();
        Date newEndDate = null;

        DateFormat outputDateFormat = new SimpleDateFormat(DATEFORMAT,
                Locale.ENGLISH);
        outputDateFormat.setTimeZone(TimeZone.getDefault());

        String dateString1 = outputDateFormat.format(endDate);
        try {
            newEndDate = new java.sql.Date(outputDateFormat.parse(dateString1)
                    .getTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            LOGGER.error("Exception in parsing in getUserSubscription" + e);
        }
        LOGGER.info("New End Date" + newEndDate);

        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(Subscription.class);

            Criterion endDateRest = Restrictions.eq(ENDDATE, newEndDate);

            criteria.add(endDateRest);

            return criteria.list();
        } catch (Exception e) {
            LOGGER.info("Exception caught in getting user subscriptions " + e);
            return null;
        } finally {
            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.db.dao.PlanReminderDAO#updateSubscription(in.co.impetus
     * .db.model.Subscription)
     */
    @Override
    public void updateSubscription(Subscription subscription) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();

        try {

            session.saveOrUpdate(subscription);

        } catch (Exception e) {
            LOGGER.info("Exception in dao expiring subscriptions" + e);
        }

    }

}
