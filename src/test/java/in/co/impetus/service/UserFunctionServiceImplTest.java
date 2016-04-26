package in.co.impetus.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import in.co.impetus.db.dao.RegisterDao;
import in.co.impetus.db.dao.ShelfDAO;
import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.Plans;
import in.co.impetus.db.model.Recommendation;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Users;
import in.co.impetus.service.search.BookSearchServiceImpl;
import in.co.impetus.service.userfunction.UserFunctionServiceImpl;

import java.util.List;
import java.util.ArrayList;



public class UserFunctionServiceImplTest {

private RegisterDao registerDao;
private ShelfDAO shelfDAO;

	@Before
	public void setUp() throws Exception
	{
		registerDao=mock(RegisterDao.class);
		shelfDAO=mock(ShelfDAO.class);
	}

	@Test
	public void testShowRecommendedBooks()
	{
		UserFunctionServiceImpl userFunctionServiceImpl=new UserFunctionServiceImpl();
		userFunctionServiceImpl.setShelfDAO(shelfDAO);
		
		List<BookSearch> blist=new ArrayList<>();
		BookSearch book1=new BookSearch();
		Users users=new Users();
		users.setUserName("xyz");
		book1.setBookId("a");
		book1.setBookAuthor("a");
		book1.setBookAvailablity(0);
		book1.setBookCategory("b");
		book1.setBookDescription("b");
		book1.setBookId("a01");
		book1.setBookTitle("xxx");
		book1.setBookPublisher("abc");
		book1.setBookImage("abcd.jpeg");
		blist.add(book1);
		
		when(shelfDAO.showRecommendation("xyz")).thenReturn(blist);
		List<BookSearch> actual=(List<BookSearch>) userFunctionServiceImpl.showRecommendedBooks("xyz");
		assertEquals(blist, actual);
	
	}
	
	@Test
	public void testShowProfile() 
	{

		UserFunctionServiceImpl userFunctionServiceImpl=new UserFunctionServiceImpl();
		userFunctionServiceImpl.setRegisterDao(registerDao);

		
		Users users=new Users();
		users.setFirstName("a");
		users.setLastName("b");
		users.setUserName("c");
		
		when(registerDao.getUserById("c")).thenReturn(users);
		assertEquals(users,userFunctionServiceImpl.showProfile("c"));
	}

	@Test
	public void testSaveSearchCriteria()
	{
		try
		{
		UserFunctionServiceImpl userFunctionServiceImpl=new UserFunctionServiceImpl();
		userFunctionServiceImpl.setRegisterDao(registerDao);
		
		Users users=new Users();
		users.setUserName("a");
		Recommendation recommendation = new Recommendation();
		recommendation.setSearchCriteria("xyz");
  
		userFunctionServiceImpl.saveSearchCriteria("a", "xyz");
		assertTrue(true);
		}
		catch(Exception e){
			assertTrue(false);
	}

}
}
