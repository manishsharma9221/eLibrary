/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import in.co.impetus.db.model.Plans;
import in.co.impetus.db.model.Recommendation;
import in.co.impetus.db.model.Roles;
import in.co.impetus.db.model.Subscription;
import in.co.impetus.db.model.Users;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterDaoImpl.
 */
@Repository("registerDAO")
public class RegisterDaoImpl implements RegisterDao {

    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(RegisterDaoImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.db.dao.RegisterDao#insertRow(in.co.impetus.db.model.Users)
     */

    public void insertUser(Users users) {
        template.saveOrUpdate(users);
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.RegisterDao#getUsersList()
     */
    @Override
    public List<Users> getUsersList() {

        return template.findByExample(new Users());
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.RegisterDao#getUserById(java.lang.String)
     */
    @Override
    public Users getUserById(String userName) {
        Session session = sessionFactory.openSession();

        try {

            Criteria criteria = session.createCriteria(Users.class);

            Criterion rest1 = Restrictions.eq("userName", userName);

            criteria.add(rest1);

            Users user = (Users) criteria.uniqueResult();

            return user;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.RegisterDao#deleteRow(java.lang.String)
     */

    @Override
    public void deleteUser(String userName) {
        Users user = new Users();
        user.setUserName(userName);
        template.delete(user);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.db.dao.RegisterDao#insertSubscription(in.co.impetus.db.
     * model.Subscription)
     */
    @Override
    public void insertSubscription(Subscription subscription) {
        // TODO Auto-generated method stub
        template.saveOrUpdate(subscription);

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.RegisterDao#getPlanById(int)
     */
    @Override
    public Plans getPlanById(int planId) {
        // TODO Auto-generated method stub
        try {
            return template.get(Plans.class, planId);
        } catch (Exception e) {

            return null;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.db.dao.RegisterDao#saveSearchCriteria(java.lang.String,
     * java.lang.String)
     */
    @Override
    public void saveSearchCriteria(String userName, String searchCriteria) {
        // TODO Auto-generated method stub
        Recommendation recommendation = new Recommendation();
        recommendation.setSearchCriteria(searchCriteria);
        recommendation.setUserName(userName);
        template.saveOrUpdate(recommendation);
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.RegisterDao#checkAvailability(java.lang.String)
     */
    @Override
    public Boolean checkAvailability(String userName) {
        Session session = sessionFactory.openSession();
        try {
            Criteria cr = session.createCriteria(Users.class);
            cr.add(Restrictions.eq("userName", userName));
            @SuppressWarnings("unchecked")
            List<Users> result = cr.list();
            LOGGER.info("List" + result);
            if (result.isEmpty()) {
                LOGGER.info("Username Available");
                return true;
            } else {
                LOGGER.info("Username Not Available");
                return false;
            }
        } finally {
            session.close();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.db.dao.RegisterDao#insertRoles(in.co.impetus.db.model.Roles
     * )
     */
    @Override
    public void insertRoles(Roles roles) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        session.save(roles);
    }

}
