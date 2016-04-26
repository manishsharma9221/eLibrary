/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
// TODO: Auto-generated Javadoc
import javax.persistence.Transient;

// TODO: Auto-generated Javadoc
/**
 * The Class Users.
 * 
 * @author manish.sharma
 */

@Entity
@Table(name = "users")
@SuppressWarnings("serial")
public class Users implements Serializable {

    /** The user name. */
    @Id
    @Column(name = "user_name")
    private String userName;

    /** The user password. */
    @Column(name = "user_password")
    private String userPassword;

    /** The mobile. */
    @Column(name = "mobile")
    private String mobile;

    /** The address. */
    @Column(name = "address")
    private String address;

    /** The pincode. */
    @Column(name = "pincode")
    private int pincode;

    /** The first name. */
    @Column(name = "first_name")
    private String firstName;

    /** The last name. */
    @Column(name = "last_name")
    private String lastName;

    /** The state. */
    @Column(name = "state")
    private String state;

    /** The city. */
    @Column(name = "city")
    private String city;

    /** The primary language. */
    @Column(name = "primary_language")
    private String primaryLanguage;

    /** The secondary language. */
    @Column(name = "secondary_language")
    private String secondaryLanguage;

    /** The plan id. */
    @Transient
    private int planId;

    /** The enabled. */
    @Column(name = "enabled")
    private boolean enabled;

    /**
     * Checks if is enabled.
     * 
     * @return true, if is enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the enabled.
     * 
     * @param enabled
     *            the new enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Gets the primary language.
     * 
     * @return the primary language
     */
    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    /**
     * Sets the primary language.
     * 
     * @param primaryLanguage
     *            the new primary language
     */
    public void setPrimaryLanguage(String primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
    }

    /**
     * Gets the secondary language.
     * 
     * @return the secondary language
     */
    public String getSecondaryLanguage() {
        return secondaryLanguage;
    }

    /**
     * Sets the secondary language.
     * 
     * @param secondaryLanguage
     *            the new secondary language
     */
    public void setSecondaryLanguage(String secondaryLanguage) {
        this.secondaryLanguage = secondaryLanguage;
    }

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
     * @param subscriptionId
     *            the new plan id
     */
    public void setPlanId(int subscriptionId) {
        this.planId = subscriptionId;
    }

    /**
     * Gets the mobile.
     * 
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the mobile.
     * 
     * @param mobile
     *            the new mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the address.
     * 
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     * 
     * @param address
     *            the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the pincode.
     * 
     * @return the pincode
     */
    public int getPincode() {
        return pincode;
    }

    /**
     * Sets the pincode.
     * 
     * @param pincode
     *            the new pincode
     */
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    /**
     * Gets the first name.
     * 
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     * 
     * @param firstName
     *            the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     * 
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     * 
     * @param lastName
     *            the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * Gets the user password.
     * 
     * @return the user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets the user password.
     * 
     * @param userPassword
     *            the new user password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Gets the state.
     * 
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     * 
     * @param state
     *            the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the city.
     * 
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     * 
     * @param country
     *            the new city
     */
    public void setCity(String country) {
        this.city = country;
    }

   

    /**
     * Instantiates a new users.
     */
   /* public Users(String userName, String userPassword, String mobile,
            String address, int pincode, String firstName, String lastName,
            String state, String city, String primaryLanguage,
            String secondaryLanguage, int planId, boolean enabled) {
        super();
        this.userName = userName;
        this.userPassword = userPassword;
        this.mobile = mobile;
        this.address = address;
        this.pincode = pincode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.city = city;
        this.primaryLanguage = primaryLanguage;
        this.secondaryLanguage = secondaryLanguage;
        this.planId = planId;
        this.enabled = enabled;
    }*/

    /**
     * Instantiates a new users.
     */
    public Users() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

}
