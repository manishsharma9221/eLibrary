/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestBook.
 * 
 * @author manish.sharma
 */

@Entity
@Table(name = "request")
@SuppressWarnings("serial")
public class RequestBook implements Serializable {

    /** The request id. */
    @Id
    @GeneratedValue
    @Column(name = "r_id")
    private int requestId;

    /** The user name. */
    @Column(name = "user_name")
    private String userName;

    /** The delivery status. */
    @Column(name = "delivery_status")
    private String deliveryStatus;

    /** The return status. */
    @Column(name = "return_status")
    private String returnStatus;

    /** The delivery request date. */
    @Column(name = "b_req_s_date")
    private Date deliveryRequestDate;

    /** The delivery date. */
    @Column(name = "b_deliveredon")
    private Date deliveryDate;

    /** The return request date. */
    @Column(name = " b_ret_req_date")
    private Date returnRequestDate;

    /** The return date. */
    @Column(name = "b_returnedon")
    private Date returnDate;

    /** The del req cancel date. */
    @Column(name = "del_req_can_on")
    private Date delReqCancelDate;

    /** The ret req cancel date. */
    @Column(name = "ret_req_can_on")
    private Date retReqCancelDate;

    /** The delivery address. */
    @Column(name = "deliveryaddress")
    private String deliveryAddress;

    /** The return address. */
    @Column(name = "returnaddress")
    private String returnAddress;

    /** The book search. */
    @ManyToOne
    @JoinColumn(name = "b_id")
    private BookSearch bookSearch;

    /**
     * Gets the delivery address.
     * 
     * @return the delivery address
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Sets the delivery address.
     * 
     * @param deliveryAddress
     *            the new delivery address
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Gets the return address.
     * 
     * @return the return address
     */
    public String getReturnAddress() {
        return returnAddress;
    }

    /**
     * Sets the return address.
     * 
     * @param returnAddress
     *            the new return address
     */
    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress;
    }

    /**
     * Gets the book search.
     * 
     * @return the book search
     */
    public BookSearch getBookSearch() {
        return bookSearch;
    }

    /**
     * Sets the book search.
     * 
     * @param bookSearch
     *            the new book search
     */
    public void setBookSearch(BookSearch bookSearch) {
        this.bookSearch = bookSearch;
    }

    /**
     * Gets the request id.
     * 
     * @return the request id
     */
    public int getRequestId() {
        return requestId;
    }

    /**
     * Sets the request id.
     * 
     * @param requestId
     *            the new request id
     */
    public void setRequestId(int requestId) {
        this.requestId = requestId;
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
     * Gets the delivery status.
     * 
     * @return the delivery status
     */
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    /**
     * Sets the delivery status.
     * 
     * @param deliveryStatus
     *            the new delivery status
     */
    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    /**
     * Gets the return status.
     * 
     * @return the return status
     */
    public String getReturnStatus() {
        return returnStatus;
    }

    /**
     * Sets the return status.
     * 
     * @param returnStatus
     *            the new return status
     */
    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    /**
     * Gets the delivery request date.
     * 
     * @return the delivery request date
     */
    public Date getDeliveryRequestDate() {
        return deliveryRequestDate;
    }

    /**
     * Sets the delivery request date.
     * 
     * @param deliveryRequestDate
     *            the new delivery request date
     */
    public void setDeliveryRequestDate(Date deliveryRequestDate) {
        this.deliveryRequestDate = deliveryRequestDate;
    }

    /**
     * Gets the delivery date.
     * 
     * @return the delivery date
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the delivery date.
     * 
     * @param deliveryDate
     *            the new delivery date
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * Gets the return request date.
     * 
     * @return the return request date
     */
    public Date getReturnRequestDate() {
        return returnRequestDate;
    }

    /**
     * Sets the return request date.
     * 
     * @param returnRequestDate
     *            the new return request date
     */
    public void setReturnRequestDate(Date returnRequestDate) {
        this.returnRequestDate = returnRequestDate;
    }

    /**
     * Gets the return date.
     * 
     * @return the return date
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the return date.
     * 
     * @param returnDate
     *            the new return date
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * Gets the del req cancel date.
     * 
     * @return the del req cancel date
     */
    public Date getDelReqCancelDate() {
        return delReqCancelDate;
    }

    /**
     * Sets the del req cancel date.
     * 
     * @param delReqCancelDate
     *            the new del req cancel date
     */
    public void setDelReqCancelDate(Date delReqCancelDate) {
        this.delReqCancelDate = delReqCancelDate;
    }

    /**
     * Gets the ret req cancel date.
     * 
     * @return the ret req cancel date
     */
    public Date getRetReqCancelDate() {
        return retReqCancelDate;
    }

    /**
     * Sets the ret req cancel date.
     * 
     * @param retReqCancelDate
     *            the new ret req cancel date
     */
    public void setRetReqCancelDate(Date retReqCancelDate) {
        this.retReqCancelDate = retReqCancelDate;
    }

    
}
