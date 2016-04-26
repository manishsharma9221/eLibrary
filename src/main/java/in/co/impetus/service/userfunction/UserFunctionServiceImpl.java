/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.service.userfunction;

import in.co.impetus.db.dao.RegisterDao;
import in.co.impetus.db.dao.ShelfDAO;
import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class UserFunctionServiceImpl.
 */
@Service("userFunctionService")
public class UserFunctionServiceImpl implements UserFunctionService {

  
    /** The register dao. */
    @Autowired
    private RegisterDao registerDao;

    /** The shelf dao. */
    @Autowired
    private ShelfDAO shelfDAO;



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
     * Sets the shelf dao.
     * 
     * @param shelfDAO
     *            the new shelf dao
     */
    public void setShelfDAO(ShelfDAO shelfDAO) {
        this.shelfDAO = shelfDAO;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.userfunction.UserFunctionService#showRecommendedBooks
     * (java.lang.String)
     */
    @Override
    public List<BookSearch> showRecommendedBooks(String userName) {
        // TODO Auto-generated method stub
        return shelfDAO.showRecommendation(userName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.userfunction.UserFunctionService#showProfile(java
     * .lang.String)
     */
    @Override
    public Users showProfile(String userName) {
       // TODO Auto-generated method stub
     
        return registerDao.getUserById(userName);
      
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.userfunction.UserFunctionService#saveSearchCriteria
     * (java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public void saveSearchCriteria(String userName, String searchCriteria) {
        // TODO Auto-generated method stub
        registerDao.saveSearchCriteria(userName, searchCriteria);
    }

}
