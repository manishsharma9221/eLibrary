/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Recommendation.
 */
/**
 * @author manish.sharma
 * 
 */
@Entity
@Table(name = "recommendation")
@SuppressWarnings("serial")
public class Recommendation implements Serializable {

    /** The rec id. */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int recId;

    /** The user name. */
    @Column(name = "userName")
    private String userName;

    /** The search criteria. */
    @Column(name = "searchCriteria")
    private String searchCriteria;

    /**
     * Gets the rec id.
     * 
     * @return the rec id
     */
    public int getRecId() {
        return recId;
    }

    /**
     * Sets the rec id.
     * 
     * @param recId
     *            the new rec id
     */
    public void setRecId(int recId) {
        this.recId = recId;
    }

    /**
     * Gets the user name.
     * 
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     * 
     * @param userName
     *            the new user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the search criteria.
     * 
     * @return the search criteria
     */
    public String getSearchCriteria() {
        return searchCriteria;
    }

    /**
     * Sets the search criteria.
     * 
     * @param searchCriteria
     *            the new search criteria
     */
    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

   
}
