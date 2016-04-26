package in.co.impetus.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import in.co.impetus.db.dao.PdfGenDAO;
import in.co.impetus.db.model.BookSearch;
import in.co.impetus.service.pdfgen.PdfGenServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;


public class PdfGenServiceImplTest {
	
	private static PdfGenDAO pdfGenDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		pdfGenDAO=mock(PdfGenDAO.class);
	}

	
	@Test
	public void testGetReports() 
	{
	    PdfGenServiceImpl pdfGenServiceImpl=new PdfGenServiceImpl();
        pdfGenServiceImpl.setPdfGenDAO(pdfGenDAO);
        List<Object[]> list  = new ArrayList<Object[]>();
        String author ="author";
        String category ="category";
        Date from = new Date();
        Date to = new Date();
        when(pdfGenDAO.getReports(author, category, from, to)).thenReturn(list);
        List<Object[]> actual=(List<Object[]>)pdfGenServiceImpl.getReports(author, category, from, to);
        assertEquals(list, actual);        
	}

	@Test
	public void testGetDistinctAuth() 
	{
		PdfGenServiceImpl pdfGenServiceImpl=new PdfGenServiceImpl();
		pdfGenServiceImpl.setPdfGenDAO(pdfGenDAO);
		
		List<BookSearch> blist=new ArrayList<>();
		BookSearch books=new BookSearch();
		books.setBookAuthor("a");
		books.setBookCategory("xyz");
		books.setBookAvailablity(5);
		blist.add(books);
	    when(pdfGenDAO.getDistinctAuth()).thenReturn(blist);
		List<BookSearch> actual=(List<BookSearch>)pdfGenServiceImpl.getDistinctAuth();
        assertEquals(blist, actual);		
	}

	@Test
	public void testGetDistinctCat()
	{
		PdfGenServiceImpl pdfGenServiceImpl=new PdfGenServiceImpl();
		pdfGenServiceImpl.setPdfGenDAO(pdfGenDAO);
		
		List<BookSearch> blist=new ArrayList<>();
		BookSearch books=new BookSearch();
		books.setBookAuthor("a");
		books.setBookCategory("xyz");
		books.setBookAvailablity(5);
		blist.add(books);
		when(pdfGenDAO.getDistinctCat()).thenReturn(blist);
		List<BookSearch> actual=(List<BookSearch>)pdfGenServiceImpl.getDistinctCat();
        assertEquals(blist, actual);
	}

}
