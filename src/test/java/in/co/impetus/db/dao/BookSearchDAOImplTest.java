/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import static org.junit.Assert.*;

import java.sql.Date;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class BookSearchDAOImplTest.
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/java/resources/applicationContext.xml"})
public class BookSearchDAOImplTest {

	
	/** The book search dao impl. */
	@Autowired
	private BookSearchDAOImpl bookSearchDAOImpl;

	/**
	 * Test search books.
	 */
	@Test
	public void testSearchBooks() {
		try{
			bookSearchDAOImpl.searchBooks("novels");
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
		
	}

	/**
	 * Test get book by id.
	 */
	@Test
	public void testGetBookById() {
		try{
			bookSearchDAOImpl.getBookById("B01");
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test get recent books list.
	 */
	@Test
	public void testGetRecentBooksList() {
		try{
			bookSearchDAOImpl.getRecentBooksList();
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}
	
}
