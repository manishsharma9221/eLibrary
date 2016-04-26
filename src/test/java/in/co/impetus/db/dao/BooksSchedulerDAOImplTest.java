package in.co.impetus.db.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/java/resources/applicationContext.xml"})public class BooksSchedulerDAOImplTest {

	
	/** The book search dao impl. */
	@Autowired
	private BooksSchedulerDAOImpl booksSchedulerDAOImpl;
	
	@Test
	public void testAddBooks() {
		try{
			booksSchedulerDAOImpl.addBooks();
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	@Test
	public void testDeleteBooks() {
		try{
			booksSchedulerDAOImpl.deleteBooks();
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

}
