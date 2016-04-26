/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import static org.junit.Assert.assertTrue;
import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.RequestBook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestDAOImplTest.
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/java/resources/applicationContext.xml"})
public class RequestDAOImplTest {

	/** The request dao impl. */
	@Autowired
	private RequestDAOImpl requestDAOImpl;


	/**
	 * Test count requested books.
	 */
	@Test
	public void testCountRequestedBooks() {
		try{
			requestDAOImpl.countRequestedBooks("kingkrypton20@gmail.com");
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test count holding books.
	 */
	@Test
	public void testCountHoldingBooks() {
		try{
			requestDAOImpl.countHoldingBooks("kingkrypton20@gmail.com");
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test check subscription.
	 */
	@Test
	public void testCheckSubscription() {
		try{
			requestDAOImpl.checkSubscription("kingkrypton20@gmail.com");
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test cancel delivery request.
	 */
	@Test
	public void testCancelDeliveryRequest() {
		try{
		    RequestBook requestBook = new RequestBook();
			requestDAOImpl.cancelDeliveryRequest(requestBook);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test return book request.
	 */
	@Test
	public void testReturnBookRequest() {
		try{
			requestDAOImpl.returnBookRequest(344, "Dhar");
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test cancel return request.
	 */
	@Test
	public void testCancelReturnRequest() {
		try{
			requestDAOImpl.cancelReturnRequest(344);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test request book.
	 */
	@Test
	public void testRequestBook() {
		try{
			requestDAOImpl.requestBook("kingkrypton20@gmail.com", "B50", "Dhar");
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test change availablity.
	 */
	@Test
	public void testChangeAvailablity() {
		try{
		    BookSearch book = new BookSearch();
            book.setBookAuthor("bookAuthor");
            book.setBookAvailablity(10);
            book.setBookCategory("bookCategory");
            book.setBookDescription("bookDescription");
            book.setBookId("bookId");
            book.setBookImage("bookImage");
            book.setBookPublisher("bookPublisher");
            book.setBookTitle("bookTitle");
			requestDAOImpl.changeAvailablity(book);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test get book by request id.
	 */
	@Test
	public void testGetBookByRequestId() {
		try{
			requestDAOImpl.getBookByRequestId(344);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test check if already requested.
	 */
	@Test
	public void testCheckIfAlreadyRequested() {
		try{
		    BookSearch book = new BookSearch();
            book.setBookAuthor("bookAuthor");
            book.setBookAvailablity(10);
            book.setBookCategory("bookCategory");
            book.setBookDescription("bookDescription");
            book.setBookId("bookId");
            book.setBookImage("bookImage");
            book.setBookPublisher("bookPublisher");
            book.setBookTitle("bookTitle");
			requestDAOImpl.changeAvailablity(book);
			requestDAOImpl.checkIfAlreadyRequested("kingkrypton20@gmail.com", book);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test get requested book.
	 */
	@Test
	public void testGetRequestedBook() {
		try{
		    BookSearch book = new BookSearch();
            book.setBookAuthor("bookAuthor");
            book.setBookAvailablity(10);
            book.setBookCategory("bookCategory");
            book.setBookDescription("bookDescription");
            book.setBookId("bookId");
            book.setBookImage("bookImage");
            book.setBookPublisher("bookPublisher");
            book.setBookTitle("bookTitle");
			requestDAOImpl.getRequestedBook("kingkrypton20@gmail.com", book);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	
	
}
