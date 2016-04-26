package in.co.impetus.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import in.co.impetus.db.dao.ShelfDAO;
import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;
import in.co.impetus.service.shelf.ShelfServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ShelfServiceImplTest {//done

	private ShelfDAO shelfDAO;
	
	
	@Before
	public void setUp()
	{
		   shelfDAO=mock(ShelfDAO.class);
	}

	@Test
	public void testAddToShelf() {

		ShelfServiceImpl shelfServiceImpl=new ShelfServiceImpl() ;
		shelfServiceImpl.setShelfDAO(shelfDAO);
		
		String uid="u01";
		String bid="b01";
		String expected="true";
		
		when(shelfDAO.addToShelf(bid, uid)).thenReturn(expected);
		assertEquals(expected, shelfServiceImpl.addToShelf(bid, uid));
	}
	

	@Test
	public void testRemoveFromShelf() 
	{
		ShelfServiceImpl shelfServiceImpl=new ShelfServiceImpl() ;
		shelfServiceImpl.setShelfDAO(shelfDAO);
		
		String uid="u11";
		String bid="b11";
		String expected="true";
		
		when(shelfDAO.removeFromShelf(uid, bid)).thenReturn(expected);
		assertEquals(expected, shelfServiceImpl.removeFromShelf(uid, bid));
	}

	
	@Test
	public void testShowShelf() 
	{
		ShelfServiceImpl shelfServiceImpl=new ShelfServiceImpl() ;
		shelfServiceImpl.setShelfDAO(shelfDAO);
		
		
        List<BookSearch> blist=new ArrayList<>();
		BookSearch book1=new BookSearch();
		book1.setBookAuthor("a");
		book1.setBookAvailablity(0);
		
		blist.add(book1);
		String uid="xxx";
		
		
		when(shelfDAO.showShelf(uid)).thenReturn(blist);
		List<BookSearch> actual=(List<BookSearch>)shelfServiceImpl.showShelf(uid);
		assertEquals(blist,actual);



	}

	@Test
	public void testShowBooksHolding() 
	{

		ShelfServiceImpl shelfServiceImpl=new ShelfServiceImpl() ;
		shelfServiceImpl.setShelfDAO(shelfDAO);	
		  List<RequestBook> rlist=new ArrayList<>();
		  RequestBook r1=new RequestBook();
		  r1.setRequestId(0);
		rlist.add(r1);
		String uid="abc";
		when(shelfDAO.showBooksHolding(uid)).thenReturn(rlist);
		List<RequestBook> actual=(List<RequestBook>)shelfServiceImpl.showBooksHolding(uid);
		assertEquals(rlist,actual);
  
	}

	@Test
	public void testGetSubscription() 
	{
		ShelfServiceImpl shelfServiceImpl=new ShelfServiceImpl() ;
		shelfServiceImpl.setShelfDAO(shelfDAO);	
		  List<Subscription> slist=new ArrayList<>();
		  Subscription s1=new Subscription();
		s1.getMaxBooks();
		s1.setMaxBooks(0);
slist.add(s1);
		String userId="abc";
		when(shelfDAO.getSubscription(userId)).thenReturn(slist);
		List<Subscription> actual=(List<Subscription>)shelfServiceImpl.getSubscription(userId);
		assertEquals(slist,actual);
	}
	
	@Test
	public void testShowRequestedBooks() 
	{

		ShelfServiceImpl shelfServiceImpl=new ShelfServiceImpl() ;
		shelfServiceImpl.setShelfDAO(shelfDAO);	
		  List<RequestBook> rlist=new ArrayList<>();
		  RequestBook r1=new RequestBook();
		  r1.setRequestId(0);
		rlist.add(r1);
		String uid="abc";
		when(shelfDAO.showRequestedBooks(uid)).thenReturn(rlist);
		List<RequestBook> actual=(List<RequestBook>)shelfServiceImpl.showRequestedBooks(uid);
		assertEquals(rlist,actual);
}
}