/**
 * 
 * Copyright Impetus @2000-2014
 * */
package in.co.impetus.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Subscription.
 */
/**
 * @author manish.sharma
 * 
 */
@Entity
@Table(name = "subscription")
@SuppressWarnings("serial")
public class Subscription implements Serializable {

    /**
     * The subscription id.
     * 
     */
    @Id
    @GeneratedValue
    @Column(name = "sid")
    private int subscriptionId;

    /** The user name. */
    @Column(name = "user_name")
    private String userName;

    /** The plan. */

    @Column(name = "pid")
    private int plan;

    /** The start date. */
    @Column(name = "startDate")
    private Date startDate;

    /** The end date. */
    @Column(name = "endDate")
    private Date endDate;

    /** The is active. */
    @Column(name = "isActive")
    private Boolean isActive;

    /** The max books. */
    @Column(name = "maxBooks")
    private int maxBooks;

    /** The price. */
    @Column(name = "price")
    private int price;

    /** The max days. */
    @Column(name = "maxDays")
    private int maxDays;

    /** The plan name. */
    @Column(name = "planName")
    private String planName;

    /**
     * Gets the max books.
     * 
     * @return the max books
     */
    public int getMaxBooks() {
        return maxBooks;
    }

    /**
     * Sets the max books.
     * 
     * @param maxBooks
     *            the new max books
     */
    public void setMaxBooks(int maxBooks) {
        this.maxBooks = maxBooks;
    }

    /**
     * Gets the price.
     * 
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price.
     * 
     * @param price
     *            the new price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Gets the max days.
     * 
     * @return the max days
     */
    public int getMaxDays() {
        return maxDays;
    }

    /**
     * Sets the max days.
     * 
     * @param maxDays
     *            the new max days
     */
    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }

    /**
     * Gets the plan name.
     * 
     * @return the plan name
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * Sets the plan name.
     * 
     * @param planName
     *            the new plan name
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * Getters-Setters:.
     * 
     * @return the subscription id
     */
    public int getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Sets the subscription id.
     * 
     * @param subscriptionId
     *            the new subscription id
     */
    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    /**
     * Gets the plan.
     *
     * @return the plan
     */
    public int getPlan() {
        return plan;
    }

    /**
     * Sets the plan.
     *
     * @param plan the new plan
     */
    public void setPlan(int plan) {
        this.plan = plan;
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
     * Gets the start date.
     * 
     * @return the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     * 
     * @param startDate
     *            the new start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date.
     * 
     * @return the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date.
     * 
     * @param endDate
     *            the new end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the checks if is active.
     * 
     * @return the checks if is active
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * Sets the checks if is active.
     * 
     * @param isActive
     *            the new checks if is active
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

   

    /**
     * Instantiates a new subscription.
     *
     * @param userName the user name
     * @param plan the plan
     * @param startDate the start date
     * @param endDate the end date
     * @param isActive the is active
     * @param maxBooks the max books
     * @param price the price
     * @param maxDays the max days
     * @param planName the plan name
     */
    public Subscription(String userName, int plan, Date startDate,
            Date endDate, Boolean isActive, int maxBooks, int price,
            int maxDays, String planName) {
        super();
        this.userName = userName;
        this.plan = plan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
        this.maxBooks = maxBooks;
        this.price = price;
        this.maxDays = maxDays;
        this.planName = planName;
    }

    /**
     * Instantiates a new subscription.
     */
    public Subscription() {
        super();
    }

}
