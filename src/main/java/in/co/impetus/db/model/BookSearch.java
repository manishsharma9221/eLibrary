/**
 * 
 * Copyright Impetus @2000-2014
 * 
 */
package in.co.impetus.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

// TODO: Auto-generated Javadoc
/**
 * The Class BookSearch.
 * 
 * @author manish.sharma
 */

@Entity
@Table(name = "books")
@SuppressWarnings("serial")
public class BookSearch implements Serializable {

    /** The book title. */
    @Column(name = "book_title")
    private String bookTitle;

    /** The book author. */
    @Column(name = "book_author")
    private String bookAuthor;

    /** The book category. */
    @Column(name = "book_category")
    private String bookCategory;

    /** The book description. */
    @Column(name = "book_description")
    private String bookDescription;

    /** The book publisher. */
    @Column(name = "book_publisher")
    private String bookPublisher;

    /** The book availablity. */
    @Column(name = "book_availablity")
    private int bookAvailablity;

    /** The book image. */
    @Column(name = "book_image")
    private String bookImage;

    /** The book id. */
    @Id
    @Column(name = "book_id")
    private String bookId;

    /** The sno. */
    @Column(name = "sno")
    @GeneratedValue
    private String sno;

    /** The file. */
    @Transient
    private MultipartFile file;

    /**
     * Gets the file.
     * 
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * Sets the file.
     * 
     * @param file
     *            the new file
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * Gets the sno.
     * 
     * @return the sno
     */
    public String getSno() {
        return sno;
    }

    /**
     * Sets the sno.
     * 
     * @param sno
     *            the new sno
     */
    public void setSno(String sno) {
        this.sno = sno;
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
     * Gets the book title.
     * 
     * @return the book title
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Sets the book title.
     * 
     * @param bookTitle
     *            the new book title
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * Gets the book author.
     * 
     * @return the book author
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * Sets the book author.
     * 
     * @param bookAuthor
     *            the new book author
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    /**
     * Gets the book category.
     * 
     * @return the book category
     */
    public String getBookCategory() {
        return bookCategory;
    }

    /**
     * Sets the book category.
     * 
     * @param bookCategory
     *            the new book category
     */
    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    /**
     * Gets the book description.
     * 
     * @return the book description
     */
    public String getBookDescription() {
        return bookDescription;
    }

    /**
     * Sets the book description.
     * 
     * @param bookDescription
     *            the new book description
     */
    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    /**
     * Gets the book publisher.
     * 
     * @return the book publisher
     */
    public String getBookPublisher() {
        return bookPublisher;
    }

    /**
     * Sets the book publisher.
     * 
     * @param bookPublisher
     *            the new book publisher
     */
    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    /**
     * Gets the book availablity.
     * 
     * @return the book availablity
     */
    public int getBookAvailablity() {
        return bookAvailablity;
    }

    /**
     * Sets the book availablity.
     * 
     * @param bookAvailablity
     *            the new book availablity
     */
    public void setBookAvailablity(int bookAvailablity) {
        this.bookAvailablity = bookAvailablity;
    }

    /**
     * Gets the book image.
     * 
     * @return the book image
     */
    public String getBookImage() {
        return bookImage;
    }

    /**
     * Sets the book image.
     * 
     * @param bookImage
     *            the new book image
     */
    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

   
    /**
     * Instantiates a new book search.
     */
    public BookSearch() {
        super();
    }

}
