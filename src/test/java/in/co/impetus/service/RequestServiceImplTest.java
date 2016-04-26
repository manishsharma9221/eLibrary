package in.co.impetus.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.when;
import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.Plans;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;
import in.co.impetus.db.dao.BookSearchDAO;
import in.co.impetus.db.dao.RegisterDao;
import in.co.impetus.db.dao.RequestDAO;
import in.co.impetus.db.dao.ShelfDAO;
import in.co.impetus.service.request.RequestService;
import in.co.impetus.service.request.RequestServiceImpl;


import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;
import in.co.impetus.service.search.BookSearchServiceImpl;


public class RequestServiceImplTest 

{
    private RequestDAO requestDAO;
    private BookSearchDAO bookSearchDAO;

    @Before
    public void setUp()
    {
        requestDAO=mock(RequestDAO.class);
        bookSearchDAO=mock(BookSearchDAO.class);
    }

    @Test
    public void getRequestedBookByReqId()
    {
        RequestServiceImpl requestServiceImpl=new RequestServiceImpl() ;
        requestServiceImpl.setRequestDAO(requestDAO);	 

        RequestBook requestBook=new RequestBook();
        int requestId =2;
        requestBook.setRequestId(requestId);
        when(requestDAO.getBookByRequestId(requestId)).thenReturn(requestBook);
        assertEquals(requestBook, requestServiceImpl.getRequestedBookByReqId(requestId));


    }

    @Test
    public void getRequestedBookByBookId()
    {
        RequestServiceImpl requestServiceImpl=new RequestServiceImpl() ;
        requestServiceImpl.setRequestDAO(requestDAO);
        RequestBook requestBook=new RequestBook();
        String userName="second user";
        BookSearch book= new BookSearch();


        when(requestDAO.getRequestedBook(userName, book)).thenReturn(requestBook);
        assertEquals(requestBook,requestServiceImpl.getRequestedBookByBookId(userName, book));

    }

    @Test
    public void  checkSubscription() 
    {
        RequestServiceImpl requestServiceImpl=new RequestServiceImpl() ;
        requestServiceImpl.setRequestDAO(requestDAO);

        Subscription subs=new Subscription();
        String userName="first user";

        when(requestDAO.checkSubscription(userName)).thenReturn(subs);
        assertEquals(subs,requestServiceImpl.checkSubscription(userName));


    }
    @Test
    public void cancelReturnRequest()
    {
        RequestServiceImpl requestServiceImpl=new RequestServiceImpl() ;
        requestServiceImpl.setRequestDAO(requestDAO);

        int requestId=1;
        String expected="true";	

        when(requestDAO.cancelReturnRequest(requestId)).thenReturn(expected);
        assertEquals(expected,requestServiceImpl.cancelReturnRequest(requestId));
    }

    @Test
    public void cancelDeliveryRequest()
    {
        RequestServiceImpl requestServiceImpl=new RequestServiceImpl() ;
        requestServiceImpl.setRequestDAO(requestDAO);

        int requestId=5;
        RequestBook req=new RequestBook();
        BookSearch book=new BookSearch();
        book.setBookAvailablity(7);
        req.setBookSearch(book);
        String expected="Cancelled Successfully";


        when(requestDAO.getBookByRequestId(requestId)).thenReturn(req);
        when(requestDAO.cancelDeliveryRequest(req)).thenReturn(expected);
        assertEquals(expected,requestServiceImpl.cancelDeliveryRequest(requestId));
    }

    @Test
    public void testcancelDeliveryRequest()
    {
        RequestServiceImpl requestServiceImpl=new RequestServiceImpl() ;
        requestServiceImpl.setRequestDAO(requestDAO);

        int requestId=5;
        RequestBook req=new RequestBook();
        BookSearch book=new BookSearch();
        book.setBookAvailablity(7);
        req.setBookSearch(book);
        String expected="true";


        when(requestDAO.getBookByRequestId(requestId)).thenReturn(req);
        when(requestDAO.cancelDeliveryRequest(req)).thenReturn(expected);
        assertEquals(expected,requestServiceImpl.cancelDeliveryRequest(requestId));
    }



    @Test
    public void returnBookRequest()
    {
        RequestServiceImpl requestServiceImpl=new RequestServiceImpl() ;
        requestServiceImpl.setRequestDAO(requestDAO);
        int requestId=2;
        String returnAddress="It park";
        String expected="true";

        when(requestDAO.returnBookRequest(requestId, returnAddress)).thenReturn(expected);
        assertEquals(expected, requestServiceImpl.returnBookRequest(requestId, returnAddress));
    }

    @Test
    public void testRequestBook(){
        RequestServiceImpl requestServiceImpl= new RequestServiceImpl();
        requestServiceImpl.setRequestDAO(requestDAO);
        requestServiceImpl.setBookSearchDAO(bookSearchDAO);

        Subscription subscription=new Subscription();
        Plans plan =new Plans();
        BookSearch books= new BookSearch();

        plan.setMaxBooks(5);
        plan.setMaxDays(10);
        plan.setPlanId(5);
        plan.setPlanName("abc");
        plan.setPrice(100);

        subscription.setPlan(5);
        books.setBookAvailablity(10);


        String bookId="A01";
        String uid="xxx";
        String  deliveryAddress="abc";
        String dt="xyz";
        String expected="Cannot Request More Books: Upgrade your Plan";
        when(requestDAO.countRequestedBooks(uid)).thenReturn(1);
        when(requestDAO.countHoldingBooks(uid)).thenReturn(1);
        when(requestDAO.checkSubscription(uid)).thenReturn(subscription);
        when(bookSearchDAO.getBookById(bookId)).thenReturn(books);
        when(requestDAO.requestBook(uid, bookId, deliveryAddress)).thenReturn(expected);
        assertEquals(expected,requestServiceImpl.requestBook(uid, bookId, dt, deliveryAddress));
    }

    @Test
    public void testRequestBook2(){
        RequestServiceImpl requestServiceImpl= new RequestServiceImpl();
        requestServiceImpl.setRequestDAO(requestDAO);
        requestServiceImpl.setBookSearchDAO(bookSearchDAO);

        BookSearch books= new BookSearch();
        books.setBookAvailablity(0);


        String bookId="A11";
        String uid="assd";
        String  deliveryAddress="abc";
        String dt="xyz";
        Subscription subscription = requestDAO.checkSubscription(null);

        String expected="Plan Expired. Enrol to a new Plan";

        when(requestDAO.countRequestedBooks(uid)).thenReturn(1);
        when(requestDAO.countHoldingBooks(uid)).thenReturn(1);
        when(requestDAO.checkSubscription(uid)).thenReturn(subscription);
        when(bookSearchDAO.getBookById(bookId)).thenReturn(books);
        when(requestDAO.requestBook(uid, bookId, deliveryAddress)).thenReturn(expected);
        assertEquals(expected,requestServiceImpl.requestBook(uid, bookId, dt, deliveryAddress));
    }


    @Test
    public void testRequestBook3(){
        RequestServiceImpl requestServiceImpl= new RequestServiceImpl();
        requestServiceImpl.setRequestDAO(requestDAO);
        requestServiceImpl.setBookSearchDAO(bookSearchDAO);


        Subscription subscription=new Subscription();
        Plans plan =new Plans();
        BookSearch books= new BookSearch();


        plan.setMaxBooks(56);
        plan.setMaxDays(10);
        plan.setPlanId(5);
        plan.setPlanName("abc");
        plan.setPrice(100);

        subscription.setPlan(1);
        books.setBookAvailablity(0);


        String bookId="A11";
        String uid="assd";

        String  deliveryAddress="abc";
        String dt="xyz";

        String expected="Something Went Wrong: Contact Yash Khatri";

        when(requestDAO.countRequestedBooks(uid)).thenReturn(1);
        when(requestDAO.countHoldingBooks(uid)).thenReturn(1);
        when(requestDAO.checkSubscription(uid)).thenReturn(subscription);
        when(bookSearchDAO.getBookById(bookId)).thenReturn(books);
        when(requestDAO.requestBook(uid, bookId, deliveryAddress)).thenReturn(expected);
        assertEquals(expected,requestServiceImpl.requestBook(uid, bookId, dt, deliveryAddress));
    }


    @Test
    public void testRequestBook4(){
        RequestServiceImpl requestServiceImpl= new RequestServiceImpl();
        requestServiceImpl.setRequestDAO(requestDAO);
        requestServiceImpl.setBookSearchDAO(bookSearchDAO);

        Subscription subscription=new Subscription();
        Plans plan =new Plans();
        BookSearch books= new BookSearch();

        plan.setMaxBooks(5);
        plan.setMaxDays(10);
        plan.setPlanId(5);
        plan.setPlanName("abc");
        plan.setPrice(100);

        subscription.setPlan(5);
        subscription.setMaxBooks(10);
        books.setBookAvailablity(10);


        String bookId="A01";
        String uid="xxx";
        String deliveryAddress="abc";
        String dt="xyz";
        String expected="Already Requested";

        when(requestDAO.countRequestedBooks(uid)).thenReturn(1);
        when(requestDAO.countHoldingBooks(uid)).thenReturn(1);
        int total=requestDAO.countHoldingBooks(uid)+requestDAO.countRequestedBooks(uid);
        System.out.println("total books are " + total);
        System.out.println("max books are " +subscription.getMaxBooks());
        when(requestDAO.checkSubscription(uid)).thenReturn(subscription);
        when(bookSearchDAO.getBookById(bookId)).thenReturn(books);
        when(requestDAO.requestBook(uid, bookId, deliveryAddress)).thenReturn(expected);
        assertEquals(expected,requestServiceImpl.requestBook(uid, bookId, dt, deliveryAddress));
    }


    @Test
    public void testRequestBook5(){
        RequestServiceImpl requestServiceImpl= new RequestServiceImpl();
        requestServiceImpl.setRequestDAO(requestDAO);
        requestServiceImpl.setBookSearchDAO(bookSearchDAO);


        Subscription subscription=new Subscription();
        Plans plan =new Plans();
        BookSearch books= new BookSearch();


        plan.setMaxBooks(56);
        plan.setMaxDays(10);
        plan.setPlanId(5);
        plan.setPlanName("abc");
        plan.setPrice(100);

        subscription.setPlan(1);
        subscription.setMaxBooks(10);
        books.setBookAvailablity(0);


        String bookId="A11";
        String uid="assd";

        String  deliveryAddress="abc";
        String dt="xyz";
        boolean requested=false;
        String expected="Requested Successfully";

        if(requested)
        {
            when(requestDAO.countRequestedBooks(uid)).thenReturn(1);
            when(requestDAO.countHoldingBooks(uid)).thenReturn(1);
            int total=requestDAO.countHoldingBooks(uid)+requestDAO.countRequestedBooks(uid);
            System.out.println("total books are " + total);
            System.out.println("max books are " +subscription.getMaxBooks());
            when(requestDAO.checkSubscription(uid)).thenReturn(subscription);
            when(bookSearchDAO.getBookById(bookId)).thenReturn(books);
            requestDAO.requestBook(uid,bookId, deliveryAddress);
            requestDAO.changeAvailablity(books);
            when(requestDAO.requestBook(uid, bookId, deliveryAddress)).thenReturn(expected);
            assertEquals(expected, requestServiceImpl.requestBook(uid, bookId, dt, deliveryAddress));
        }
    }
    @Test
    public void testRequestBook6()
    {
        RequestServiceImpl requestServiceImpl= new RequestServiceImpl();
        requestServiceImpl.setRequestDAO(requestDAO);
        requestServiceImpl.setBookSearchDAO(bookSearchDAO);

        Subscription subscription=new Subscription();
        Plans plan =new Plans();
        BookSearch books= new BookSearch();

        plan.setMaxBooks(5);
        plan.setMaxDays(10);
        plan.setPlanId(5);
        plan.setPlanName("abc");
        plan.setPrice(100);

        subscription.setPlan(5);
        subscription.setMaxBooks(10);
        books.setBookAvailablity(10);

        String bookId="A11";
        String uid="assd";
        String expected="true";
        when(requestDAO.countRequestedBooks(uid)).thenReturn(1);
        when(requestDAO.countHoldingBooks(uid)).thenReturn(1);
        when(requestDAO.checkSubscription(uid)).thenReturn(subscription);
        int total=requestDAO.countHoldingBooks(uid)+requestDAO.countRequestedBooks(uid);
        System.out.println("total books are " + total);
        System.out.println("max books are " +subscription.getMaxBooks());
        when(bookSearchDAO.getBookById(bookId)).thenReturn(books);
        Boolean alreadyRequested = true;
        List<RequestBook> requestBookList=new ArrayList<>();
        RequestBook requestBook=new RequestBook();
        requestBook.setDeliveryStatus("pending");
        requestBookList.add(requestBook);
        when(requestDAO.checkIfAlreadyRequested(uid, books)).thenReturn(requestBookList);
        requestBook.setDeliveryStatus("pending");
        requestBook.getDeliveryStatus();
        assertTrue(true);
    }

}
