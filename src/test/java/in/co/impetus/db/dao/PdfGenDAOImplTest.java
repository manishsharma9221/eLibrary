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
 * The Class PdfGenDAOImplTest.
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/java/resources/applicationContext.xml"})
public class PdfGenDAOImplTest {

	/** The pdf gen dao impl. */
	@Autowired
	private PdfGenDAOImpl pdfGenDAOImpl;

	/**
	 * Test get reports.
	 */
	@Test
	public void testGetReports()
	{

		try{
			Date date = new Date(new java.util.Date().getTime());
			pdfGenDAOImpl.getReports("Chetan Bhagat", "novels", date, date);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetReportsAll()
	{

		try{
			Date date = new Date(new java.util.Date().getTime());
			pdfGenDAOImpl.getReports("all", "all", date, date);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetReportsAllAuthors()
	{

		try{
			Date date = new Date(new java.util.Date().getTime());
			pdfGenDAOImpl.getReports("all", "novels", date, date);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetReportsAllCategories()
	{

		try{
			Date date = new Date(new java.util.Date().getTime());
			pdfGenDAOImpl.getReports("Chetan Bhagat", "all", date, date);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test get distinct auth.
	 */
	@Test
	public void testGetDistinctAuth() {
		try{
			pdfGenDAOImpl.getDistinctAuth();
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test get distinct cat.
	 */
	@Test
	public void testGetDistinctCat() {
		try{
			pdfGenDAOImpl.getDistinctCat();
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

}
