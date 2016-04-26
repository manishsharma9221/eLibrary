package in.co.impetus.db.model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.OutputStream;

import javax.mail.MessagingException;
import javax.mail.Multipart;

import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

public class BookSearchTest {

	
	@Test
	public void testBookSearch() {
		BookSearch bookSearch = new BookSearch();
		bookSearch.setBookAuthor("bookAuthor");
		bookSearch.setBookAvailablity(10);
		bookSearch.setBookCategory("bookCategory");
		bookSearch.setBookDescription("bookDescription");
		bookSearch.setBookId("bookId");
		bookSearch.setBookImage("bookImage");
		bookSearch.setBookPublisher("bookPublisher");
		bookSearch.setBookTitle("bookTitle");
		bookSearch.setSno("sno");
		MultipartFile file = null;
        bookSearch.setFile(file);
		
		assertEquals("bookAuthor",bookSearch.getBookAuthor());
		assertEquals(10,bookSearch.getBookAvailablity());
		assertEquals("bookCategory",bookSearch.getBookCategory());
		assertEquals("bookDescription",bookSearch.getBookDescription());
		assertEquals("bookId",bookSearch.getBookId());
		assertEquals("bookImage",bookSearch.getBookImage());
		assertEquals("bookPublisher",bookSearch.getBookPublisher());
		assertEquals("bookTitle",bookSearch.getBookTitle());
		assertEquals("sno",bookSearch.getSno());
		assertEquals(null,bookSearch.getFile());

	}

	

}
