/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import static org.junit.Assert.*;

import java.sql.Date;

import in.co.impetus.db.model.Subscription;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanReminderDAOImplTest.
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/java/resources/applicationContext.xml"})
public class PlanReminderDAOImplTest {

	

	/** The plan reminder dao impl. */
	@Autowired
	private PlanReminderDAOImpl planReminderDAOImpl;
	
	/**
	 * Test get users by month.
	 */
	@Test
	public void testGetUsersByMonth() {
		try{
			planReminderDAOImpl.getUsersByMonth();
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test get users by week.
	 */
	@Test
	public void testGetUsersByWeek() {
		try{
			planReminderDAOImpl.getUsersByWeek();
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test get users by days.
	 */
	@Test
	public void testGetUsersByDays() {
		try{
			planReminderDAOImpl.getUsersByDays();
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test get user subscriptions.
	 */
	@Test
	public void testGetUserSubscriptions() {
		try{
			planReminderDAOImpl.getUserSubscriptions();
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	/**
	 * Test update subscription.
	 */
	@Test
	public void testUpdateSubscription() {
		try{
			Date date = new Date(new java.util.Date().getTime());
			Subscription subscription = new Subscription("as@as.com",3,date ,date, false, 10,10,10,"Test");
			planReminderDAOImpl.updateSubscription(subscription);
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}
	
	
}
