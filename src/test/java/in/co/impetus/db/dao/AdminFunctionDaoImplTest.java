/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.Plans;
import in.co.impetus.db.model.RequestBook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminFunctionDaoImplTest.
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/java/resources/applicationContext.xml"})
public class AdminFunctionDaoImplTest {

	/** The admin function dao. */
	@Autowired
	AdminFunctionDao adminFunctionDao;
			
	/**
	 * Test insert row.
	 */
	@Test
	public void testInsertRow() {
		try{
			    BookSearch bookSearch = new BookSearch();
		        bookSearch.setBookAuthor("bookAuthor");
		        bookSearch.setBookAvailablity(10);
		        bookSearch.setBookCategory("bookCategory");
		        bookSearch.setBookDescription("bookDescription");
		        bookSearch.setBookId("bookId");
		        bookSearch.setBookImage("bookImage");
		        bookSearch.setBookPublisher("bookPublisher");
		        bookSearch.setBookTitle("bookTitle");
		       		        
			adminFunctionDao.insertBook(bookSearch);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test get row by id.
	 */
	@Test
	public void testGetRowById() {
		try{
			adminFunctionDao.getBookById("B01");
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test delete row.
	 */
	@Test
	public void testDeleteRow() {
		try{
			adminFunctionDao.deleteBook("Test");
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test get booksearch list.
	 */
	@Test
	public void testGetAllBooks() {
		try{
		    
		    int start =0;
		    String search =null;
		    int columnNum=2;
		    String sortOrder ="desc";
		    int pageSize=10;
		    
			adminFunctionDao.getAllBooks(start, pageSize, search, columnNum, sortOrder);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}
    /**
     * Test get booksearch list.
     */
    @Test
    public void testGetAllBooks2() {
        try{
            
            int start =0;
            String search =null;
            int columnNum=2;
            String sortOrder ="asc";
            int pageSize=10;
            
            adminFunctionDao.getAllBooks(start, pageSize, search, columnNum, sortOrder);
            assertTrue(true);
        }catch(Exception e){
            assertTrue(false);
        }
    }
	/**
	 * Test show active delivery requests.
	 */
	@Test
	public void testShowActiveDeliveryRequests() {
		try{
			adminFunctionDao.showActiveDeliveryRequests();
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test show active return requests.
	 */
	@Test
	public void testShowActiveReturnRequests() {
		try{
			adminFunctionDao.showActiveReturnRequests();
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	
	/**
	 * Test accept delivery request.
	 */
	@Test
	public void testAcceptDeliveryRequest() {
		try{
			
			adminFunctionDao.acceptDeliveryRequest(344,"Delivered");
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test accept return request.
	 */
	@Test
	public void testAcceptReturnRequest() {
		try{
		    RequestBook requestBook = new RequestBook();
			adminFunctionDao.acceptReturnRequest(requestBook);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test view active users.
	 */
	@Test
	public void testViewActiveUsers() {
		try{
			adminFunctionDao.viewActiveUsers();
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	@Test
	public void testAddOrUpdateSubscriptions() {
		try{
			 Plans plan = new Plans(10, 10, 10, "Test");
			 List<Plans> plans = new ArrayList<Plans>();
			 plans.add(plan);
			adminFunctionDao.addOrUpdateSubscriptions(plans);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}
	 
	@Test
	public void testDeleteSubscriptions() {
		try{
			List<Plans> plans = new ArrayList<Plans>();
			Plans plan = new Plans(10, 10, 10, "Test");
			plans.add(plan);
			adminFunctionDao.addOrUpdateSubscriptions(plans);
			adminFunctionDao.deleteSubscriptions(plans);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	
	
	
}
