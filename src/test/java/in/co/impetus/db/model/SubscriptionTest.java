package in.co.impetus.db.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class SubscriptionTest {

	@Test
	public void test() {
		Subscription subscription = new Subscription();

		Date date = new Date();
		subscription.setEndDate(date);
		
		subscription.setIsActive(true);
		subscription.setMaxBooks(10);
		subscription.setMaxDays(10);
		subscription.setPlan(10);
		subscription.setPlanName("planName");
		subscription.setPrice(10);
		subscription.setStartDate(date);
		subscription.setSubscriptionId(10);
		subscription.setUserName("userName");
		
		assertEquals(date,subscription.getEndDate() );
		assertEquals(true,subscription.getIsActive() );
		assertEquals(10,subscription.getMaxBooks() );
		assertEquals(10,subscription.getMaxDays() );
		assertEquals(10,subscription.getPlan());
		assertEquals("planName",subscription.getPlanName());
		assertEquals(10,subscription.getPrice() );
		assertEquals(date,subscription.getStartDate() );
		assertEquals(10,subscription.getSubscriptionId() );
		assertEquals("userName",subscription.getUserName() );

		
	}

}
