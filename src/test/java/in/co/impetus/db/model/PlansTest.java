package in.co.impetus.db.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlansTest {

	@Test
	public void test() {
		
		Plans plans = new Plans();
		
		plans.setMaxBooks(10);
		plans.setMaxDays(10);
		plans.setPlanId(10);
		plans.setPlanName("planName");
		plans.setPrice(10);
		
		assertEquals(10,plans.getMaxBooks());
		assertEquals(10,plans.getMaxDays());
		assertEquals(10,plans.getPlanId());
		assertEquals(10,plans.getPrice());
		assertEquals("planName",plans.getPlanName());





	}

}
