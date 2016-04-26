package in.co.impetus.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import in.co.impetus.db.dao.BooksSchedulerDAOInterface;
import in.co.impetus.service.util.BooksSchedulerManagerImpl;

import org.junit.Before;
import org.junit.Test;

public class BooksSchedulerManagerImplTest
{
	private BooksSchedulerDAOInterface booksSchedulerDAOInterface;

	@Before
	public void setUp() throws Exception
	{
		booksSchedulerDAOInterface=mock(BooksSchedulerDAOInterface.class);
	}

	@Test
	public void testAddBooks() 
	{
		BooksSchedulerManagerImpl booksSchedulerManagerImpl=new BooksSchedulerManagerImpl();
		booksSchedulerManagerImpl.setBooksSchedulerDAO(booksSchedulerDAOInterface);
		doNothing().when(booksSchedulerDAOInterface).addBooks();
		booksSchedulerManagerImpl.addBooks();
		assertTrue(true);
		
	}

	@Test
	public void testDeleteBooks() 
	{
		BooksSchedulerManagerImpl booksSchedulerManagerImpl=new BooksSchedulerManagerImpl();
		booksSchedulerManagerImpl.setBooksSchedulerDAO(booksSchedulerDAOInterface);
		doNothing().when(booksSchedulerDAOInterface).deleteBooks();
		booksSchedulerManagerImpl.deleteBooks();
		assertTrue(true);

	}

}
