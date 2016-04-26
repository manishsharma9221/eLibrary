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
 * The Class BookShelf.
 * 
 * @author manish.sharma
 */

@Entity
@Table(name = "bookshelf")
@SuppressWarnings("serial")
public class BookShelf implements Serializable {

    /** The user name. */
    @Column(name = "user_name")
    private String userName;

    /** The book id. */
    @Column(name = "book_id")
    private String bookId;

    /** The id. */
    @Id
    @GeneratedValue
    private int id;

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
     * Gets the book id.
     * 
     * @return the book id
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * Sets the book id.
     * 
     * @param bookId
     *            the new book id
     */
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the new id
     */
    public void setId(int id) {
        this.id = id;
    }

}
