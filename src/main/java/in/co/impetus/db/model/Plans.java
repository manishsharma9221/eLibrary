/**
 * 
 * Copyright Impetus @2000-2014
 * */
package in.co.impetus.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Plans.
 * 
 * @author manish.sharma
 */
@Entity
@Table(name = "plans")
@SuppressWarnings("serial")
public class Plans implements Serializable {

    /** The plan id. */
    @Id
    @GeneratedValue
    @Column(name = "pid")
    private int planId;

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
     * Gets the plan id.
     * 
     * @return the plan id
     */
    public int getPlanId() {
        return planId;
    }

    /**
     * Sets the plan id.
     * 
     * @param planId
     *            the new plan id
     */
    public void setPlanId(int planId) {
        this.planId = planId;
    }

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
     * Instantiates a new plans.
     *
     * @param maxBooks the max books
     * @param price the price
     * @param maxDays the max days
     * @param planName the plan name
     */
    public Plans(int maxBooks, int price, int maxDays, String planName) {
        super();
        this.maxBooks = maxBooks;
        this.price = price;
        this.maxDays = maxDays;
        this.planName = planName;
    }

    /**
     * Instantiates a new plans.
     */
    public Plans() {
        super();
    }

}
