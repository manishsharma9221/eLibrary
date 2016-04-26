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
 * The Class Roles.
 */
@Entity
@Table(name = "roles")
@SuppressWarnings("serial")
public class Roles implements Serializable {

    /** The sno. */
    @Id
    @GeneratedValue
    private int sno;

    /** The user name. */
    @Column(name = "user_name")
    private String userName;

    /** The role id. */
    @Column(name = "role_id")
    private String roleId;

    /**
     * Gets the sno.
     * 
     * @return the sno
     */
    public int getSno() {
        return sno;
    }

    /**
     * Sets the sno.
     * 
     * @param sno
     *            the new sno
     */
    public void setSno(int sno) {
        this.sno = sno;
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
     * Gets the role id.
     * 
     * @return the role id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * Sets the role id.
     * 
     * @param roleId
     *            the new role id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

  
    /**
     * Instantiates a new roles.
     * 
     * @param userName
     *            the user name
     * @param roleId
     *            the role id
     */
    public Roles(String userName, String roleId) {
        super();
        this.userName = userName;
        this.roleId = roleId;
    }

    /**
     * Instantiates a new roles.
     */
    public Roles() {
        super();
        // TODO Auto-generated constructor stub
    }

}
