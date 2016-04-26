package in.co.impetus.schedular;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import in.co.impetus.db.model.Subscription;
import in.co.impetus.mailsender.MailSender;
import in.co.impetus.service.planreminder.PlanReminderService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class PlanReminderTaskTest
{
    @InjectMocks
    private PlanReminderTask planReminderTask;
    //@Mock
    private PlanReminderService planReminderService;
    //@Mock
    private MailSender sendMail;


    @Before
    public void setUp() throws Exception 
    {
        //MockitoAnnotations.initMocks(this);
        planReminderService=mock(PlanReminderService.class);
        sendMail=mock(MailSender.class);

    }

    @Test
    public void testPrintMessage() 
    {

        PlanReminderTask planReminderTask=new PlanReminderTask();
        planReminderTask.printMessage();
        assertTrue(true);
    }

    @Test
    public void testGetUsersByMonth() 
    {
        PlanReminderTask planReminderTask=new PlanReminderTask();
        planReminderTask.setPlanReminderService(planReminderService);
        planReminderTask.setSendMail(sendMail);
        List<Subscription> slist=new ArrayList<>();
        Subscription subs=new Subscription();
        subs.setMaxBooks(5);
        subs.setMaxDays(60);
        slist.add(subs);
        planReminderTask.getUsersByMonth();

        when(planReminderService.getUsersByMonth()).thenReturn(slist);
        planReminderTask.shootReminderMails(slist);

        try {
            doNothing().when(sendMail).shootReminderMail(null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Exception "+e);
        }
        assertTrue(true);

    }

    @Test
    public void testGetUsersByWeek() 
    {
        PlanReminderTask planReminderTask=new PlanReminderTask();
        planReminderTask.setPlanReminderService(planReminderService);
        List<Subscription> slist=new ArrayList<>();
        Subscription subs=new Subscription();
        subs.setMaxBooks(5);
        subs.setMaxDays(60);
        slist.add(subs);
        planReminderTask.getUsersByWeek();

        when(planReminderService.getUsersByWeek()).thenReturn(slist);
        assertTrue(true);
    }


    @Test
    public void testGetUsersByDays() 
    {
        PlanReminderTask planReminderTask=new PlanReminderTask();
        planReminderTask.setPlanReminderService(planReminderService);
        List<Subscription> slist=new ArrayList<>();
        Subscription subs=new Subscription();
        subs.setMaxBooks(5);
        subs.setMaxDays(60);
        slist.add(subs);
        planReminderTask.getUsersByDays();

        when(planReminderService.getUsersByDays()).thenReturn(slist);
        assertTrue(true);
    }

    @Test
    public void testGetUserSubscriptions() 
    {
        PlanReminderTask planReminderTask=new PlanReminderTask();
        planReminderTask.setPlanReminderService(planReminderService);
        List<Subscription> slist=new ArrayList<>();
        Subscription subs=new Subscription();
        subs.setMaxBooks(5);
        subs.setMaxDays(60);
        slist.add(subs);
        planReminderTask.getUserSubscriptions();
        when(planReminderService.getUserSubscriptions()).thenReturn(slist);
        doNothing().when(planReminderService).updateSubscription(subs);
        assertTrue(true);
    }

    @Test
    public void testGetUserSubscriptionsSecondPart() 
    {
        PlanReminderTask planReminderTask=new PlanReminderTask();
        planReminderTask.setPlanReminderService(planReminderService);
        List<Subscription> slist=new ArrayList<Subscription>();
        Subscription subs=new Subscription();
        subs.setMaxBooks(5);
        subs.setMaxDays(60);
        subs.setIsActive(false);
        slist.add(subs);
        planReminderTask.getUserSubscriptions();
        when(planReminderService.getUserSubscriptions()).thenReturn(slist);
        doNothing().when(planReminderService).updateSubscription(subs);
        assertTrue(true);
    }
    
    /*	@Test
	public void testShootReminderMails() 
	{	
	PlanReminderTask planReminderTask=new PlanReminderTask();
	planReminderTask.setPlanReminderService(planReminderService);
	List<Subscription> slist=new ArrayList<>();
	Subscription subs=new Subscription();
	subs.setMaxBooks(5);
	subs.setMaxDays(60);
	slist.add(subs);
	when(planReminderService.getUsersByMonth()).thenReturn(slist);
	planReminderTask.shootReminderMails(slist);

	}
     */
}
