/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import static in.co.impetus.constants.Constants.ADDED_SUCCESSFULLY;
import static org.junit.Assert.*;
import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.RequestBook;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class ShelfDAOImplTest.
 *
 * @author yash.khatri
 */

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/java/resources/applicationContext.xml"})
public class ShelfDAOImplTest {


	/** The shelf dao impl. */
	@Autowired
	private ShelfDAOImpl shelfDAOImpl;



	@Test
	public void testAddToShelf() {

		try{
			shelfDAOImpl.addToShelf("B21", "kingkrypton20@gmail.com");
			assertTrue(true);
		}
		catch(Exception e)
		{
			assertTrue(false);

		}

	}


	@Test
	public void testShowShelf() {
		try{
			List<BookSearch> shelf = shelfDAOImpl.showShelf("kingkrypton20@gmail.com");
			assertTrue(true);

		}
		catch(Exception e){
			assertTrue(false);


		}
	}


	@Test
	public void testRemoveFromShelf() {
		try{
			shelfDAOImpl.removeFromShelf("kingkrypton20@gmail.com", "N02");
			assertTrue(true);

		}catch(Exception e)
		{
			assertTrue(false);

		}

	}


	@Test
	public void testShowRequestedBooks() {
		try{
			List<RequestBook> rB = shelfDAOImpl.showRequestedBooks("kingkrypton20@gmail.com");
			assertTrue(true);

		}
		catch(Exception e)
		{
			assertTrue(false);

		}


	}

	/**
	 * Test show books holding.
	 */
	@Test
	public void testShowBooksHolding() {
		try{

			shelfDAOImpl.showBooksHolding("kingkrypton20@gmail.com");
			assertTrue(true);

		}catch(Exception e){
			assertTrue(false);

		}
	}



	/**
	 * Test get subscription.
	 */
	@Test
	public void testGetSubscription() {
		try{

			shelfDAOImpl.getSubscription("kingkrypton20@gmail.com");
			assertTrue(true);

		}catch(Exception e){
			assertTrue(false);

		}

	}


	/**
	 * Test show recommendation.
	 */
	@Test
	public void testShowRecommendation() {
		try{

			shelfDAOImpl.showRecommendation("kingkrypton20@gmail.com");
			assertTrue(true);

		}catch(Exception e){
			assertTrue(false);

		}
	}

	/**
	 * Test get max occuring string.
	 */
	@Test
	public void testGetMaxOccuringString() {
		try{

			shelfDAOImpl.getMaxOccuringString("kingkrypton20@gmail.com");
			assertTrue(true);

		}catch(Exception e){
			assertTrue(false);

		}
	}

	
	

}
