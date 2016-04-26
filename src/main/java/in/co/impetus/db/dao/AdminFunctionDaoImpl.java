/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import static in.co.impetus.constants.Constants.ADDED_SUCCESSFULLY;
import static in.co.impetus.constants.Constants.FAILURE;
import static in.co.impetus.constants.Constants.SAME_BOOKID;
import static in.co.impetus.constants.Constants.SUCCESS;
import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.Plans;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminFunctionDaoImpl.
 */
@Repository
public class AdminFunctionDaoImpl implements AdminFunctionDao {

    /** The template. */
    @Autowired
    private HibernateTemplate template = null;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AdminFunctionDaoImpl.class);
    /** The Constant FIVE. */
    private static final int FIVE=5;
    /** The Constant THREE. */
    private static final int THREE=3;

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.db.dao.AdminFunctionDao#insertRow(in.co.impetus.db.model
     * .BookSearch)
     */
    public String insertBook(BookSearch books) {
        Session session = sessionFactory.getCurrentSession();
        try {

            session.saveOrUpdate(books);
            return ADDED_SUCCESSFULLY;
        } catch (Exception e) {
            LOGGER.info("Exception Caught in Adding Books " + e);
            return SAME_BOOKID;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.AdminFunctionDao#getRowById(java.lang.String)
     */
    @Override
    public BookSearch getBookById(String bookId) {

        return template.get(BookSearch.class, bookId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.AdminFunctionDao#deleteRow(java.lang.String)
     */

    public String deleteBook(String bookId) {

        BookSearch book = new BookSearch();
        book.setBookId(String.valueOf(bookId));

        Session session = sessionFactory.getCurrentSession();

        try {
            String hql = "DELETE FROM BookSearch WHERE  " + " bookId = :bookId";
            Query query = session.createQuery(hql);
            query.setParameter("bookId", bookId);

            query.executeUpdate();

            return "Deleted Successfully";
        } catch (Exception e) {
            return "Cannot Delete this book, it is already in use";
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.AdminFunctionDao#showActiveDeliveryRequests()
     */
    @Override
    public List<RequestBook> showActiveDeliveryRequests() {
        // TODO Auto-generated method stub
        RequestBook requestBook = new RequestBook();
        requestBook.setDeliveryStatus("Pending");
        return template.findByExample(requestBook);
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.AdminFunctionDao#showActiveReturnRequests()
     */
    @Override
    public List<RequestBook> showActiveReturnRequests() {
        // TODO Auto-generated method stub
        RequestBook requestBook = new RequestBook();
        requestBook.setReturnStatus("Return Requested");
        return template.findByExample(requestBook);
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.AdminFunctionDao#acceptDeliveryRequest(int,
     * java.lang.String)
     */
    @Override
    public String acceptDeliveryRequest(int requestId, String action) {
        // TODO Auto-generated method stub
        LOGGER.info("In returnBookRequest DAO: Request Id Reached" + requestId);

        Session session = sessionFactory.getCurrentSession();
        try {
            Criteria criteria = session.createCriteria(RequestBook.class);

            Criterion rest1 = Restrictions.eq("requestId", requestId);

            criteria.add(rest1);

            RequestBook rB = (RequestBook) criteria.uniqueResult();

            Date date = new Date(new java.util.Date().getTime());
            rB.setDeliveryStatus(action);
            rB.setDeliveryDate(date);
            session.save(rB);
            return SUCCESS;

        } catch (Exception e) {
            LOGGER.info("Exception in Accepting Delivery Request" + e);
            return FAILURE;

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.AdminFunctionDao#acceptReturnRequest(int)
     */
    @Override
    public String acceptReturnRequest(RequestBook rB) {


        Session session = sessionFactory.getCurrentSession();
        try {

            Date date = new Date(new java.util.Date().getTime());

            rB.setReturnStatus("Closed");
            rB.setReturnDate(date);
            session.saveOrUpdate(rB);
            return SUCCESS;

        } catch (Exception e) {
            LOGGER.info("Exception in Accepting Delivery Request" + e);
            return FAILURE;

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.db.dao.AdminFunctionDao#viewActiveUsers()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Subscription> viewActiveUsers() {
        // TODO Auto-generated method stub

        Session session = sessionFactory.openSession();
        List<Subscription> users = null;

        Criteria criteria = session.createCriteria(Subscription.class);
        criteria.add(Restrictions.eq("isActive", true));

        try {
            users = criteria.list();
            return users;
        } catch (Exception e) {
            LOGGER.info("exception in viewActive users" + e);
            return users;

        } finally {
            session.close();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.db.dao.AdminFunctionDao#addOrUpdateSubscriptions(java.util
     * .List)
     */
    @Override
    public String addOrUpdateSubscriptions(List<Plans> plans) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();

        try {
            for (Plans p : plans) {
                Criteria criteria = session.createCriteria(Plans.class);

                Criterion rest1 = Restrictions.eq("planName", p.getPlanName());

                criteria.add(rest1);

                Plans plan = (Plans) criteria.uniqueResult();

                if (plan != null) {
                    LOGGER.info("Plan not null");
                    plan.setMaxBooks(p.getMaxBooks());
                    plan.setMaxDays(p.getMaxDays());
                    plan.setPrice(p.getPrice());

                    template.saveOrUpdate(plan);

                } else {

                    template.saveOrUpdate(p);

                }
            }
            return "Success";
        } catch (Exception e) {
            LOGGER.info("Exception in dao " + e);
        }
        return "Failure";

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.db.dao.AdminFunctionDao#deleteSubscriptions(java.util.List)
     */
    @Override
    public String deleteSubscriptions(List<Plans> plans) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();

        try {

            for (Plans p : plans) {
                Criteria criteria = session.createCriteria(Plans.class);

                Criterion rest1 = Restrictions.eq("planName", p.getPlanName());

                criteria.add(rest1);

                Plans plan = (Plans) criteria.uniqueResult();

                session.delete(plan);

            }
            return "Success";
        } catch (Exception e) {

            LOGGER.info("Exception in deleting plans" + e);
        }

        return "Cannot Delete";
    }

    @SuppressWarnings("unchecked")
    public List<BookSearch> getAllBooks(int start, int pageSize,
            String search,
            int columnNum, String sortOrder) {
        // TODO Auto-generated method stub

        try{

            Session session = sessionFactory.getCurrentSession();

            Criteria criteria = session.createCriteria(BookSearch.class);

            String col = "sno";

            if (columnNum == 2) {
                col = "bookCategory";
            }
            if (columnNum == THREE) {
                col = "bookTitle";
            }
            if (columnNum == FIVE) {
                col = "bookAuthor";
            }

            criteria.add(Restrictions.disjunction()
                    .add(Restrictions.like("bookTitle", search, MatchMode.ANYWHERE))
                    .add(Restrictions.like("bookCategory", search, MatchMode.ANYWHERE))
                    .add(Restrictions.like("bookAuthor", search, MatchMode.ANYWHERE)));

            if(sortOrder.equals("asc")){
                criteria.addOrder(Order.asc(col));
            }
            else{
                criteria.addOrder(Order.desc(col));
            }
            criteria.setFirstResult(start);


            criteria.setFirstResult(start);
            criteria.setMaxResults(pageSize);

            return criteria.list();
        }       
        catch (Exception e) {

            LOGGER.info("Exception Caught in Searching Books " + e);
            return null;
        }
    }

    public int getTotalRecordsOfBooks() {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        String hql = "select count(*) from BookSearch";
        Query query = session.createQuery(hql);
        return (int) (long) query.list().get(0);
    }


}
