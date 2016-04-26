package in.co.impetus.db.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookShelfTest {

	@Test
	public void test() {
		BookShelf bookShelf = new BookShelf();
		
		bookShelf.setBookId("bookId");
		bookShelf.setId(1);
		bookShelf.setUserName("userName");
		
		assertEquals("bookId",bookShelf.getBookId());
		assertEquals(1,bookShelf.getId());
		assertEquals("userName",bookShelf.getUserName());

		
		

	}

}
