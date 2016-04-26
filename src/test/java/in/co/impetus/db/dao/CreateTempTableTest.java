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
@ContextConfiguration(locations = {"file:src/test/java/resources/applicationContext.xml"})
public class CreateTempTableTest {

	@Autowired
	private CreateTempTable createTempTable;
	
	@Test
	public void testCreateTable() {
		try{
			createTempTable.createTable();
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

	@Test
	public void testCreateDeleteTable() {
		try{
			createTempTable.createDeleteTable();
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}

}
