package in.co.impetus.db.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsersTest {

	@Test
	public void test() {
		Users user = new Users();
		
		user.setAddress("address");
		user.setCity("city");
		user.setEnabled(true);
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setMobile("mobile");
		user.setPincode(10);
		user.setPlanId(10);
		user.setPrimaryLanguage("primaryLanguage");
		user.setSecondaryLanguage("secondaryLanguage");
		user.setState("state");
		user.setUserName("userName");
		user.setUserPassword("userPassword");
		
		assertEquals("address",user.getAddress());
		assertEquals("city",user.getCity());
		assertEquals(true,user.isEnabled());
		assertEquals("firstName",user.getFirstName());
		assertEquals("lastName",user.getLastName());
		assertEquals("mobile",user.getMobile());
		assertEquals(10,user.getPincode());
		assertEquals(10,user.getPlanId());
		assertEquals("primaryLanguage",user.getPrimaryLanguage());
		assertEquals("secondaryLanguage",user.getSecondaryLanguage());
		assertEquals("state",user.getState());
		assertEquals("userName",user.getUserName());
		assertEquals("userPassword",user.getUserPassword());
		

		
		
	}

}
