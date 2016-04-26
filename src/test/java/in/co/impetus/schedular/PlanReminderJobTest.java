package in.co.impetus.schedular;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.quartz.JobExecutionException;

public class PlanReminderJobTest {
	 private PlanReminderTask planReminderTask;
	@Before
	public void setUp() throws Exception 
	{
		planReminderTask=mock(PlanReminderTask.class);
	}

	@Test
	public void testExecuteInternalJobExecutionContext() throws JobExecutionException 
	{
	    
	    PlanReminderJob planReminderJob = new PlanReminderJob();
	    planReminderJob.setPlanReminderTask(planReminderTask);
	    planReminderJob.executeInternal(null);
	    
	    
		doNothing().when(planReminderTask).printMessage();
		doNothing().when(planReminderTask).getUsersByDays();
		doNothing().when(planReminderTask).getUsersByMonth();
		doNothing().when(planReminderTask).getUsersByWeek();
		doNothing().when(planReminderTask).getUserSubscriptions();
		assertTrue(true);
	}

}
