package in.co.impetus.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.Plans;
import in.co.impetus.db.dao.PdfGenDAO;
import in.co.impetus.db.dao.SubscriptionPlansDao;
import in.co.impetus.service.subscriptionplan.SubscriptionPlanService;
import in.co.impetus.service.subscriptionplan.SubscriptionPlanServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class SubscriptionPlanServiceTest 
{
	private static SubscriptionPlansDao subscriptionPlansDao;

	@Before
	public  void setUp()
	{
		subscriptionPlansDao=mock(SubscriptionPlansDao.class);

	}

	@Test
	public void testInsertRow()
	{
		Plans plans=new Plans();
		plans.setPlanId(0);
		SubscriptionPlanServiceImpl subscriptionPlanServiceImpl=new SubscriptionPlanServiceImpl();
		subscriptionPlanServiceImpl.setSubscriptionPlansDao(subscriptionPlansDao);
		subscriptionPlanServiceImpl.insertPlans(plans);
		assertTrue(true);
	  
	}

	@Test
	public void testGetPlansList() 
	{
		SubscriptionPlanServiceImpl subscriptionPlanServiceImpl=new SubscriptionPlanServiceImpl();
		subscriptionPlanServiceImpl.setSubscriptionPlansDao(subscriptionPlansDao);
		List<Plans> plist=new ArrayList<>();
		Plans plans=new Plans();
		plans.setMaxBooks(5);
		plans.setMaxDays(60);
		plist.add(plans);

		when(subscriptionPlansDao.getPlansList()).thenReturn(plist);
		List<Plans>actual=(List<Plans>)subscriptionPlanServiceImpl.getPlansList();
		assertEquals(plist, actual);

	}

	@Test
	public void testGetRowById() 
	{
		SubscriptionPlanServiceImpl subscriptionPlanServiceImpl=new SubscriptionPlanServiceImpl();
		subscriptionPlanServiceImpl.setSubscriptionPlansDao(subscriptionPlansDao);
		Plans plans=new Plans();
		plans.setMaxBooks(5);
		plans.setMaxDays(60);
		plans.setPlanId(4);
		
		when(subscriptionPlansDao.getPlanById(4)).thenReturn(plans);
		assertEquals(plans,subscriptionPlanServiceImpl.getPlanById(4));
	}

  @Test 
  public void testDeleteRow()
  {
	  Integer planId=1;
		SubscriptionPlanServiceImpl subscriptionPlanServiceImpl=new SubscriptionPlanServiceImpl();
		subscriptionPlanServiceImpl.setSubscriptionPlansDao(subscriptionPlansDao);
		subscriptionPlanServiceImpl.deletePlan(planId);
		assertTrue(true);
	  
  }

	}


