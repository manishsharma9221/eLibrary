package in.co.impetus.db.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class RolesTest {

	@Test
	public void test() {
	
		Roles roles = new Roles();
		
		roles.setRoleId("roleId");
		roles.setSno(10);
		roles.setUserName("userName");

		assertEquals("roleId",roles.getRoleId());
		assertEquals(10,roles.getSno());
		assertEquals("userName",roles.getUserName());
	}

}
