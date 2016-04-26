package in.co.impetus.db.model;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class RequestBookTest {

	@Test
	public void test() {
		RequestBook requestBook = new RequestBook();

		BookSearch bookSearch = new BookSearch();	
		requestBook.setBookSearch(bookSearch);
		
		requestBook.setDeliveryAddress("deliveryAddress");
		
		Date date = new Date(new java.util.Date().getTime());
		requestBook.setDeliveryDate(date);
	    
		requestBook.setDeliveryRequestDate(date);
	    requestBook.setDeliveryStatus("deliveryStatus");
	    requestBook.setDelReqCancelDate(date);
	    requestBook.setRequestId(10);
	    requestBook.setRetReqCancelDate(date);
	    requestBook.setReturnAddress("returnAddress");
	    requestBook.setReturnDate(date);
	    requestBook.setReturnRequestDate(date);
	    requestBook.setReturnStatus("returnStatus");
	    requestBook.setUserName("userName");

		assertEquals(bookSearch,requestBook.getBookSearch());
		assertEquals("deliveryAddress",requestBook.getDeliveryAddress());
		assertEquals(date,requestBook.getDeliveryDate());
		assertEquals(date,requestBook.getDeliveryRequestDate());
		assertEquals("deliveryStatus",requestBook.getDeliveryStatus());
		assertEquals(date,requestBook.getDelReqCancelDate());
		assertEquals(10,requestBook.getRequestId());
		assertEquals(date,requestBook.getRetReqCancelDate());
		assertEquals("returnAddress",requestBook.getReturnAddress());
		assertEquals(date,requestBook.getReturnDate());
		assertEquals(date,requestBook.getReturnRequestDate());
		assertEquals("returnStatus",requestBook.getReturnStatus());
		assertEquals("userName",requestBook.getUserName());


		
		



	
	}

}
