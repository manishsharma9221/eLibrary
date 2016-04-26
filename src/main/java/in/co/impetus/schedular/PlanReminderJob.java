/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.schedular;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanReminderJob.
 */
public class PlanReminderJob extends QuartzJobBean {

    /** The plan reminder task. */
    private PlanReminderTask planReminderTask;


    /**
     * Sets the plan reminder task.
     * 
     * @param planReminderTask
     *            the new plan reminder task
     */
    public void setPlanReminderTask(PlanReminderTask planReminderTask) {
        this.planReminderTask = planReminderTask;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org
     * .quartz.JobExecutionContext)
     */
    @Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException {

         planReminderTask.printMessage();
       
         planReminderTask.getUsersByMonth();
         planReminderTask.getUsersByDays();
         planReminderTask.getUsersByWeek();
         planReminderTask.getUserSubscriptions();

    }

}
