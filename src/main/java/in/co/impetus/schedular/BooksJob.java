/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.schedular;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

// TODO: Auto-generated Javadoc
/**
 * The Class BooksJob.
 */
public class BooksJob extends QuartzJobBean {

    /** The books task. */
    private BooksTask booksTask;

    /**
     * Sets the books task.
     * 
     * @param booksTask
     *            the new books task
     */
    public void setBooksTask(BooksTask booksTask) {
        this.booksTask = booksTask;
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

        booksTask.printMessage();
        booksTask.addBooks();
        booksTask.deleteBooks();

    }

}
