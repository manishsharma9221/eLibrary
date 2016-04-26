package in.co.impetus.db.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecommendationTest {

	@Test
	public void test() {
		
		Recommendation recommendation = new Recommendation();
		
		recommendation.setRecId(10);
		recommendation.setSearchCriteria("searchCriteria");
		recommendation.setUserName("userName");
		
		assertEquals(10,recommendation.getRecId());
		assertEquals("searchCriteria",recommendation.getSearchCriteria());
		assertEquals("userName",recommendation.getUserName());
		
		
	}

}
